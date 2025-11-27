package Pertemuan14;

import java.util.Scanner;
public class NilaiMahasiswa02 {
    public static int[] isianArray(int N) {
        Scanner input = new Scanner(System.in);
        int[] nilai = new int[N];

        System.out.println("=== Input Nilai Mahasiswa ===");
        for (int i = 0; i < N; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + ": ");
            nilai[i] = input.nextInt();
        }
        return nilai;
    }

    public static void tampilArray(int[] nilai) {
        System.out.println("\n=== Daftar Nilai Mahasiswa ===");
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1) + ": " + nilai[i]);
        }
    }

    public static int hitTot(int[] nilai) {
        int total = 0;
        for (int i = 0; i < nilai.length; i++) {
            total += nilai[i];
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int N = sc.nextInt();

        int[] nilaiMahasiswa = isianArray(N);
        tampilArray(nilaiMahasiswa);

        int totalNilai = hitTot(nilaiMahasiswa);
        System.out.println("\nTotal nilai seluruh mahasiswa: " + totalNilai);

        sc.close();
    }
}
