package id.ac.polban.pbo.kantin.model;

public class MenuMinuman extends MenuItem {
    private static final int BIAYA_ES = 2000;

    private boolean dingin;

    public MenuMinuman(String kode, String nama, int harga, boolean dingin) {
        super(kode, nama, harga);
        this.dingin = dingin;
    }

    public boolean isDingin() {
        return dingin;
    }

    // harga minuman dingin = harga menu + biaya es
    @Override
    public int getHarga() {
        return super.getHarga() + (dingin ? BIAYA_ES : 0);
    }

    @Override
    public String getKategori() {
        return "Minuman";
    }

    @Override
    public String toString() {
        return "MenuMinuman[dingin=" + dingin + ", " + super.toString() + "]";
    }
}
