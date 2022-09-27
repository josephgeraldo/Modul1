/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul1;

import java.util.Scanner;

//Joseph Geraldo - 1121054

class Pasien{
    String nama;
    JenisKamar [] rawatInap = new JenisKamar[10];
    JenisPerawatan [] perawatan = new JenisPerawatan[5];
    Boolean pakaiBPJS;
}

class JenisKamar{
    String kelas;
    int hargaPerHari;
}

class JenisPerawatan{
    public JenisPerawatan(){
    }
    String nama;
    int biaya;
}

public class Modul1 {
    static Scanner scan = new Scanner (System.in);
    public static void main(String[] args) {
        int jumlahP,jKamar, jumlahJK = 10;
        System.out.print("Jumlah Pasien : ");
        jumlahP = scan.nextInt();
        Pasien[] patients = new Pasien[jumlahP];
        for (int i = 0; i < jumlahP; i++) {
            patients[i] = new Pasien();
            System.out.println("Pasien " + (i+1) + " : ");
            System.out.print("Nama : ");
            patients[i].nama = scan.next().toLowerCase();
            for (int j = 0; j < jumlahJK; j++) {
                patients[i].rawatInap[j] = new JenisKamar();
                System.out.println("Jenis Kamar : \n"
                        + "1. VIP\n"
                        + "2. I\n"
                        + "3. II\n"
                        + "4. III\n");
                System.out.print("Jenis Kamar untuk hari ke " + (j+1) + " : ");
                jKamar = scan.nextInt();
                switch (jKamar){
                    case 1:
                        patients[i].rawatInap[j].kelas = "VIP";
                        patients[i].rawatInap[j].hargaPerHari = 1000000;
                        break;
                    case 2:
                        patients[i].rawatInap[j].kelas = "I";
                        patients[i].rawatInap[j].hargaPerHari = 600000;
                        break;
                    case 3:
                        patients[i].rawatInap[j].kelas = "II";
                        patients[i].rawatInap[j].hargaPerHari = 500000;
                        break;
                    case 4:
                        patients[i].rawatInap[j].kelas = "III";
                        patients[i].rawatInap[j].hargaPerHari = 300000;
                        break;
                    default:
                        System.out.println("Pilihan Jenis Kamar Tidak Tersedia");
                        break;
                }
            }
            int jumlahJP = 5;
            for (int j = 0; j < jumlahJP; j++) {
                patients[i].perawatan[j] = new JenisPerawatan();
                System.out.println("Jenis Perawatan : \n"
                        + "1. Operasi\n"
                        + "2. X-Ray\n"
                        + "3. USG\n"
                        + "4. Rontgen\n");
                System.out.print("Masukkan Jenis Perawatan Ke " + (j+1) + " : ");
                int jPerawatan = scan.nextInt();
                switch (jPerawatan){
                    case 1:
                        patients[i].perawatan[j].nama = "operasi";
                        patients[i].perawatan[j].biaya = 3000000;
                        break;
                    case 2:
                        patients[i].perawatan[j].nama = "x-Ray";
                        patients[i].perawatan[j].biaya = 800000;
                        break;
                    case 3:
                        patients[i].perawatan[j].nama = "uSG";
                        patients[i].perawatan[j].biaya = 500000;
                        break;
                    case 4:
                        patients[i].perawatan[j].nama = "rontgen";
                        patients[i].perawatan[j].biaya = 700000;
                        break;
                    default:
                        System.out.println("Pilihan Jenis Perawatan Tidak Tersedia");
                }
            }
            System.out.print("Pakai BPJS (y/n) : ");
            char bpjs = scan.next().toLowerCase().charAt(0);
            if (bpjs == 'y'){
                patients[i].pakaiBPJS = true;
            } else if (bpjs == 'n'){
                patients[i].pakaiBPJS = false;
            }
        }
        int menu = 0;
        System.out.print("Pilih Menu\n"
                + "1. Total Biaya Seorang Pasien\n"
                + "2. Total Pendapatan Rumah Sakit\n"
                + "3. Banyak Pasien Dengan Perawatan Tertentu\n"
                + "4. Exit\n");
        System.out.print("Masukkan Menu : ");
        menu = scan.nextInt();
        char lanjut1 = 'y';
        while (menu != 4){
            if (menu == 1) {
                while (lanjut1 != 'n') {
                    System.out.print("No Pasien Yang Ingin Dilihat Biaya: ");
                    int noP = scan.nextInt() - 1;
                    System.out.println("Total Biaya Pasien " + (noP + 1) + " : " + biayaPerPasien(patients, noP));
                    System.out.print("Lanjut (y/n):");
                    lanjut1 = scan.next().toLowerCase().charAt(0);
                }
                System.out.println("Pilih Menu\n"
                        + "1. Total Biaya Seorang Pasien\n"
                        + "2. Total Pendapatan Rumah Sakit\n"
                        + "3. Banyak Pasien Dengan Perawatan Tertentu\n"
                        + "4. Exit\n");
                System.out.print("Masukkan Menu : ");
                menu = scan.nextInt();
            } else if (menu == 2) {
                System.out.println("Total Pendapatan Rumah Sakit : " + totalPendapatan(patients));
                System.out.print("Pilih Menu\n"
                        + "1. Total Biaya Seorang Pasien\n"
                        + "2. Total Pendapatan Rumah Sakit\n"
                        + "3. Banyak Pasien Dengan Perawatan Tertentu\n"
                        + "4. Exit\n");
                System.out.print("Masukkan Menu : ");
                menu = scan.nextInt();
            } else if (menu == 3){
                System.out.print("Jenis Perawatan Yang Dicek : ");
                String jp = scan.next().toLowerCase();
                System.out.println("Jumlah Pasien Perawatan " + jp + " : " + perawatanTertentu(jp, patients));
                System.out.print("Pilih Menu\n"
                        + "1. Total Biaya Seorang Pasien\n"
                        + "2. Total Pendapatan Rumah Sakit\n"
                        + "3. Banyak Pasien Dengan Perawatan Tertentu\n"
                        + "4. Exit\n");
                System.out.print("Masukkan Menu : ");
                menu = scan.nextInt();
            } else if (menu == 4) {
                System.out.println("Exit!!!");
            }else {
                System.out.println("Menu Tidak Ditemukan");
                System.out.print("Pilih Menu\n"
                        + "1. Total Biaya Seorang Pasien\n"
                        + "2. Total Pendapatan Rumah Sakit\n"
                        + "3. Banyak Pasien Dengan Perawatan Tertentu\n"
                        + "4. Exit\n");
                System.out.print("Masukkan Menu : ");
                menu = scan.nextInt();
            }
        }
    }
    
