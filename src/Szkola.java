import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Szkola {

    private static int MIN_LICZBA_UCZNIOW = 150;

    // atrybuty
    public final int rokPowstania;
    public String nazwa;
    public String wyroznienie;
    public int numer;
    public List<String> profile = new ArrayList<>();

    // asocjacja licznosci * do klasy Uczen - najslabszy rodzaj asocjacji
    private List<Uczen> uczniowie = new ArrayList<>();

    // asocjacja licznosci * do klasy Uczen - W przypadku asocjacji tworzymy Metody tworzące powiązanie po stronie jednej z klas
    // w przypadku relacji jeden do wielu, nalezy stworzyc metodę tworzącą powiązane po stronie "wielu"
    private List<Nauczyciel> nauczyciele = new ArrayList<>();

    // lista sal (kompozycja z sala) - najmocniejszy rodzaj asocjacji
    private List<Sala> sale = new ArrayList<>();

    // ekstensja klasy szkola
    private static final List<Szkola> ekstensja = new ArrayList<>();

    // Konstruktor sklada sie tylko z atrybutów, moze tez zawierać atrybuty kompozycji w pewnych przypadkach
    public Szkola(int rokPowstania, String nazwa, String wyroznienie, int numer) {
        this.rokPowstania = rokPowstania;
        this.nazwa = nazwa;
        this.wyroznienie = wyroznienie;

        // sprawdzamy unikalnosc numeru
        for (Szkola s : ekstensja) {
            if (s.getNumer() == numer) {
                throw new IllegalArgumentException("szkoła o tym numerze istnieje juz w systemie");
            } else {
                this.numer = numer;
            }
        }

        ekstensja.add(this);
    }

    // metoda tworzaca powiazanie (asocjacje)
    public void dodajUcznia(Uczen u) {
        if (u.getSzkola() != null) {
            throw new IllegalArgumentException("uczen juz jest w innej szkole");
        }
        uczniowie.add(u);
        // informacja zwrotna
        u.setSzkola(this);
    }

    public void usunUcznia(Uczen u) {
        uczniowie.remove(u);
        u.setSzkola(null);
    }

    public void dodajNauczyciela(Nauczyciel n) {
        nauczyciele.add(n);
        n.getSzkoly().add(this);
    }

    public void usunNauczyciela(Nauczyciel n) {
        nauczyciele.remove(n);
        n.getSzkoly().remove(this);
    }

    public static int getMinLiczbaUczniow() {
        return MIN_LICZBA_UCZNIOW;
    }

    public static void setMinLiczbaUczniow(int minLiczbaUczniow) {
        MIN_LICZBA_UCZNIOW = minLiczbaUczniow;
    }

    public int getRokPowstania() {
        return rokPowstania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWyroznienie() {
        return wyroznienie;
    }

    public void setWyroznienie(String wyroznienie) {
        this.wyroznienie = wyroznienie;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public List<String> getProfile() {
        return profile;
    }

    public void setProfile(List<String> profile) {
        this.profile = profile;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(List<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }

    public List<Nauczyciel> getNauczyciele() {
        return nauczyciele;
    }

    public void setNauczyciele(List<Nauczyciel> nauczyciele) {
        this.nauczyciele = nauczyciele;
    }

    public List<Sala> getSale() {
        return sale;
    }

    public void setSale(List<Sala> sale) {
        this.sale = sale;
    }

    public static List<Szkola> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Szkola szkola = (Szkola) o;
        return rokPowstania == szkola.rokPowstania && numer == szkola.numer && Objects.equals(nazwa, szkola.nazwa) && Objects.equals(wyroznienie, szkola.wyroznienie) && Objects.equals(profile, szkola.profile) && Objects.equals(uczniowie, szkola.uczniowie) && Objects.equals(nauczyciele, szkola.nauczyciele) && Objects.equals(sale, szkola.sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rokPowstania, nazwa, wyroznienie, numer, profile, uczniowie, nauczyciele, sale);
    }

    @Override
    public String toString() {
        return nazwa;
    }
}