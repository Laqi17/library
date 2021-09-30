package ua.goit;

public class Storage {
    private Publication[] publications;
    private final static int DEFAULT_SIZE = 16;

    public Storage() {
        this.publications = new Publication[DEFAULT_SIZE];
    }

    public Storage(int size) {
        this.publications = new Publication[size];
    }
}