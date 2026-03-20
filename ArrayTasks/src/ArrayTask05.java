import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Книга: " + title + " (Автор: " + author + ")";
    }
}

public class ArrayTask05 {
    public static void main(String[] args) {

        Book book1 = new Book("Особое Мясо", "Агустина Бастеррика");
        Book book2 = new Book("Долгая прогулка", "Стивен Кинг");
        Book book3 = new Book("Особое Мясо", "Хабибрахманов Руфат");
        Book book4 = new Book("Оно", "Стивен Кинг");
        Book book5 = new Book("Кэрри", "Стивен Кинг");
        Book book6 = new Book("Сияние", "Стивен Кинг");


        ArrayList<Book> library = new ArrayList<>(List.of(book1, book2, book3, book4, book5, book6));

        Scanner s = new Scanner(System.in);
        System.out.println("Вы должны ввести имя автора для обозначения его книг");
        String name = s.nextLine();
        System.out.println();
        ArrayList<String> titles = new ArrayList<>();
        for (Book book: library) {
            if (book.author.equals(name)) {
                titles.add(book.title);
            }
        }
        System.out.println(titles);
    }
}