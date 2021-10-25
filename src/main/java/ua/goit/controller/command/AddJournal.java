package ua.goit.controller.command;

import ua.goit.model.Journal;
import ua.goit.repository.PublicationStorage;
import ua.goit.view.View;

import static ua.goit.controller.command.Commands.ADD_JOURNAL;

public class AddJournal implements Command {
    private final View view;
    private final PublicationStorage storage;

    public AddJournal(View view, PublicationStorage storage) {
        this.view = view;
        this.storage = storage;
    }

    @Override
    public boolean canProcess(String input) {
        return input.equals(ADD_JOURNAL.getName());
    }

    @Override
    public void process() {
        view.write("Enter journal name:");
        String journalName = view.read();
        int countPages = 0;
        int number = 0;
        int publicationYear = 0;
        while (true) {
            try {
                view.write("Enter count of pages:");
                countPages = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Please, enter correct number:");
            }
        }
        while (true) {
            try {
                view.write("Enter journal number:");
                number = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Please, enter correct number:");
            }
        }
        while (true) {
            try {
                view.write("Enter journal publication year:");
                publicationYear = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                view.write("Please, enter correct number:");
            }
        }
        Journal journal = new Journal(journalName, countPages, number, publicationYear);
        storage.add(journal);
        view.write("Journal created");
    }
}
