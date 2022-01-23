// Serkan Koç 150118073
public class Author extends Person {
    private String publisher;

    public Author(String name, String publisher, int birthDate) throws Exception {
        super(name, birthDate);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws Exception{
        if(publisher.length()>=3)
        this.publisher = publisher;
        else
            throw new Exception("Publisher should be validated to be no less than 3 symbols.");
    }

    @Override
    public String toString() {
        return
                 getName();
    }
}
