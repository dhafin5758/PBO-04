package id.ac.polban.pbo.kantin.app;

import id.ac.polban.pbo.kantin.model.Mahasiswa;
import id.ac.polban.pbo.kantin.model.MenuItem;
import id.ac.polban.pbo.kantin.model.MenuMakanan;
import id.ac.polban.pbo.kantin.model.MenuMinuman;
import id.ac.polban.pbo.kantin.model.Pesanan;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class UjiInheritance {

    private static void hasil(String id, String skenario, boolean lulus, String bukti) {
        System.out.println(id + " " + (lulus ? "PASS" : "FAIL") + " | " + skenario);
        System.out.println("       bukti: " + bukti);
    }

    private static boolean dideklarasikanDi(Class<?> kelas, String namaMethod) {
        for (Method m : kelas.getDeclaredMethods()) {
            if (m.getName().equals(namaMethod)) {
                return true;
            }
        }
        return false;
    }

    private static boolean semuaFieldPrivate(Class<?> kelas, StringBuilder daftar) {
        boolean ok = true;
        for (Field f : kelas.getDeclaredFields()) {
            ok = ok && Modifier.isPrivate(f.getModifiers());
            daftar.append(f.getName()).append(" ");
        }
        return ok;
    }

    public static void main(String[] args) {
        // T4-01
        MenuMakanan nasi = new MenuMakanan("M01", "Nasi Goreng", 18000, true);
        boolean t1 = nasi.getNama().equals("Nasi Goreng") && nasi.getHarga() == 18000
                && nasi.isTersedia() && nasi.isPedas();
        hasil("T4-01", "Object subclass dibuat melalui constructor", t1,
                "nama=" + nasi.getNama() + ", harga=" + nasi.getHarga() + ", tersedia=" + nasi.isTersedia()
                + " (bagian MenuItem), pedas=" + nasi.isPedas() + " (bagian MenuMakanan)");

        // T4-02
        boolean t2 = !dideklarasikanDi(MenuMakanan.class, "tandaiHabis")
                && !dideklarasikanDi(MenuMakanan.class, "isTersedia");
        nasi.tandaiHabis();
        t2 = t2 && !nasi.isTersedia();
        hasil("T4-02", "Method warisan dipanggil dari subclass", t2,
                "tandaiHabis() & isTersedia() tidak ditulis di MenuMakanan, tapi nasi.isTersedia() = "
                + nasi.isTersedia());

        // T4-03
        MenuMinuman kopi = new MenuMinuman("M02", "Kopi Susu", 12000, false);
        boolean t3 = nasi.getKategori().equals("Makanan") && kopi.getKategori().equals("Minuman")
                && new MenuItem("X", "Polos", 1).getKategori().equals("Umum");
        hasil("T4-03", "Method override dipanggil", t3,
                "getKategori(): MenuItem=Umum, MenuMakanan=" + nasi.getKategori()
                + ", MenuMinuman=" + kopi.getKategori());

        // T4-04
        MenuMinuman esTeh = new MenuMinuman("M03", "Es Teh Manis", 5000, true);
        boolean t4 = esTeh.getHarga() == 5000 + 2000 && kopi.getHarga() == 12000
                && esTeh.toString().contains(new MenuItem("M03", "Es Teh Manis", 7000).toString());
        hasil("T4-04", "Override memakai super.method(...)", t4,
                "getHarga() es teh = super.getHarga() + biaya es = " + esTeh.getHarga()
                + ", kopi hangat = " + kopi.getHarga()
                + "; toString() ikut membawa hasil super.toString()");

        // T4-05
        StringBuilder daftar = new StringBuilder();
        boolean t5 = semuaFieldPrivate(MenuItem.class, daftar)
                & semuaFieldPrivate(MenuMakanan.class, daftar)
                & semuaFieldPrivate(MenuMinuman.class, daftar);
        hasil("T4-05", "Akses state mengikuti encapsulation", t5,
                "semua field (" + daftar.toString().trim() + ") berstatus private; subclass mengakses lewat getter / super");

        // T4-06
        MenuMinuman tehHangat = new MenuMinuman("M03", "Es Teh Manis", 5000, false);
        boolean t6 = !nasi.toString().equals(esTeh.toString())
                && nasi.getKategori().equals("Makanan") && esTeh.getKategori().equals("Minuman")
                && esTeh.getHarga() != tehHangat.getHarga();
        hasil("T4-06", "Dua subclass diuji", t6,
                "MenuMakanan -> " + nasi.getKategori() + ", harga " + nasi.getHarga()
                + "; MenuMinuman dingin -> " + esTeh.getKategori() + ", harga " + esTeh.getHarga()
                + " (bahan sama versi hangat: " + tehHangat.getHarga() + ")"
                + "; Kopi Susu (hangat) -> harga " + kopi.getHarga());

        // T4-07 (alur Main tugas 3: p1, p2, p3 dibuat berurutan)
        Mahasiswa m1 = new Mahasiswa("241001", "Asep");
        Mahasiswa m2 = new Mahasiswa("241002", "Siti");
        MenuMakanan nasi2 = new MenuMakanan("M01", "Nasi Goreng", 18000, true);
        MenuMinuman kopi2 = new MenuMinuman("M02", "Kopi Susu", 12000, false);
        kopi2.tandaiHabis();
        Pesanan p1 = new Pesanan(m1, nasi2, 2);
        Pesanan p2 = new Pesanan(m2, kopi2, 1);
        Pesanan p3 = new Pesanan(m1, nasi2, 3);
        boolean t7 = p1.dapatDiproses() && p1.hitungTotal() == 36000 && !p2.dapatDiproses()
                && p1.getNomor() == 1 && p2.getNomor() == 2 && p3.getNomor() == 3;
        hasil("T4-07", "Regression tugas lama", t7,
                "P1 dapat diproses=" + p1.dapatDiproses() + ", Total P1=" + p1.hitungTotal()
                + ", P2 dapat diproses=" + p2.dapatDiproses()
                + ", nomor p1/p2/p3=" + p1.getNomor() + "/" + p2.getNomor() + "/" + p3.getNomor());
    }
}
