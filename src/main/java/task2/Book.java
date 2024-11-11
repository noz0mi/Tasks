package task2;

public class Book {
    private String name;
    private Integer publicationYear;
    private String author;

    public Book(String name, Integer publicationYear, String author) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
