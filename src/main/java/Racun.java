import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

public class Racun {
    private String racun_st;
    private String ZOI;
    private String EOR;
    private long racun_izdal;
    private long racun_stevilka;
    private Date datum_izdaje;
    private double DDV_znesek;
    private double neto_vrednost;
    private double skupna_cena_z_DDV;
    private String crtna_koda;
    private String komentar;

    Map<Item, Integer> artikli;
    List<Item> artikli_;

    public Racun(String racun_st, String ZOI, String EOR, long racun_izdal, long racun_stevilka, Date datum_izdaje, double DDV_znesek, double neto_vrednost, double skupna_cena_z_DDV,String crtna_koda ,String komentar) {
        this.racun_st = racun_st;
        this.ZOI = ZOI;
        this.EOR = EOR;
        this.racun_izdal = racun_izdal;
        this.racun_stevilka = racun_stevilka;
        this.datum_izdaje = datum_izdaje;
        this.DDV_znesek = DDV_znesek;
        this.neto_vrednost = neto_vrednost;
        this.skupna_cena_z_DDV = skupna_cena_z_DDV;
        this.komentar = komentar;
        this.crtna_koda = crtna_koda;
        artikli_ = new ArrayList<>();
        artikli = new HashMap<Item, Integer>();
    }

    public double getDDV_znesek() {
        return DDV_znesek;
    }

    public void dodaj_na_racun(Item item)
    {
        artikli_.add(item);
    }

    public void preveri_kolicino()
    {
        for(int i = 0; i< this.artikli_.size(); i++)
        {
            Item trenutni = this.artikli_.get(i);
            int stevec_artiklov = 0;
            for(int j = 0; j < this.artikli_.size(); j++)
             {
                if(trenutni == this.artikli_.get(j)){
                    stevec_artiklov++;
                }
             }
            this.artikli.put(this.artikli_.get(i), stevec_artiklov);
        }
    }
    public double popust(Item item, double popust){
        popust = popust/100;
        for(int i = 0; i < this.artikli_.size();i++){
            if(this.artikli_.get(i) == item){
                double cena = this.artikli_.get(i).getZacetna_cena() * popust;
                this.skupna_cena_z_DDV -= cena;
                double DDV_po_popustu =this.artikli_.get(i).getDDV() - (this.artikli_.get(i).getDDV() * popust);
                this.artikli_.get(i).setDDV(DDV_po_popustu);
            }
        }
        return this.skupna_cena_z_DDV;
    }
    public double izracun_skupne_cene(){
        for(int i = 0; i < this.artikli_.size(); i++){
            this.DDV_znesek += artikli_.get(i).getDDV();
           this.skupna_cena_z_DDV += artikli_.get(i).getZacetna_cena();
        }
        this.neto_vrednost = skupna_cena_z_DDV - DDV_znesek;
        return this.skupna_cena_z_DDV;
    }
    @Override
    public String toString() {
        return "Racun{" +
                "racun_st='" + racun_st + '\'' +
                ", ZOI='" + ZOI + '\'' +
                ", EOR='" + EOR + '\'' +
                ", racun_izdal=" + racun_izdal +
                ", racun_stevilka=" + racun_stevilka +
                ", datum_izdaje=" + datum_izdaje +
                ", DDV_znesek=" + DDV_znesek +
                ", neto_vrednost=" + neto_vrednost +
                ", skupna_cena_z_DDV=" + skupna_cena_z_DDV +
                ", komentar='" + komentar + '\'' +
                ", artikli=" + artikli +
                '}';
    }
}