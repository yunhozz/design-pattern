package behavior.publisher_subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Publisher
class MarketingDepartment {

    private final EmailDeliveryService emailService;
    private final String eventType;

    public MarketingDepartment(EmailDeliveryService emailService, String eventType) {
        this.emailService = emailService;
        this.eventType = eventType;
    }

    public void launchCampaign(String message) {
        System.out.println("Launching campaign: " + message);
        emailService.sendEmails(eventType, message);
    }
}

// Subscriber Interface
interface Customer {
    void receiveEmail(String message);
}

// Concrete Subscriber
class IndividualCustomer implements Customer {
    private final String name;

    public IndividualCustomer(String name) {
        this.name = name;
    }

    @Override
    public void receiveEmail(String message) {
        System.out.println(name + " is receiving email async: " + message);
        try {
            Thread.sleep(5000);  // Simulating email reading time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " finished reading email: " + message);
    }
}

// Broker (Asynchronous)
class EmailDeliveryService {

    private final Map<String, List<Customer>> customerGroups = new HashMap<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void subscribe(String eventType, Customer customer) {
        customerGroups.computeIfAbsent(eventType, k -> new ArrayList<>())
                .add(customer);
    }

    public void sendEmails(String eventType, String message) {
        List<Customer> customers = customerGroups.get(eventType);
        if (customers != null) {
            for (Customer customer : customers) {
                executor.submit(() ->
                        customer.receiveEmail(message)
                );
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}

class EmailServiceDemo {
    public static void main(String[] args) {
        EmailDeliveryService emailService = new EmailDeliveryService();
        MarketingDepartment marketing = new MarketingDepartment(emailService, "ProductLaunch");

        Customer customer1 = new IndividualCustomer("Customer 1");
        Customer customer2 = new IndividualCustomer("Customer 2");
        emailService.subscribe("ProductLaunch", customer1);
        emailService.subscribe("ProductLaunch", customer2);

        marketing.launchCampaign("New Product");

        Customer customer3 = new IndividualCustomer("Customer 3");
        emailService.subscribe("ProductLaunch", customer3);

        marketing.launchCampaign("Update");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        emailService.shutdown();
    }
}