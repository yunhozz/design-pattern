package structure.adapter;

import structure.adapter.display.adapter.DisplayAdapter;
import structure.adapter.display.adapter.HDMIAdapter;
import structure.adapter.display.adapter.USBAdapter;
import structure.adapter.display.adapter.VGAAdapter;
import structure.adapter.display.equip.HDMI;
import structure.adapter.display.equip.USB;
import structure.adapter.display.equip.VGA;
import structure.adapter.message_system.adapter.MessageAdapter;
import structure.adapter.message_system.sender.OldMessageSender;
import structure.adapter.message_system.sender.OldMessageSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        messageSystem();
        System.out.println("\n-------------------------------\n");
        display();
    }

    private static void messageSystem() {
        OldMessageSender messageSystem = new OldMessageSystem();
        MessageAdapter messageAdapter = new MessageAdapter(messageSystem);
        messageAdapter.sendMessage("Hello, World!", "john@example.com");
    }

    private static void display() {
        USB usb = new USB();
        HDMI hdmi = new HDMI();
        VGA vga = new VGA();

        List<DisplayAdapter> adapters = new ArrayList<>() {{
            add(new USBAdapter(usb, "Video Data"));
            add(new HDMIAdapter(hdmi, 1080));
            add(new VGAAdapter(vga, true));
        }};

        for (DisplayAdapter adapter : adapters) {
            adapter.display();
        }
    }
}
