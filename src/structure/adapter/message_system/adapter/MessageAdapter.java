package structure.adapter.message_system.adapter;

import structure.adapter.message_system.sender.ModernMessageSender;
import structure.adapter.message_system.sender.OldMessageSender;

public class MessageAdapter implements ModernMessageSender {

    private final OldMessageSender oldMessageSender;

    public MessageAdapter(OldMessageSender oldMessageSender) {
        this.oldMessageSender = oldMessageSender;
    }

    @Override
    public void sendMessage(String message, String recipient) {
        String[] messageData = {message, recipient};
        int result = oldMessageSender.send(messageData);
        if (result != 1) {
            System.out.println("Failed to send message");
        }
    }
}
