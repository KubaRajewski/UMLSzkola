import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sala {

    // garbage collection
    // przy usunięciu obiektu szkoła, obiekt sala rzuci nam wyjątek, ze nalezy najpier usunąć sale

    private final Szkola szkola; // Kompozycja z klasą szkoła, Final oznacza ze przy inicjalizacji obiektu, musimy dodac szkołe

    private String nazwa;

    public static List<Sala> ekstensja = new ArrayList<>();

    public Sala(String nazwa, Szkola szkola) {
        if (szkola == null) throw new IllegalArgumentException("Szkola musi istniec");
        this.nazwa = nazwa;
        this.szkola = szkola;

        // informacja zwrotna
        szkola.getSale().add(this);

        ekstensja.add(this);
    }

    public String getNazwa() {
        return nazwa;
    }

    public Szkola getSzkola() {
        return szkola;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public static List<Sala> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return Objects.equals(szkola, sala.szkola) && Objects.equals(nazwa, sala.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(szkola, nazwa);
    }

    @Override
    public String toString() {
        return "Sala{" +
                "szkola=" + szkola +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
