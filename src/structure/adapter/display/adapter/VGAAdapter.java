package structure.adapter.display.adapter;

import structure.adapter.display.equip.VGA;

public class VGAAdapter implements DisplayAdapter {

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
