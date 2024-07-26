package behavior.strategy.compression.strategy;

import behavior.strategy.compression.CompressionStrategy;

public class SimpleReplacementCompression implements CompressionStrategy {

    @Override
    public String compress(String data) {
        return data.replace("a", "1")
                .replace("e", "2")
                .replace("i", "3")
                .replace("o", "4")
                .replace("u", "5");
    }
}
