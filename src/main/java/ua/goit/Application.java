package ua.goit;

import ua.goit.controller.LibraryController;
import ua.goit.config.DatabaseManager;
import ua.goit.config.PostgresHikariProvider;
import ua.goit.config.PropertiesUtil;
import ua.goit.model.converter.JournalConverter;
import ua.goit.model.dao.JournalDao;
import ua.goit.repository.*;
import ua.goit.service.JournalService;
import ua.goit.view.Console;
import ua.goit.view.View;


public class Application {

    public static void main(String[] args) {
        PropertiesUtil util = new PropertiesUtil();

        DatabaseManager dbConnector = new PostgresHikariProvider(util.getHostname(), util.getPort(), util.getSchema(),
                util.getUser(), util.getPassword());

        Repository<JournalDao> repository = new JournalRepository(dbConnector);
        JournalConverter converter = new JournalConverter();
        JournalService service = new JournalService(repository, converter);

        View view = new Console();
        PublicationStorage storage = new InMemoryListStorage();
        AuthorStorage authorStorage = new InMemoryAuthorStorage();
        LibraryController controller = new LibraryController(view, storage, authorStorage, service);
        controller.run();
    }
}
