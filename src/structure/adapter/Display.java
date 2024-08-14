package structure.adapter;

import java.util.ArrayList;
import java.util.List;

// The target interface
interface DisplayAdapter {
    void display();
}

// Adaptees
class USB {
    void connectWithUsbCable(String data) {
        System.out.println("Displaying via USB with data: " + data);
    }
}

class HDMI {
    void connectWithHdmiCable(int resolution) {
        System.out.println("Displaying via HDMI with resolution: " + resolution + "p");
    }
}

class VGA {
    void connectWithVgaCable(boolean highQuality) {
        System.out.println("Displaying via VGA with high quality: " + highQuality);
    }
}

class USBAdapter implements DisplayAdapter {
    private final USB usb;
    private final String data;

    public USBAdapter(USB usb, String data) {
        this.usb = usb;
        this.data = data;
    }

    @Override
    public void display() {
        usb.connectWithUsbCable(data);
    }
}

class HDMIAdapter implements DisplayAdapter {
    private final HDMI hdmi;
    private final int resolution;

    public HDMIAdapter(HDMI hdmi, int resolution) {
        this.hdmi = hdmi;
        this.resolution = resolution;
    }

    @Override
    public void display() {
        hdmi.connectWithHdmiCable(resolution);
    }
}

class VGAAdapter implements DisplayAdapter {
    private final VGA vga;
    private final boolean highQuality;

    public VGAAdapter(VGA vga, boolean highQuality) {
        this.vga = vga;
        this.highQuality = highQuality;
    }

    @Override
    public void display() {
        vga.connectWithVgaCable(highQuality);
    }
}

class DisplayDemo {
    public static void main(String[] args) {
        USB usb = new USB();
        HDMI hdmi = new HDMI();
        VGA vga = new VGA();

        List<DisplayAdapter> adapters = new ArrayList<>();
        adapters.add(new USBAdapter(usb, "Video Data"));
        adapters.add(new HDMIAdapter(hdmi, 1080));
        adapters.add(new VGAAdapter(vga, true));

        for (DisplayAdapter adapter : adapters) {
            adapter.display();
        }
    }
}