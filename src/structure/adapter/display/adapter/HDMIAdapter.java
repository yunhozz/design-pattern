package structure.adapter.display.adapter;

import structure.adapter.display.equip.HDMI;

public class HDMIAdapter implements DisplayAdapter {

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
