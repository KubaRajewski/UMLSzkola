import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Nauczyciel extends Osoba {

    // asocjacja licznosci * do * w takim przypadku metoda tworząca powiązanie znajduje się po stronie która ma wiekszy sens biznesowy
    private List<Szkola> szkoly = new ArrayList<>();

    // asocjacja licznosci * do * w takim przypadku metoda tworząca powiązanie znajduje się po stronie która ma wiekszy sens biznesowy
    private List<Szkolenie> szkolenia = new ArrayList<>();

    // Atrybut dodatkowy
    private String przedmiot;

    public static List<Nauczyciel> ekstensja = new ArrayList<>();

    // W konstruktorze tylko atrybuty
    public Nauczyciel(String imie, String nazwisko, String adres, String przedmiot) {
        super(imie, nazwisko, adres);
        this.przedmiot = przedmiot;

        ekstensja.add(this);
    }

    @Override
    public double obliczDochod() {
        return 3500;
    }

    public List<Szkola> getSzkoly() {
        return szkoly;
    }

    public void setSzkoly(List<Szkola> szkoly) {
        this.szkoly = szkoly;
    }

    public List<Szkolenie> getSzkolenia() {
        return szkolenia;
    }

    public void setSzkolenia(List<Szkolenie> szkolenia) {
        this.szkolenia = szkolenia;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    public static List<Nauczyciel> getEkstensja() {
        return ekstensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Nauczyciel that = (Nauczyciel) o;
        return Objects.equals(szkoly, that.szkoly) && Objects.equals(szkolenia, that.szkolenia) && Objects.equals(przedmiot, that.przedmiot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), szkoly, szkolenia, przedmiot);
    }

    @Override
    public String toString() {
        return super.toString() + " " + przedmiot;
    }
}
