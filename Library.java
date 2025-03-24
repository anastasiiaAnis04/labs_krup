public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Добавить книгу
    public void addBook(Book book) {
        books.add(book);
    }
}
