package ua.goit.service;

import ua.goit.exception.AuthorAlreadyExistException;
import ua.goit.exception.AuthorNotFoundException;
import ua.goit.model.converter.AuthorConverter;
import ua.goit.model.dto.AuthorDto;
import ua.goit.repository.AuthorRepository;

public class AuthorService {
    private AuthorRepository authorRepository;
    private AuthorConverter converter;

    public AuthorService(AuthorRepository authorRepository, AuthorConverter converter) {
        this.authorRepository = authorRepository;
        this.converter = converter;

    }

    public AuthorDto findById(Integer id) {
        return converter.from(authorRepository.findByID(id).orElseThrow(() -> new AuthorNotFoundException(String.format("Author with id - %s does not exist", id))));
    }

    public AuthorDto findByEmail(String email) {
        return converter.from(authorRepository.findByEmail(email).orElseThrow(() -> new AuthorNotFoundException(String.format("Author with email - %s does not exist", email))));
    }

    public boolean isAuthorExistByEmail(String email) {
        return authorRepository.findByEmail(email).isPresent();
    }

    public void save(AuthorDto authorDto) {
        if (authorRepository.findByEmail(authorDto.getEmail()).isEmpty()) {
            authorRepository.save(converter.to(authorDto));
        } else {
            throw new AuthorAlreadyExistException("This author is exist already");
        }
    }
}
