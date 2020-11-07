import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Referral implements Serializable {//skierowanie
    private int id;
    private String name;
    private String surname;
    private LocalDate referralDate;
    private ArrayList<Sample> samples;

    public Referral(int id, String name, String surname, LocalDate referralDate){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.referralDate = referralDate;
        samples = new ArrayList<Sample>();
    }

    @Override
    public String toString(){
        String element = "";
        element += "\n----------------------------------";
        element += "\nID: " + this.getId();
        element += "\nImię: " + this.getName();
        element += "\nNazwisko: " + this.getSurname();
        element += "\nData przyjęcia skierowania: " + this.getReferralDate().toString();
        element += "\nZarejestrowane próbki: ";
        for(Sample s : samples){
            element += s.toString();
        }
        return element;
    }

    public void addSample(Sample s){
        this.samples.add(s);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(LocalDate referralDate) {
        this.referralDate = referralDate;
    }

    public ArrayList<Sample> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<Sample> samples) {
        this.samples = samples;
    }
}
