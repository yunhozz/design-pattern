package structure.adapter.display.adapter;

import structure.adapter.display.equip.USB;

public class USBAdapter implements DisplayAdapter {

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
