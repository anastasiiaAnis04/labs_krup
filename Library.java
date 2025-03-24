import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Добавить книгу
    public void addBook(Book book) {
        books.add(book);
    }
    // Удалить книгу по ID
    public boolean removeBook(String id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    // Найти книгу по названию
    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Найти книгу по автору
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Взять книгу в аренду
    public boolean borrowBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    // Вернуть книгу
    public boolean returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    // Получить список всех книг
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
