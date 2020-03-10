import java.util.Date;
public class Item {
    private int id;
    private String ime_izdelka;
    private double zacetna_cena;
    private String opis_izdelka;
    private Date rok_uporabe;
    private String znamka_izdelka;
    private boolean trenutno_v_zalogi;
    private double DDV_znesek;

    public Item(int id, String ime_izdelka, double zacetna_cena, String opis_izdelka, Date rok_uporabe, String znamka_izdelka, boolean trenutno_v_zalogi, double DDV) {
        this.id = id;
        this.ime_izdelka = ime_izdelka;
        this.zacetna_cena = zacetna_cena;
        this.opis_izdelka = opis_izdelka;
        this.rok_uporabe = rok_uporabe;
        this.znamka_izdelka = znamka_izdelka;
        this.trenutno_v_zalogi = trenutno_v_zalogi;
        this.DDV_znesek = DDV;
    }

    public double getDDV() {
        return DDV_znesek;
    }

    public void setDDV(double DDV) {
        this.DDV_znesek = DDV;
    }

    public double dodajPopust(Item item, double popust){
        double cena_po_popustu = item.getZacetna_cena() * popust;
        return cena_po_popustu;
    }

    public double getZacetna_cena() {
        return zacetna_cena;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", ime_izdelka=" + ime_izdelka +
                ", zacetna_cena=" + zacetna_cena +
                ", opis_izdelka='" + opis_izdelka + '\'' +
                ", rok_uporabe=" + rok_uporabe +
                ", znamka_izdelka='" + znamka_izdelka + '\'' +
                ", trenutno_v_zalogi=" + trenutno_v_zalogi +
                '}';
    }
}
