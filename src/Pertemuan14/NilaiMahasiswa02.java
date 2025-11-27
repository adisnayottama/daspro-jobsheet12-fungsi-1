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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int N = sc.nextInt();

        int[] nilaiMahasiswa = isianArray(N);

        System.out.println("\nNilai mahasiswa yang telah diinput:");
        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1) + ": " + nilaiMahasiswa[i]);
        }
        sc.close();
    }
}
