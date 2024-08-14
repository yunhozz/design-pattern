package structure.adapter;

// Target interface
interface ModernMessageSender {
    void sendMessage(String message, String recipient);
}

// Adaptee interface
interface OldMessageSender {
    int send(String[] messageData);
}

// Concrete Adaptee
class OldMessageSystem implements OldMessageSender {
    @Override
    public int send(String[] messageData) {
        System.out.println("OldMessageSystem: Sending message: " + messageData[0] + " to " + messageData[1]);
        return 1; // Success code
    }
}

// Adapter
class MessageAdapter implements ModernMessageSender {
    private final OldMessageSender oldSystem;

    public MessageAdapter(OldMessageSender oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void sendMessage(String message, String recipient) {
        String[] messageData = {message, recipient};
        int result = oldSystem.send(messageData);
        if (result != 1) {
            System.out.println("Failed to send message");
        }
    }
}

// Client
class MessageSystemDemo {
    public static void main(String[] args) {
        OldMessageSender oldSystem = new OldMessageSystem();
        ModernMessageSender adapter = new MessageAdapter(oldSystem);

        adapter.sendMessage("Hello, World!", "john@example.com");
    }
}