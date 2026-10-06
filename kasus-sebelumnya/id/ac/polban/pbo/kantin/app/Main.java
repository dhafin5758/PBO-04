package id.ac.polban.pbo.kantin.app;

import id.ac.polban.pbo.kantin.model.Mahasiswa;
import id.ac.polban.pbo.kantin.model.MenuMakanan;
import id.ac.polban.pbo.kantin.model.MenuMinuman;
import id.ac.polban.pbo.kantin.model.Pesanan;

public class Main {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("241001", "Asep");
        Mahasiswa m2 = new Mahasiswa("241002", "Siti");

        System.out.println(m1.getNim() + " - " + m1.getNama());
        System.out.println(m2.getNim() + " - " + m2.getNama());

        MenuMakanan nasi = new MenuMakanan("M01", "Nasi Goreng", 18000, true);
        MenuMinuman kopi = new MenuMinuman("M02", "Kopi Susu", 12000, false);

        kopi.tandaiHabis();

        System.out.println(nasi.getNama() + " tersedia: " + nasi.isTersedia());
        System.out.println(kopi.getNama() + " tersedia: " + kopi.isTersedia());

        Pesanan p1 = new Pesanan(m1, nasi, 2);
        Pesanan p2 = new Pesanan(m2, kopi, 1);
        Pesanan p3 = new Pesanan(m1, nasi, 3);

        System.out.println("P1 dapat diproses: " + p1.dapatDiproses());
        System.out.println("Total P1: " + p1.hitungTotal());
        System.out.println("P2 dapat diproses: " + p2.dapatDiproses());

        System.out.println("Nomor p1: " + p1.getNomor());
        System.out.println("Nomor p2: " + p2.getNomor());
        System.out.println("Nomor p3: " + p3.getNomor());

        Kasir kasir = new Kasir();
        kasir.proses(p1);
        kasir.proses(p2);

        // ---- bagian baru (Praktikum 4): dua subclass MenuItem ----
        System.out.println();
        MenuMinuman esTeh = new MenuMinuman("M03", "Es Teh Manis", 5000, true);

        System.out.println(nasi);
        System.out.println(kopi);
        System.out.println(esTeh);
        System.out.println();

        System.out.println(nasi.getNama() + " kategori " + nasi.getKategori()
                + ", harga " + nasi.getHarga());
        System.out.println(kopi.getNama() + " kategori " + kopi.getKategori()
                + ", harga " + kopi.getHarga());
        System.out.println(esTeh.getNama() + " kategori " + esTeh.getKategori()
                + ", harga " + esTeh.getHarga());

        Pesanan p4 = new Pesanan(m2, esTeh, 3);
        System.out.println("Total P4 (3 x Es Teh Manis): " + p4.hitungTotal());
    }
}