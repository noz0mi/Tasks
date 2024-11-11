package task2;



import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Effective Java", 2017, "Joshua Bloch");
        Book book2 = new Book("Java: Complete Reference", 2020, "Herbert Schildt");
        Book book3 = new Book("Core Java Volume I", 2019, "Cay S. Hotstmann");
        Book book4 = new Book("Orlando", 1928, "Virginia Woolf");

        Student student1 = new Student("Maria", 22, 5);
        Student student2 = new Student("Frederick", 19, 2);
        Student student3 = new Student("Elisa", 42, 5);
        Student student4 = new Student("Andrei", 24, 4);

        student1.setBooks(asList(book1, book2, book3, book4));
        student2.setBooks(asList(book1, book2, book3));
        student3.setBooks(asList(book1, book2, book3, book4));
        student4.setBooks(asList(book1, book3));

        Set<Student> students = new HashSet<>(asList(student1,student2,student3,student4));

        students.stream()
                .map(student -> student.getBooks())
                .flatMap(books -> books.stream())
                .map(book -> book.getPublicationYear())
                .filter(n -> n == 1927)
                .findAny().ifPresentOrElse(n -> System.out.println(n),
                        () -> System.out.println("Книга с таким годом публикации отсутствует"));

    }
}
