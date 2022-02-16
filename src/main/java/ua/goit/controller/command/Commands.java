package ua.goit.controller.command;

public enum Commands {
    ADD_BOOK("addBook"),
    ADD_JOURNAL("addJournal"),
    ADD_AUTHOR("addAuthor"),
    EXIT("exit"),
    FIND_ALL("findAll"),
    HELP("help"),
    ADD_AUTHOR_TO_BOOK("addAuthorToBook");

    private String name;

    Commands(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
