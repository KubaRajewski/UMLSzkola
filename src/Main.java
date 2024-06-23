import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Create schools
        Szkola szkola1 = new Szkola(2000, "Szkoła Podstawowa nr 1", "Brązowa", 101);
        Szkola szkola2 = new Szkola(1995, "Szkoła Podstawowa nr 2", "Srebrna", 102);

        // Create teachers
        Nauczyciel nauczyciel1 = new Nauczyciel("Jan", "Kowalski", "Warszawa, ul. Kwiatowa 15", "Matematyka");
        Nauczyciel nauczyciel2 = new Nauczyciel("Anna", "Nowak", "Kraków, ul. Różana 22", "Biologia");

        // Create students
        Uczen uczen1 = new Uczen("Marek", "Zieliński", "Gdańsk, ul. Leśna 5", "12345");
        Uczen uczen2 = new Uczen("Julia", "Wiśniewska", "Poznań, ul. Parkowa 8", "67890");

        // Create classrooms
        Sala sala1 = new Sala("Sala 101", szkola1);
        Sala sala2 = new Sala("Sala 102", szkola1);
        Sala sala3 = new Sala("Sala 201", szkola2);

        // Create trainings
        Szkolenie szkolenie1 = new Szkolenie("Szkolenie z nowoczesnych metod nauczania");
        Szkolenie szkolenie2 = new Szkolenie("Szkolenie z zarządzania klasą");

        // Create exams
        Sprawdzian sprawdzian1 = new Sprawdzian(nauczyciel1, "Matematyka");
        Sprawdzian sprawdzian2 = new Sprawdzian(nauczyciel2, "Biologia");

        // Create grades
        Ocena ocena1 = new Ocena(5, LocalDate.now(), uczen1, sprawdzian1);
        Ocena ocena2 = new Ocena(4, LocalDate.now(), uczen2, sprawdzian2);

        // Add students to schools
        szkola1.dodajUcznia(uczen1);
        szkola2.dodajUcznia(uczen2);

        // Add teachers to schools
        szkola1.dodajNauczyciela(nauczyciel1);
        szkola2.dodajNauczyciela(nauczyciel2);

        // Add teachers to trainings
        szkolenie1.dodajNauczyciela(nauczyciel1);
        szkolenie2.dodajNauczyciela(nauczyciel2);

        // Print out some information to verify associations and attributes
        System.out.println("Szkoła 1: " + szkola1);
        System.out.println("Szkoła 2: " + szkola2);

        System.out.println("Nauczyciele w szkole 1: " + szkola1.getNauczyciele());
        System.out.println("Nauczyciele w szkole 2: " + szkola2.getNauczyciele());

        System.out.println("Uczniowie w szkole 1: " + szkola1.getUczniowie());
        System.out.println("Uczniowie w szkole 2: " + szkola2.getUczniowie());

        System.out.println("Sale w szkole 1: " + szkola1.getSale());
        System.out.println("Sale w szkole 2: " + szkola2.getSale());

        System.out.println("Szkolenia nauczyciela 1: " + nauczyciel1.getSzkolenia());
        System.out.println("Szkolenia nauczyciela 2: " + nauczyciel2.getSzkolenia());

        System.out.println("Oceny ucznia 1: " + uczen1.getOceny());
        System.out.println("Oceny ucznia 2: " + uczen2.getOceny());

        // Print out details of classrooms and trainings
        System.out.println("Sale:");
        for (Sala sala : Sala.getEkstensja()) {
            System.out.println(sala);
        }

        System.out.println("Szkolenia:");
        for (Szkolenie szkolenie : Szkolenie.getEkstensja()) {
            System.out.println(szkolenie);
        }
    }
}

