package behavior.publisher_subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Message {
    private final String content;
    private final String topic;

    public Message(String content, String topic) {
        this.content = content;
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public String getTopic() {
        return topic;
    }
}

interface Publisher {
    void publish(Message message);
}

interface Subscriber {
    void update(Message message);
}

class NewsBroker {
    private final Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void subscribe(String topic, Subscriber subscriber) {
        subscribers.computeIfAbsent(topic, k -> new ArrayList<>())
                .add(subscriber);
    }

    public void publish(Message message) {
        List<Subscriber> topicSubscribers = subscribers.get(message.getTopic());
        if (topicSubscribers != null) {
            for (Subscriber subscriber : topicSubscribers) {
                subscriber.update(message);
            }
        }
    }
}

// Concrete Publisher
class NewsPublisher implements Publisher {
    private final NewsBroker broker;

    public NewsPublisher(NewsBroker broker) {
        this.broker = broker;
    }

    @Override
    public void publish(Message message) {
        System.out.println(
                "Publishing: " + message.getContent()
                        + " on topic: " + message.getTopic());
        broker.publish(message);
    }
}

// Concrete Subscriber
class NewsSubscriber implements Subscriber {
    private final String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Message message) {
        System.out.println(
                name + " received: " + message.getContent()
                        + " on topic: " + message.getTopic());
    }
}

class NewsDemo {
    public static void main(String[] args) {
        NewsBroker broker = new NewsBroker();
        NewsPublisher publisher = new NewsPublisher(broker);
        NewsSubscriber subscriber1 = new NewsSubscriber("Subscriber 1");
        NewsSubscriber subscriber2 = new NewsSubscriber("Subscriber 2");

        broker.subscribe("sports", subscriber1);
        broker.subscribe("weather", subscriber2);
        broker.subscribe("sports", subscriber2);

        publisher.publish(new Message("Liverpool won the match", "sports"));
        publisher.publish(new Message("It's sunny today", "weather"));
    }
}