import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sprawdzian {

    private final Nauczyciel nauczyciel;
    private final String przedmiot;

    private List<Ocena> oceny = new ArrayList<>(); // kompozycja z ocenami, przy tworzeniu oceny następuje populacja tej listy

    public static List<Sprawdzian> ekstensja = new ArrayList<>();

    // Konstruktor zawierajacy tylko atrybuty
    public Sprawdzian(Nauczyciel nauczyciel, String przedmiot) {
        this.nauczyciel = nauczyciel;
        this.przedmiot = przedmiot;

        ekstensja.add(this);
    }

    public Nauczyciel getNauczyciel() {
        return nauczyciel;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public List<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(List<Ocena> oceny) {
        this.oceny = oceny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprawdzian that = (Sprawdzian) o;
        return Objects.equals(nauczyciel, that.nauczyciel) && Objects.equals(przedmiot, that.przedmiot) && Objects.equals(oceny, that.oceny);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nauczyciel, przedmiot, oceny);
    }

    @Override
    public String toString() {
        return "Sprawdzian{" +
                "nauczyciel=" + nauczyciel +
                ", przedmiot='" + przedmiot + '\'' +
                ", oceny=" + oceny +
                '}';
    }
}
