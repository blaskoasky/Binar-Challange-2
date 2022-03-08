package com.blaskoasky.main;

import com.blaskoasky.harusadaoopnya.IMainMenu;

import java.util.Scanner;

public class Menu implements IMainMenu {

    Scanner scan = new Scanner(System.in);
    String csvPath = "src/file/data_sekolah.csv";
    String saveMeanMedianModusPath = "src/file/Mean_Median_Modus_DataSekolah.txt";
    String saveModusSekolahPath = "src/file/Modus_Sekolah.txt";

    @Override
    public void switchMenu() {

        MeanMedMod mmm = new MeanMedMod();

        switch (mainMenu()) {
            case 1:
                mmm.write(saveMeanMedianModusPath);
                break;
            case 2:
                mmm.writeMod(saveModusSekolahPath);
                break;
            case 0:
                System.out.println("Keluar Console....");
                return;
            default:
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("PILIH ANGKA YANG BENAR!!!");
                System.out.println("PILIH ANGKA YANG BENAR!!!");
                System.out.println("PILIH ANGKA YANG BENAR!!!");
                System.out.println("PILIH ANGKA YANG BENAR!!!");
                System.out.println("PILIH ANGKA YANG BENAR!!!");
                System.out.println("\n");
                System.out.println("\n");
                switchMenu();
                break;

        }
    }

    @Override
    public int mainMenu() {
        System.out.println("=================================================");
        System.out.println("Aplikasi Mengolah Data Nilai Siswa");
        System.out.println("-------------------------------------------------");
        System.out.println("1. Menghitung Mean-Median-Modus");
        System.out.println("2. Menghitung Modus Sekolah");
        System.out.println("0. Exit");
        System.out.println("=================================================");

        System.out.print("Masukkan Pilihan: ");
        return scan.nextInt();
    }
}
