package structure.proxy;

import java.util.ArrayList;
import java.util.List;

interface BankAccount {
    void withdraw(String user, double amount);
}

class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(String user, double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(user + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(user + " attempted to withdraw " + amount + ". Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ProxyBankAccount implements BankAccount {
    private final RealBankAccount realBankAccount;
    private final List<String> authorizedUsers;

    public ProxyBankAccount(double initialBalance) {
        this.realBankAccount = new RealBankAccount(initialBalance);
        this.authorizedUsers = new ArrayList<>();
        authorizedUsers.add("Alice");
        authorizedUsers.add("Bob");
    }

    @Override
    public void withdraw(String user, double amount) {
        if (checkAccess(user)) {
            realBankAccount.withdraw(user, amount);
            logAccess(user, amount);
        } else {
            System.out.println("ProxyBankAccount: Access denied for user " + user);
        }
    }

    private boolean checkAccess(String user) {
        System.out.println("ProxyBankAccount: Checking access for user " + user);
        return authorizedUsers.contains(user);
    }

    private void logAccess(String user, double amount) {
        System.out.println("ProxyBankAccount: Logging the withdrawal of " + amount + " by user " + user);
    }
}

class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount proxyAccount = new ProxyBankAccount(1000.0);
        proxyAccount.withdraw("Alice", 100.0); // Authorized user
        proxyAccount.withdraw("Charlie", 50.0); // Unauthorized user
    }
}