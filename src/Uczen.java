import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Uczen extends Osoba {

    // atrubut dodatkowy
    private String numerIndeksu;

    // asoacjaja licznosci 1
    private Szkola szkola;

    // kompozycja z ocenami, przy tworzeniu oceny nastapi populacja tej listy
    private List<Ocena> oceny = new ArrayList<>();

    public static List<Uczen> ekstensja = new ArrayList<>();

    public Uczen(String imie, String nazwisko, String adres, String numerIndeksu) {
        super(imie, nazwisko, adres);
        this.numerIndeksu = numerIndeksu;

        ekstensja.add(this);
    }

    @Override
    public double obliczDochod() {
        return 350;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public void setSzkola(Szkola szkola) {
        this.szkola = szkola;
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    public void setNumerIndeksu(String numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }

    public void setOceny(List<Ocena> oceny) {
        this.oceny = oceny;
    }

    public static List<Uczen> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Uczen uczen = (Uczen) o;
        return Objects.equals(numerIndeksu, uczen.numerIndeksu) && Objects.equals(szkola, uczen.szkola) && Objects.equals(oceny, uczen.oceny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numerIndeksu, szkola, oceny);
    }

    @Override
    public String toString() {
        return super.toString() + " nr. Indeksu: " + numerIndeksu;
    }
}
