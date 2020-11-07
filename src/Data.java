import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Data {
    private ArrayList<Sample> samples = new ArrayList<>();
    private ArrayList<Referral> referrals = new ArrayList<>();

    public Data(/*ObjectInputStream samplesInputStream, ObjectInputStream referralsInputStream*/){
       /* try{
                samples = (ArrayList) samplesInputStream.readObject();
                referrals = (ArrayList) referralsInputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


    }

    public Referral getReferralByName(String name, String surname) throws Exception{
        for(Referral r : this.referrals){
            if(r.getName().equals(name) && r.getSurname().equals(surname)){
                return r;
            }
        }
        throw new Exception("Nie znaleziono skierowania (sprawdź poprawność zapisu imienia i nazwiska).");
    }

    public Referral getReferralById(int id) throws Exception{
        for(Referral r : this.referrals){
            if(r.getId() == id){
                return r;
            }
        }
        throw new Exception("Nie znaleziono skierowania o podanym id.");
    }

    public ArrayList<Sample> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<Sample> samples) {
        this.samples = samples;
    }

    public ArrayList<Referral> getReferrals() {
        return referrals;
    }

    public void setReferrals(ArrayList<Referral> referrals) {
        this.referrals = referrals;
    }

    public void addReferral(Referral referral){
        this.referrals.add(referral);
    }

    public void updateReferralById(int id, Referral referral){
        this.referrals.set(id, referral);
    }

    public void deleteReferralById(int id){
        this.referrals.remove(id);
    }

    public void addSample(Sample sample){
        this.samples.add(sample);
    }

    public Sample getSampleById(int id) throws Exception{
        for(Sample s : this.samples){
            if(s.getId() == id){
                return s;
            }
        }
        throw new Exception("Nie znaleziono próbki o podanym id.");
    }

    public void updateSample(){

    }

    public void deleteSample(){

    }
}
