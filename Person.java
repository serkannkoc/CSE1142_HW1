// Serkan Koç 150118073
public class Person {
    private String name;
    private String birthDate;
    private String birthPlace;

    public Person(String name, int birthDate, String birthPlace) throws Exception {
        this.name = name;
        setBirthDate(birthDate);
        this.birthPlace = birthPlace;
    }

    public Person(String name, int birthDate) throws Exception {
        this.name = name;
        setBirthDate(birthDate);
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() >= 3)
            this.name = name;
        else
            throw new Exception("Name should be validated to be no less than 3 symbols.");
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) throws Exception {
        if (birthDate >= 0)
            this.birthDate = (Integer.toString(birthDate));
        else
            throw new IllegalArgumentException("Birth date can not be negative.");
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace)throws Exception {
        if(birthPlace.length()>=3)
        this.birthPlace = birthPlace;
        else
            throw new Exception("Birth place should be validated to be no less than 3 symbols.");
    }

    @Override
    public String toString() {
        if (birthDate == null)
            birthDate = "-";
        if (birthPlace == null)
            birthPlace = "-";

        return "Name: " +
                name +
                ", BirthDate: " + birthDate +
                ", BirthPlace: " + birthPlace

                ;
    }
}
