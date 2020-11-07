import java.io.*;
import java.util.Scanner;

public class RegistrationWindow {
    public static void main(String[] args) {
        Data dataBase;
        /*try {
            ObjectInputStream samplesInputStream = new ObjectInputStream(new FileInputStream("samples.ser"));
            ObjectInputStream referralInputStream = new ObjectInputStream(new FileInputStream("referrals.ser"));
            dataBase = new Data(samplesInputStream, referralInputStream);*/
            dataBase = new Data();


            boolean shallWeContinue = true;
            while (shallWeContinue) {
                System.out.println("------ Rejestracja ------");
                System.out.println("1. Wyświetl wszystkie skierowania.");
                System.out.println("2. Wyszukaj skierowanie.");
                System.out.println("3. Dodaj nowe skierowanie.");
                System.out.println("4. Edytuj skierowanie.");
                System.out.println("5. Wyjdź.");

                Scanner scan = new Scanner(System.in);
                int choice=1;
                try {
                    boolean isAnswerCorrect = false;
                    while (!isAnswerCorrect) {
                        choice = scan.nextInt();
                        if (choice < 1 || choice > 5) {
                            System.out.println("Wprowadz wartosc calkowita z zakresu <1;5>.");
                        } else isAnswerCorrect = true;
                    }
                } catch (Exception e) {
                    System.out.println("Wprowadzono nieprawidlowa wartosc.");
                    e.printStackTrace();
                }

                switch (choice) {
                    case 1:
                        Registration.referralsToString(dataBase.getReferrals());
                        break;
                    case 2:

                        break;
                    case 3:
                        Registration.newReferral(dataBase.getReferrals(),dataBase.getSamples());
                        break;
                    case 4:

                        break;
                    case 5:
                        shallWeContinue = false;
                        break;
                }
            }
        /*} catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
