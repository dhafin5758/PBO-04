package id.ac.polban.pbo.kantin.model;

public class MenuMakanan extends MenuItem {
    private boolean pedas;

    public MenuMakanan(String kode, String nama, int harga, boolean pedas) {
        super(kode, nama, harga);
        this.pedas = pedas;
    }

    public boolean isPedas() {
        return pedas;
    }

    @Override
    public String getKategori() {
        return "Makanan";
    }

    @Override
    public String toString() {
        return "MenuMakanan[pedas=" + pedas + ", " + super.toString() + "]";
    }
}
