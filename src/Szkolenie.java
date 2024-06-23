import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Szkolenie {

    private String nazwa;

    // asocjacja licznosci *
    private final List<Nauczyciel> nauczyciele = new ArrayList<>();

    public static List<Szkolenie> ekstensja = new ArrayList<>();

    public Szkolenie(String nazwa) {
        this.nazwa = nazwa;

        ekstensja.add(this);
    }

    public void dodajNauczyciela(Nauczyciel n) {
        nauczyciele.add(n);
        // info zwrotne
        n.getSzkolenia().add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Nauczyciel> getNauczyciele() {
        return nauczyciele;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public static List<Szkolenie> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Szkolenie szkolenie = (Szkolenie) o;
        return Objects.equals(nazwa, szkolenie.nazwa) && Objects.equals(nauczyciele, szkolenie.nauczyciele);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, nauczyciele);
    }

    @Override
    public String toString() {
        return nazwa;
    }
}

