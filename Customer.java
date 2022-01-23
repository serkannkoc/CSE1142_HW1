// Serkan Koç 150118073

public class Customer extends Person {
    private String address;
    private Book borrowedBook;
    private boolean borrowABook = false;

    public Customer(String name, int birthDate, String address) throws Exception {
        super(name, birthDate);
        this.address = address;
    }

    public Customer(String name, String birthPlace, int birthDate, String address) throws Exception {
        super(name, birthDate, birthPlace);
        this.address = address;
    }

    public Customer(String name, String address) {
        super(name);
        this.address = address;
    }

    public Customer(String name, int birthDate) throws Exception {
        super(name, birthDate);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (address.length() >= 3)
            this.address = address;
        else
            throw new Exception("Address should be validated to be no less than 3 symbols.");
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public boolean isBorrowABook() {
        return borrowABook;
    }

    public void setBorrowABook(boolean borrowABook) {
        this.borrowABook = borrowABook;

    }


    @Override
    public String toString() {
        if (getAddress() == null)
            address = "-";

        return super.toString() + "\n" +
                "Address: " + address
                ;
    }
}
