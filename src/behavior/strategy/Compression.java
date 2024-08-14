package behavior.strategy;

interface CompressionStrategy {
    String compress(String data);
}

class RunLengthEncoding implements CompressionStrategy {
    @Override
    public String compress(String data) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= data.length(); i++) {
            if (i < data.length() && data.charAt(i) == data.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(data.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }
        return compressed.toString();
    }
}

class SimpleReplacementCompression implements CompressionStrategy {
    @Override
    public String compress(String data) {
        return data.replace("a", "1")
                .replace("e", "2")
                .replace("i", "3")
                .replace("o", "4")
                .replace("u", "5");
    }
}

class Compressor {
    private CompressionStrategy strategy;

    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public String compress(String data) {
        return strategy.compress(data);
    }
}

class CompressionDemo {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        String data = "aabcccccaaa";

        compressor.setCompressionStrategy(new RunLengthEncoding());
        System.out.println("RLE Compression: " + compressor.compress(data));
        // RLE Compression: a2b1c5a3

        compressor.setCompressionStrategy(new SimpleReplacementCompression());
        System.out.println("Simple Replacement: " + compressor.compress(data));
        // Simple Replacement: 11bccccc111
    }
}