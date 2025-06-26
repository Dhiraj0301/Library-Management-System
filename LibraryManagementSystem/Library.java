import java.util.*;

public class Library {
    private List<Book> books;
    private Map<Integer, Integer> issuedBooks; // bookId -> userId

    public Library() {
        books = new ArrayList<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void viewBooks() {
        for (Book b : books) {
            System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor() +
                (b.isIssued() ? " [Issued]" : " [Available]"));
        }
    }

    public void issueBook(int bookId, User user) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.issueBook();
                issuedBooks.put(bookId, user.getUserId());
                System.out.println("Book issued to " + user.getName());
                return;
            }
        }
        System.out.println("Book not available for issue.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId && b.isIssued()) {
                b.returnBook();
                issuedBooks.remove(bookId);
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}

