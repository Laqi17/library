package ua.goit;

import java.util.Arrays;

public class Storage {
    private Publication[] publications;
    private final static int DEFAULT_SIZE = 16;
    private int cursor = 0;
    private final static double LOAD_FACTOR = 3 / 2 + 1;

    public Storage() {
        this.publications = new Publication[DEFAULT_SIZE];
    }

    public Storage(int size) {
        this.publications = new Publication[size];
    }

    public void add(Publication publication) {
        if (publications.length <= cursor) {
            int newSize = (int) (publications.length * LOAD_FACTOR);
            publications = Arrays.copyOf(publications, newSize);
        }
        publications[this.cursor] = publication;
        cursor++;
    }

    public void remove(Publication publication) {
        for (int i = 0; i < publications.length; i++) {
            if (publications[i].equals(publication)) {
                publications[i] = null;
            }
        }
    }

    public Publication remove(int index) {
        if (index >= publications.length || index < 0) {
            return null;
        }
        Publication publication = publications[index];
        publications[index] = null;
        return publication;
    }


    public Publication[] findAll() {
        return Arrays.copyOf(publications, publications.length);
    }


}
