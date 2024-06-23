import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ocena {
    private final int wartosc;
    private final LocalDate dataWystawienia;
    private final Uczen uczen; // kompozycja do ucznia, ocena nie moze istniec bez ucznia
    private final Sprawdzian sprawdzian; // kompozycja do sprawdzianu, ocena nie moze istniec bez sprawdzianu

    public static List<Ocena> ekstensja = new ArrayList<>();

    // Konstruktor z wszystkimi wartosciami, nie mozemy utworzyc oceny bez wszystkich danych
    public Ocena(int wartosc, LocalDate dataWystawienia, Uczen uczen, Sprawdzian sprawdzian) {

        if (uczen == null || sprawdzian == null)
            throw new IllegalArgumentException("uczen lub sprawdzian nie istnieja!");

        this.wartosc = wartosc;
        this.dataWystawienia = dataWystawienia;
        this.uczen = uczen;
        this.sprawdzian = sprawdzian;

        // informacja zwrotna
        uczen.getOceny().add(this);
        sprawdzian.getOceny().add(this);

        ekstensja.add(this);
    }

    public int getWartosc() {
        return wartosc;
    }

    public LocalDate getDataWystawienia() {
        return dataWystawienia;
    }

    public Uczen getUczen() {
        return uczen;
    }

    public Sprawdzian getSprawdzian() {
        return sprawdzian;
    }

    public static List<Ocena> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocena ocena = (Ocena) o;
        return wartosc == ocena.wartosc && Objects.equals(dataWystawienia, ocena.dataWystawienia) && Objects.equals(uczen, ocena.uczen) && Objects.equals(sprawdzian, ocena.sprawdzian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wartosc, dataWystawienia, uczen, sprawdzian);
    }

    @Override
    public String toString() {
        return wartosc + ", data: " + dataWystawienia + ",  Uczen: " + uczen.getImie() +  " " + uczen.getNazwisko();
    }
}
