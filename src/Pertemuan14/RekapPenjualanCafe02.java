package Pertemuan14;

import java.util.Scanner;

public class RekapPenjualanCafe02 {
    private int[][] dataPenjualan;
    private String[] namaMenu;
    private String[] namaHari;
    private int jumlahMenu;
    private int jumlahHari;

    public RekapPenjualanCafe02() {
    }

    public void inputJumlahMenuDanHari() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== INPUT JUMLAH MENU DAN HARI ===");

        System.out.print("Masukkan jumlah menu: ");
        jumlahMenu = scanner.nextInt();
        scanner.nextLine();

        namaMenu = new String[jumlahMenu];
        System.out.println("\nMasukkan nama menu:");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.print("Menu ke-" + (i + 1) + ": ");
            namaMenu[i] = scanner.nextLine();
        }

        System.out.print("\nMasukkan jumlah hari penjualan: ");
        jumlahHari = scanner.nextInt();

        dataPenjualan = new int[jumlahMenu][jumlahHari];
        namaHari = new String[jumlahHari];
        for (int i = 0; i < jumlahHari; i++) {
            namaHari[i] = "Hari ke " + (i + 1);
        }

        System.out.println("\nKonfigurasi berhasil! " + jumlahMenu + " menu selama " + jumlahHari + " hari.\n");
    }

    public void inputDataPenjualan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== INPUT DATA PENJUALAN ===");

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println("\nMenu: " + namaMenu[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("Masukkan penjualan untuk " + namaHari[j] + ": ");
                dataPenjualan[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nData penjualan berhasil diinput!\n");
    }

    public void tampilkanDataPenjualan() {
        System.out.println("=== REKAPITULASI PENJUALAN KAFE IBU MARIANA ===");

        System.out.printf("%-20s", "Menu/Hari");
        for (String hari : namaHari) {
            System.out.printf("%-12s", hari);
        }
        System.out.println();

        int totalWidth = 20 + 12 * jumlahHari;
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < jumlahMenu; i++) {
            System.out.printf("%-20s", namaMenu[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.printf("%-12d", dataPenjualan[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void tampilkanMenuTerlaris() {
        if (jumlahMenu == 0) {
            System.out.println("Belum ada data menu!");
            return;
        }

        int maxTotal = 0;
        String menuTerlaris = "";
        int[] totalPerMenu = new int[jumlahMenu];

        System.out.println("=== MENU DENGAN PENJUALAN TERTINGGI ===");

        for (int i = 0; i < jumlahMenu; i++) {
            int total = 0;
            for (int j = 0; j < jumlahHari; j++) {
                total += dataPenjualan[i][j];
            }
            totalPerMenu[i] = total;

            System.out.println(namaMenu[i] + ": " + total + " pcs");

            if (total > maxTotal) {
                maxTotal = total;
                menuTerlaris = namaMenu[i];
            }
        }

        System.out.println("\n>>> Menu Terlaris: " + menuTerlaris);
        System.out.println(">>> Total Penjualan: " + maxTotal + " pcs\n");
    }

    public void tampilkanRataRataPenjualan() {
        if (jumlahMenu == 0) {
            System.out.println("Belum ada data menu!");
            return;
        }

        System.out.println("=== RATA-RATA PENJUALAN PER MENU ===");
        System.out.printf("%-20s %-15s\n", "Menu", "Rata-rata");
        System.out.println("----------------------------------------");

        for (int i = 0; i < jumlahMenu; i++) {
            int total = 0;
            for (int j = 0; j < jumlahHari; j++) {
                total += dataPenjualan[i][j];
            }
            double rataRata = (double) total / jumlahHari;
            System.out.printf("%-20s %-15.2f\n", namaMenu[i], rataRata);
        }
        System.out.println();
    }

    public void tampilkanAnalisisTambahan() {
        if (jumlahMenu == 0) {
            System.out.println("Belum ada data menu!");
            return;
        }

        System.out.println("=== ANALISIS TAMBAHAN ===");

        for (int i = 0; i < jumlahMenu; i++) {
            int maxHari = 0;
            int maxPenjualan = 0;

            for (int j = 0; j < jumlahHari; j++) {
                if (dataPenjualan[i][j] > maxPenjualan) {
                    maxPenjualan = dataPenjualan[i][j];
                    maxHari = j + 1;
                }
            }

            System.out.println(namaMenu[i] + " terlaris pada Hari ke-" + maxHari + " (" + maxPenjualan + " pcs)");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RekapPenjualanCafe02 kafe = new RekapPenjualanCafe02();

        kafe.inputJumlahMenuDanHari();
        kafe.inputDataPenjualan();
        kafe.tampilkanDataPenjualan();
        kafe.tampilkanMenuTerlaris();
        kafe.tampilkanRataRataPenjualan();
        kafe.tampilkanAnalisisTambahan();
    }
}