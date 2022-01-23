// Serkan Koç 150118073
public class Dictionary extends Book {
    private int definitions;

    public Dictionary(int id, String title, Author author, int definitions) {
        super(id, title, author);
        this.definitions = definitions;
    }

    public Dictionary(int id, String title, int definitions) {
        super(id, title);
        this.definitions = definitions;
    }

    public int getDefinitions() {
        return definitions;
    }

    public void setDefinitions(int definitions) throws Exception {
        if(definitions>=0)
            this.definitions=definitions;
        else
            throw new IllegalArgumentException("Definitions cant not be negative.");
    }

    @Override
    public String toString() {
        return "Dictionary name is " + getTitle() +
                ", definitions: " + definitions +
                '}';
    }
}
