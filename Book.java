// Serkan Koç 150118073
public class Book {
    private int id;
    private String title;
    private Author author;
    private boolean borrowed = true;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public boolean isBorrowed() {
        return this.borrowed;
    }

    public boolean borrowed() {
        return this.borrowed = false;
    }

    public boolean returned() {
        return this.borrowed = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {   //necessary checks
        if (id >= 0)
            this.id = id;
        else
            throw new IllegalArgumentException("Id can not be negative");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception { //necessary checks
        if (title.length() >= 3)
            this.title = title;
        else
            throw new Exception("Title should be validated to be no less than 3 symbols.");
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Book name is "
                + title +
                ", Author is " + author +
                ".";
    }
}
