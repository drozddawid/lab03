import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {

    public static Referral newReferral(ArrayList<Referral> referrals, ArrayList<Sample> samples){
        clear();
        Scanner scan = new Scanner(System.in);
        Referral referral = null;
        try{
            boolean isAnswerGood = false;
            int id=-1;
            String name="";
            String surname="";
            int day=1;
            int month=1;
            int year=1;
            LocalDate referralDate;

            while(!isAnswerGood){
                System.out.println("ID: ");
                id = scan.nextInt();
                boolean isIdWritten = false;
                for(Referral r : referrals){
                    if(id == r.getId()){
                        isIdWritten = true;
                        break;
                    }
                }
                if(!isIdWritten){
                    isAnswerGood=true;
                } else System.out.println("Wprowadzone ID jest już zajęte. Proszę wprowadzić inne ID.");
            }

            System.out.println("Imię: ");
            name = scan.nextLine();
            System.out.println("Nazwisko: ");
            surname = scan.nextLine();
            System.out.println("Data przyjęcia skierowania: ");
            isAnswerGood = false;

            while (!isAnswerGood) {
                System.out.println("Wprowadź datę używając liczb całkowitych.");
                System.out.println("Dzień: ");
                day = scan.nextInt();
                System.out.println("Miesiąc: ");
                month = scan.nextInt();
                System.out.println("Rok: ");
                year = scan.nextInt();
                if (day < 1 || day > 31) {
                    System.out.println("Wprowadzono nieprawidłową wartość (dzień).");
                }else if(month < 1 || month > 12){
                    System.out.println("Wprowadzono nieprawidłową wartość(miesiąc).");
                }else if(year<0 || year >10000){
                    System.out.println("Wprowadzono nieprawidłową wartość (rok).");
                }else isAnswerGood = true;
            }
            referralDate = LocalDate.of(year,month,day);
            isAnswerGood = false;
            int i=0;
            while(!isAnswerGood) {
                System.out.println("Ilość wprowadzanych próbek<0;30>: ");
                i = scan.nextInt();
                if(i<0 || i>30){
                    System.out.println("Wprowadzono nieprawidłową wartość, wprowadź wartość całkowitą z zakresu <0;30>");
                }else isAnswerGood = true;
            }
            referral = new Referral(id,name,surname,referralDate);
            for(int k=0; k<i;k++ ){
                Sample s = newSample(samples, id);
                if(s == null){
                    System.out.println("Niepowodzenie w tworzeniu próbki.");
                }else {
                    referral.addSample(s);
                    samples.add(s);
                }
            }


        } catch (Exception e) {
            System.out.println("Wprowadzono nieprawidłową wartość.");
            e.printStackTrace();
        }
        if(referral != null){
            referrals.add(referral);
        }
        return referral;
    }

    public static Sample newSample(ArrayList<Sample> samples, int customerID){
        Scanner scan = new Scanner(System.in);
        Sample sample = null;
        try{
            boolean isAnswerGood = false;
            int id = -1;
            int day = 1;
            int month = 1;
            int year = 1;
            LocalDate samplingDate;
            String sampleType;

            System.out.println("Tworzenie próbki: ");
            System.out.println("ID: ");

            while(!isAnswerGood){
                System.out.println("ID: ");
                id = scan.nextInt();
                boolean isIdWritten = false;
                for(Sample s : samples){
                    if(id == s.getId()){
                        isIdWritten = true;
                        break;
                    }
                }
                if(!isIdWritten){
                    isAnswerGood=true;
                } else System.out.println("Wprowadzone ID jest już zajęte. Proszę wprowadzić inne ID.");
            }

            System.out.println("Data pobrania: ");
            isAnswerGood = false;

            while (!isAnswerGood) {
                System.out.println("Wprowadź datę używając liczb całkowitych.");
                System.out.println("Dzień: ");
                day = scan.nextInt();
                System.out.println("Miesiąc: ");
                month = scan.nextInt();
                System.out.println("Rok: ");
                year = scan.nextInt();
                if (day < 1 || day > 31) {
                    System.out.println("Wprowadzono nieprawidłową wartość (dzień).");
                }else if(month < 1 || month > 12){
                    System.out.println("Wprowadzono nieprawidłową wartość(miesiąc).");
                }else if(year<0 || year >10000){
                    System.out.println("Wprowadzono nieprawidłową wartość (rok).");
                }else isAnswerGood = true;
            }
            samplingDate = LocalDate.of(year,month,day);
            System.out.println("Typ próbki: ");
            sampleType = scan.nextLine();

            sample = new Sample(id,customerID,samplingDate,sampleType);
        } catch (Exception e) {
            System.out.println("Wprowadzono nieprawidłową wartość.");
            e.printStackTrace();
        }
        return sample;
    }


    public static void referralsToString(ArrayList<Referral> referrals){
        clear();
        for(Referral r : referrals){
            r.toString();
        }
    }


    private static void clear() {
        for (int i = 0; i < 40; i++) {
            System.out.println("\n\n\n\n\n\n");
        }
    }
}
