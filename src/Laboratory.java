import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Laboratory {
    public static void findSampleAndEdit(ArrayList<Sample> samples, int id) throws Exception{
        Sample sample = null;
        boolean sampleFound = false;
        for(Sample s : samples){
            if(s.getId() == id){
                sample = s;
                sampleFound = true;
                break;
            }
        }
        if(sampleFound){
            editSample(sample);
        }else throw new Exception("Nie znaleziono próbki o podanym id.");
    }

    public static void editSample(Sample s){ //aby zmienić interface z konsolowego na graficzny, wystarczy zmienić tą metodę
        boolean continueEditing = true;
        while(continueEditing) {
            clear();
            System.out.println("------ Tryb edytowania próbek ------");
            System.out.println(s.toString() + "\n");
            System.out.println("1. Data testowania.");
            System.out.println("2. Status.");
            System.out.println("3. Wynik.");
            System.out.println("4. Laborant testujący.");
            System.out.println("5. Wyjdź z trybu edytowania próbek.");
            int choice = 0;
            Scanner scan = new Scanner(System.in);

            try {
                boolean isAnswerGood = false;
                while (!isAnswerGood) {
                    System.out.println("Wybór: ");
                    choice = scan.nextInt();
                    if (choice < 1 || choice > 5) {
                        System.out.println("Wprowadzono nieprawidłową wartość");
                    } else isAnswerGood = true;
                }
            } catch (Exception e) {
                System.out.println("Wprowadzono nieprawidłową wartość.");
                e.printStackTrace();
            }

            switch(choice){
                case 1:
                    try {
                        boolean isAnswerGood = false;
                        int day = 1;
                        int month = 1;
                        int year = 1;

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

                        s.setTestingDate(LocalDate.of(year,month,day));
                    } catch (Exception e) {
                        System.out.println("Wprowadzono nieprawidłową wartość.");
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    try {
                        boolean isAnswerGood = false;
                        int ans = 0;

                        while (!isAnswerGood) {
                            System.out.println("0 - nie testowano\n1 - testowano");
                            ans = scan.nextInt();
                            if (ans == 1 || ans == 0) {
                                isAnswerGood = true;
                            } else System.out.println("Wprowadzono nieprawidłową wartość.");
                        }

                        s.setWasTested((ans == 1));
                    } catch (Exception e) {
                        System.out.println("Wprowadzono nieprawidłową wartość.");
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        boolean isAnswerGood = false;
                        String ans = "";


                        System.out.println("Wprowadź wynik badania: ");
                        ans = scan.nextLine();

                        s.setResult(ans);
                    } catch (Exception e) {
                        System.out.println("Wprowadzono nieprawidłową wartość.");
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        boolean isAnswerGood = false;
                        String ans = "";


                        System.out.println("Wprowadź imię i nazwisko laboranta: ");
                        ans = scan.nextLine();

                        s.setTesterName(ans);
                    } catch (Exception e) {
                        System.out.println("Wprowadzono nieprawidłową wartość.");
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    continueEditing = false;
                    break;

            }


        }
    }

    private static void clear() {
        for (int i = 0; i < 40; i++) {
            System.out.println("\n\n\n\n\n\n");
        }
    }

    public static String notTestedSamplesToString(ArrayList<Sample> samples){
        String allElements ="";
        for(Sample s : samples){
            if(!s.getWasTested()) {
                allElements += s.toString();
            }
        }
        return allElements;
    }

    public static String samplesToString(ArrayList<Sample> samples){
        String allElements ="";
        for(Sample s : samples){
            allElements += s.toString();
        }
        return allElements;
    }


}
