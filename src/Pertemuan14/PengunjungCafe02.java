package Pertemuan14;

public class PengunjungCafe02 {
    public static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");

        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        daftarPengunjung("Ali", "Budi", "Citra");
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Galih");
    }
}
