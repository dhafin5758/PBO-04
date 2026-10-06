package id.ac.polban.pbo.kantin.app;

import id.ac.polban.pbo.kantin.model.Pesanan;

public class Kasir {
public void proses(Pesanan pesanan) {
if (pesanan.dapatDiproses()) {
System.out.println("Pesanan diproses");
} else {
System.out.println("Pesanan ditolak");
}
}
}