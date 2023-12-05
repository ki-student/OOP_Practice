import java.util.ArrayList;
class Book{
    private String title;
    private String name;
    private String num;

    public Book(String title, String name, String num){
        this.title = title;
        this.name = name;
        this.num = num;
    }

    public String getName(){return name;}
    public String getTitle(){return title;}
    public String getNum(){return num;}
    public String toString(){
        return "제목: " + getTitle() + "저자: " + getName() + "ISBN: " + getNum();
    }
}

class EBook extends Book {
    private String internetBook;

    public EBook(String title, String name, String num, String internetBook) {
        super(title, name, num);
        this.internetBook = internetBook;
    }
    public String getInternetBook() {
        return internetBook;
    }

    @Override
    public String toString() {
        return "제목: " + getTitle() + " 저자: " + getName() + " ISBN: " + getNum() +
                " 서점: " + getInternetBook();
    }
}

class BookManager{
    private ArrayList<Book> books;

    public BookManager(){
        books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void numOfBooks(){
        System.out.println("num of books : " + books.size());
    }
    public void show(){
        for(Book book : books){
            System.out.println(book);
        }
    }
    public Book findTitle(String t){
        for (Book book : books) {
            if (book.getTitle().equals(t)) {
                return book;
            }
        }
        return null;
    }
    public Book findAuthor(String a){
        for (Book book : books) {
            if (book.getName().equals(a)) {
                return book;
            }
        }
        return null;
    }
    public Book findISBN(int i){
        for (Book book : books) {
            if (book.getNum().equals(i)) {
                return book;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Book book : books) {
            result.append(book.toString()).append("\n");
        }
        return result.toString();
    }
}

public class BookMain {
    public static void main(String[] args) {
        // Create BookManager
        BookManager bookManager = new BookManager();

        // Add Books to BookManager
        Book book1 = new Book("자바 프로그래밍 II", "조용주", "20201111");
        Book book2 = new Book("자바 프로그래밍 I", "임좌상", "20211112");
        Book book3 = new Book("자바 프로그래밍 I", "박태수", "20151113");

        EBook eBook1 = new EBook("자바 프로그래밍 II", "조용주", "20201111", "교보문고");

        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);
        bookManager.addBook(eBook1);

        // Display the number of books
        bookManager.numOfBooks();

        // Display all books
        System.out.println("All Books:");
        bookManager.show();

        // Search by title, author, and ISBN
        searchAndDisplay(bookManager, "자바 프로그래밍 II", "조용주", "20201111");
        searchAndDisplay(bookManager, "Non-Existent Title", "임좌상", "20211112");
        searchAndDisplay(bookManager, "자바 프로그래밍 I", "Non-Existent Author", "20151113");
    }

    private static void searchAndDisplay(BookManager bookManager, String title, String name, String num) {
        Book foundBook = bookManager.findTitle(title);
        if (foundBook != null) {
            System.out.println("Found by Title: " + foundBook);
        } else {
            System.out.println("Not Found by Title: " + title);
        }

        foundBook = bookManager.findAuthor(name);
        if (foundBook != null) {
            System.out.println("Found by Author: " + foundBook);
        } else {
            System.out.println("Not Found by Author: " + name);
        }

        foundBook = bookManager.findISBN(Integer.parseInt(num));
        if (foundBook != null) {
            System.out.println("Found by ISBN: " + foundBook);
        } else {
            System.out.println("Not Found by ISBN: " + num);
        }
        System.out.println("------------------------------");
    }
}

