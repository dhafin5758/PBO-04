package id.ac.polban.pbo.kantin.model;

public class MenuItem {
    private String kode;
    private String nama;
    private int harga;
    private boolean tersedia;

    public MenuItem(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.tersedia = true;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void tandaiHabis() {
        tersedia = false;
    }

    public String getKategori() {
        return "Umum";
    }

    @Override
    public String toString() {
        return "MenuItem[kode=" + kode + ", nama=" + nama
                + ", harga=" + getHarga() + ", tersedia=" + tersedia + "]";
    }
}