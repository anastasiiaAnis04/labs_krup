import java.util.List;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Добавление тестовых данных
        library.addBook(new Book("1", "Война и мир", "Лев Толстой", 1869));
        library.addBook(new Book("2", "Преступление и наказание", "Фёдор Достоевский", 1866));
        library.addBook(new Book("3", "1984", "Джордж Оруэлл", 1949));

        while (true) {
            System.out.println("\n=== Библиотечная система ===");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Найти книгу по названию");
            System.out.println("4. Найти книгу по автору");
            System.out.println("5. Взять книгу");
            System.out.println("6. Вернуть книгу");
            System.out.println("7. Показать все книги");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    removeBook(library, scanner);
                    break;
                case 3:
                    findBooksByTitle(library, scanner);
                    break;
                case 4:
                    findBooksByAuthor(library, scanner);
                    break;
                case 5:
                    borrowBook(library, scanner);
                    break;
                case 6:
                    returnBook(library, scanner);
                    break;
                case 7:
                    showAllBooks(library);
                    break;
                case 0:
                    System.out.println("Выход из системы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addBook(Library library, Scanner scanner) {
        System.out.print("Введите ID книги: ");
        String id = scanner.nextLine();
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите год издания: ");
        int year = scanner.nextInt();

        library.addBook(new Book(id, title, author, year));
        System.out.println("Книга успешно добавлена!");
    }

    private static void removeBook(Library library, Scanner scanner) {
        System.out.print("Введите ID книги для удаления: ");
        String id = scanner.nextLine();

        if (library.removeBook(id)) {
            System.out.println("Книга успешно удалена!");
        } else {
            System.out.println("Книга с таким ID не найдена.");
        }
    }

    private static void findBooksByTitle(Library library, Scanner scanner) {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();

        List<Book> books = library.findBooksByTitle(title);
        if (books.isEmpty()) {
            System.out.println("Книги с таким названием не найдены.");
        } else {
            System.out.println("Найденные книги:");
            books.forEach(System.out::println);
        }
    }

    private static void findBooksByAuthor(Library library, Scanner scanner) {
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        List<Book> books = library.findBooksByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("Книги этого автора не найдены.");
        } else {
            System.out.println("Найденные книги:");
            books.forEach(System.out::println);
        }
    }

    private static void borrowBook(Library library, Scanner scanner) {
        System.out.print("Введите ID книги для аренды: ");
        String id = scanner.nextLine();

        if (library.borrowBook(id)) {
            System.out.println("Книга успешно взята в аренду!");
        } else {
            System.out.println("Книга не найдена или уже занята.");
        }
    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Введите ID книги для возврата: ");
        String id = scanner.nextLine();

        if (library.returnBook(id)) {
            System.out.println("Книга успешно возвращена!");
        } else {
            System.out.println("Книга не найдена или уже возвращена.");
        }
    }

    private static void showAllBooks(Library library) {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("В библиотеке нет книг.");
        } else {
            System.out.println("Список всех книг:");
            books.forEach(System.out::println);
        }
    }
}