    static int biayaPerPasien(Pasien[] patients, int noP){
        int total = 0;
        if (patients[noP].pakaiBPJS == true){
            for (int i = 0; i < patients[noP].perawatan.length; i++) {
                total += patients[noP].perawatan[i].biaya;
            }
            return total;
        } else {
            for (int i = 0; i < patients[noP].rawatInap.length; i++) {
                total += patients[noP].rawatInap[i].hargaPerHari;
            }
            for (int i = 0; i < patients[noP].perawatan.length; i++) {
                total += patients[noP].perawatan[i].biaya;
            }
            return total;
        }
    }
    
    static int totalPendapatan (Pasien[] patients){
        int total = 0;
        for (int i = 0; i < patients.length; i++) {
            for (int j = 0; j < patients[i].rawatInap.length; j++) {
                total += patients[i].rawatInap[j].hargaPerHari;
            }
            for (int j = 0; j < patients[i].perawatan.length; j++) {
                total += patients[i].perawatan[j].biaya;
            }
        }
        return total;
    }
    
    static int perawatanTertentu(String jp, Pasien[] patients) {
        int total = 0;
        Boolean stat = false;
        for (int i = 0; i < patients.length; i++) {
            stat = false;
            for (int j = 0; j < patients[i].perawatan.length; j++) {
                if (patients[i].perawatan[j].nama.equals(jp)) {
                    stat = true;
                }
            }
            if (stat == true) {
                total++;
            }
        }
        return total;
    }
}
