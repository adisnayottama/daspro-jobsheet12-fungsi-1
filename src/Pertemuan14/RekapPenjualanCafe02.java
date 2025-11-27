package Pertemuan14;

import java.util.Scanner;

public class RekapPenjualanCafe02 {
    private int[][] dataPenjualan;
    private String[] namaMenu;
    private String[] namaHari;
    private final int JUMLAH_MENU = 5;
    private final int JUMLAH_HARI = 7;

    public RekapPenjualanCafe02() {
        dataPenjualan = new int[JUMLAH_MENU][JUMLAH_HARI];
        namaMenu = new String[] { "Kopi", "Teh", "Es Kelapa Muda", "Roti Bakar", "Gorengan" };
        namaHari = new String[] { "Hari ke 1", "Hari ke 2", "Hari ke 3", "Hari ke 4",
                "Hari ke 5", "Hari ke 6", "Hari ke 7" };
    }

    public void inputDataPenjualan() {

        int[][] dataDariScreenshot = {
                { 20, 20, 25, 20, 10, 60, 10 },
                { 30, 80, 40, 10, 15, 20, 25 },
                { 5, 9, 20, 25, 10, 5, 45 },
                { 50, 8, 17, 18, 10, 30, 6 },
                { 15, 10, 16, 15, 10, 10, 55 }
        };

        for (int i = 0; i < JUMLAH_MENU; i++) {
            for (int j = 0; j < JUMLAH_HARI; j++) {
                dataPenjualan[i][j] = dataDariScreenshot[i][j];
            }
        }

        System.out.println("Data penjualan berhasil diinput dari data yang diberikan!\n");
    }

    public void tampilkanDataPenjualan() {
        System.out.println("=== REKAPITULASI PENJUALAN KAFE IBU MARIANA ===");

        System.out.printf("%-20s", "Menu/Hari");
        for (String hari : namaHari) {
            System.out.printf("%-12s", hari);
        }
        System.out.println();

        for (int i = 0; i < 20 + 12 * JUMLAH_HARI; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < JUMLAH_MENU; i++) {
            System.out.printf("%-20s", namaMenu[i]);
            for (int j = 0; j < JUMLAH_HARI; j++) {
                System.out.printf("%-12d", dataPenjualan[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void tampilkanMenuTerlaris() {
        int maxTotal = 0;
        String menuTerlaris = "";
        int[] totalPerMenu = new int[JUMLAH_MENU];

        System.out.println("=== MENU DENGAN PENJUALAN TERTINGGI ===");

        for (int i = 0; i < JUMLAH_MENU; i++) {
            int total = 0;
            for (int j = 0; j < JUMLAH_HARI; j++) {
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
        System.out.println("=== RATA-RATA PENJUALAN PER MENU ===");
        System.out.printf("%-20s %-15s\n", "Menu", "Rata-rata");
        System.out.println("----------------------------------------");

        for (int i = 0; i < JUMLAH_MENU; i++) {
            int total = 0;
            for (int j = 0; j < JUMLAH_HARI; j++) {
                total += dataPenjualan[i][j];
            }
            double rataRata = (double) total / JUMLAH_HARI;
            System.out.printf("%-20s %-15.2f\n", namaMenu[i], rataRata);
        }
        System.out.println();
    }

    public void tampilkanAnalisisTambahan() {
        System.out.println("=== ANALISIS TAMBAHAN ===");

        for (int i = 0; i < JUMLAH_MENU; i++) {
            int maxHari = 0;
            int maxPenjualan = 0;

            for (int j = 0; j < JUMLAH_HARI; j++) {
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

        kafe.inputDataPenjualan();
        kafe.tampilkanDataPenjualan();
        kafe.tampilkanMenuTerlaris();
        kafe.tampilkanRataRataPenjualan();
        kafe.tampilkanAnalisisTambahan();
    }
}