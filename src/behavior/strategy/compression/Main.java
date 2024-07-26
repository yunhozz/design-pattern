package behavior.strategy.compression;

import behavior.strategy.compression.strategy.RunLengthEncoding;
import behavior.strategy.compression.strategy.SimpleReplacementCompression;

public class Main {

    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        String data = "aabcccccaaa";

        compressor.setCompressionStrategy(new RunLengthEncoding());
        System.out.println("RLE Compression: " + compressor.compress(data)); // RLE Compression: a2b1c5a3

        compressor.setCompressionStrategy(new SimpleReplacementCompression());
        System.out.println("Simple Replacement: " + compressor.compress(data)); // Simple Replacement: 11bccccc111
    }
}
