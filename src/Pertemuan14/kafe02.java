package Pertemuan14;

import java.util.Scanner;

public class kafe02 {
    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (kodePromo.equals("DISKON50")) {
            System.out.println("Kode promo berlaku! Anda mendapatkan diskon 50%.");
        } else if (kodePromo.equals("DISKON30")) {
            System.out.println("Kode promo berlaku! Anda mendapatkan diskon 30%.");
        } else {
            System.out.println("Kode promo invalid atau tidak tersedia.");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappucino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga02(int pilihanMenu, int banyakItem, String kodePromo) {

        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int totalHarga = hargaItems[pilihanMenu - 1] * banyakItem;
        double diskon = 0;

        if (kodePromo.equals("DISKON50")) {
            diskon = totalHarga * 0.50;
            System.out.println("Diskon 50%: Rp" + (int) diskon);
        } else if (kodePromo.equals("DISKON30")) {
            diskon = totalHarga * 0.30;
            System.out.println("Diskon 30%: Rp" + (int) diskon);
        } else {
            System.out.println("Kode promo invalid. Tidak ada diskon.");
        }

        int totalAkhir = (int) (totalHarga - diskon);
        return totalAkhir;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kodePromo = "DISKON30";
        Menu("Budi", true, kodePromo);

        System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
        int pilihanMenu = sc.nextInt();
        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        int banyakItem = sc.nextInt();

        int TotalHarga = hitungTotalHarga02(pilihanMenu, banyakItem, kodePromo);

        System.out.println("Total harga untuk pesanan Anda: Rp" + TotalHarga);
    }
}
