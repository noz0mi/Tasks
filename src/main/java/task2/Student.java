package task2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Integer age;
    private Integer stage;
    private List<Book> books = new ArrayList<>();

    public Student(String name, Integer age, Integer stage) {
        this.name = name;
        this.age = age;
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
