package structure.bridge;

// Implementor
interface MessageSender {
    void sendMessage(String message);
}

// Concrete Implementors
class EmailSender implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

class SMSSender implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

// Abstraction
abstract class Message {
    protected MessageSender messageSender;

    protected Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String message);
}

// Refined Abstractions
class TextMessage extends Message {

    public TextMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        messageSender.sendMessage("Text Message: " + message);
    }
}

class EncryptedMessage extends Message {

    public EncryptedMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        String encryptedMessage = encrypt(message);
        messageSender.sendMessage("Encrypted Message: " + encryptedMessage);
    }

    private String encrypt(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}

// Client
class MessageSenderDemo {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        Message textMessage = new TextMessage(emailSender);
        textMessage.send("Hello World!");

        Message encryptedMessage = new EncryptedMessage(smsSender);
        encryptedMessage.send("Hello World!");
    }
}