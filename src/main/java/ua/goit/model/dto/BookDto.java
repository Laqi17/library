package ua.goit.model.dto;


import java.util.Set;

public class BookDto {
    private Integer id;
    private Set<AuthorDto> authors;
    private String name;
    private int countPages;

    public BookDto(Integer id, String name, int countPages, Set<AuthorDto> author) {
        this.id = id;
        this.name = name;
        this.countPages = countPages;
        this.authors = author;
    }

    public BookDto() {
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> author) {
        this.authors = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}