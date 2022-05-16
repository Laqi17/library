package ua.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.model.ErrorMessage;
import ua.goit.model.dao.BookDao;
import ua.goit.model.dto.BookDto;
import ua.goit.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookValidator {
    private final BookRepository bookRepository;

    @Autowired
    public BookValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ErrorMessage validateCreateBook(HttpServletRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();
        List<String> errors = new ArrayList<>();

        try {
            Integer.parseInt(request.getParameter("countPages"));
        } catch (Exception e) {
            errors.add("Count pages number is invalid");
        }

        String name = request.getParameter("bookName");
        if (name.isBlank()) {
            errors.add("Book title can not be empty");
        }
        List<BookDao> savedBooks = bookRepository.findByName(name);

        if (!savedBooks.isEmpty()) {
            errors.add(String.format("Book title %s already exist", name));
        }

        try {
            Set<Integer> authorIds = Arrays.stream(request.getParameterValues("authorId"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            if (authorIds.isEmpty()) {
                errors.add("Authors must be set");
            }
        } catch (Exception e) {
            errors.add("Authors must be set");
        }

        errorMessage.setErrors(errors);

        return errorMessage;
    }

    public ErrorMessage validateCreateBook(BookDto dto) {
        ErrorMessage errorMessage = new ErrorMessage();
        List<String> errors = new ArrayList<>();

        if (Objects.isNull(dto.getName()) || dto.getName().isBlank()) {
            errors.add("Book title can not be empty");
        }

        if (Objects.isNull(dto.getCountPages())) {
            errors.add("Count pages number is invalid");
        }

        if (Objects.isNull(dto.getAuthors()) || dto.getAuthors().isEmpty()) {
            errors.add("Authors must be set");
        }

        List<BookDao> savedBooks = bookRepository.findByName(dto.getName());

        if (!savedBooks.isEmpty()) {
            errors.add(String.format("Book title %s already exist", dto.getName()));
        }

        errorMessage.setErrors(errors);

        return errorMessage;
    }
}
