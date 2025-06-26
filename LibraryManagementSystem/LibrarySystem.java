import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "OOP Concepts", "Bjarne Stroustrup"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        User user = new User(101, "Alice");

        while (true) {
            System.out.println("\n1. View Books\n2. Issue Book\n3. Return Book\n4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId, user);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Exiting System.");
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
}

