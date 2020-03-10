import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dt_1 = objSDF.parse("20-08-2021");
        Item i1 = new Item(1,"Cokolada",2.5,"Cokolada je mlecna...", dt_1,"Milka",true,0.60);

        Racun r1 = new Racun("2654-2345-2345", "owmfd023fem3042", "ef302fmn3f49f4", 120341,1234251,dt_1,0,0,0,"3245234542653","Koda za wi-fi je: vidjecar");

        r1.dodaj_na_racun(i1);
        r1.dodaj_na_racun(i1);
        r1.dodaj_na_racun(i1);

        System.out.println("Skupna zacetna cena: " + r1.izracun_skupne_cene() + "€");
        System.out.println("Skupna cena s popustom: " + r1.popust(i1,40) + "€");
        System.out.println("Placilo DDV:" +r1.getDDV_znesek());
        r1.preveri_kolicino();

        System.out.println(r1.toString());

    }
}
