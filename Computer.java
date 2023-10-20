class Computer {
    private String model;
    private int ram; // в гигабайтах
    private int hdd; // в гигабайтах
    private String os;
    private String color;

    public Computer(String model, int ram, int hdd, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}
