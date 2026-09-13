package Builder;

class Computer {
    final String processor;
    final String ram;
    final String graphicCard;
    final String storage;

    Computer(Builder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.graphicCard = builder.graphicCard;
        this.storage = builder.storage;
    }

    static class Builder {
        private String processor;
        private final String ram;
        private String graphicCard = "Встроенная";
        private String storage = "512Gb";

        public Builder(String processor, String ram) {
            this.processor = processor;
            this.ram = ram;
        }

        public Builder setGraphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder("Intel", "16Gb")
                .setGraphicCard("RTX_4070")
                .setStorage("1Tb")
                .build();
        
        System.out.println("ПК состоит из: " + pc.processor + ", " + pc.ram + ", " + pc.graphicCard);
    }
}