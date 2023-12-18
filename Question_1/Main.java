
import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private Book[] books;
    private int numBooks;
    public Library(int capacity) {
        books = new Book[capacity];
        numBooks = 0;
    }
    public void addBook(Book book) {
        if (numBooks < books.length) {
            books[numBooks] = book;
            numBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Method to remove a book from the library by bookID
    public void removeBook(int bookID) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getBookID() == bookID) {
                books[i] = null;
                // Move the remaining books forward in the array
                for (int j = i; j < numBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[numBooks - 1] = null;
                numBooks--;
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }
    public void searchBook(int bookID) {
        for (Book book : books) {
            if (book != null && book.getBookID() == bookID) {
                System.out.println("Book ID: " + book.getBookID() +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }
    public void displayBooks() {
        if (numBooks == 0) {
            System.out.println("Library is empty. No books to display.");
            return;
        }
        System.out.println("Books in the Library:");
        for (Book book : books) {
            if (book != null) {
                System.out.println("Book ID: " + book.getBookID() +
                        ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() +
                        ", Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10);

        int choice;
        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(bookID, title, author);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = scanner.nextInt();
                    library.searchBook(searchID);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting the Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);


    }
}

