package com.mycompany.sistempenyewaankamera;

import java.util.Scanner;

public class SistemPenyewaanKamera {

    static Scanner input = new Scanner(System.in);

    static Kamera[] daftarKamera = new Kamera[100];

    static int jumlahKamera = 0;

    public static void main(String[] args) {

        tambahDataAwal();

        int pilihan;

        do {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("        SISTEM PENYEWAAN KAMERA");
            System.out.println("==============================================");
            System.out.println("1. Tambah Data Kamera");
            System.out.println("2. Tampilkan Seluruh Kamera");
            System.out.println("3. Cari Kamera");
            System.out.println("4. Hitung Biaya Penyewaan");
            System.out.println("5. Ubah Status Kamera");
            System.out.println("6. Keluar");
            System.out.println("==============================================");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tambahKamera();
                    break;

                case 2:
                    tampilkanSemuaKamera();
                    break;

                case 3:
                    cariKamera();
                    break;

                case 4:
                    hitungBiaya();
                    break;

                case 5:
                    ubahStatus();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan");
                    System.out.println("Sistem Penyewaan Kamera.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }

    static void tambahDataAwal() {

        daftarKamera[jumlahKamera++] =
                new KameraDSLR(
                        "K001",
                        "Canon",
                        150000,
                        "Full Frame"
                );

        daftarKamera[jumlahKamera++] =
                new KameraDSLR(
                        "K002",
                        "Nikon",
                        175000,
                        "APS-C"
                );

        daftarKamera[jumlahKamera++] =
                new KameraMirrorLess(
                        "K003",
                        "Sony",
                        200000,
                        "24 MP"
                );

        daftarKamera[jumlahKamera++] =
                new KameraMirrorLess(
                        "K004",
                        "Fujifilm",
                        180000,
                        "26 MP"
                );

        daftarKamera[jumlahKamera++] =
                new KameraAction(
                        "K005",
                        "GoPro",
                        125000,
                        true
                );
        daftarKamera[jumlahKamera++] =
        new KameraCinema(
                "K009",
                "Sony FX3",
                350000,
                "4K"
        );
    }

    static void tambahKamera() {

        System.out.println();
        System.out.println("========== TAMBAH KAMERA ==========");

        if (jumlahKamera >= daftarKamera.length) {
            System.out.println("Penyimpanan kamera sudah penuh.");
            return;
        }

        System.out.print("Kode kamera      : ");
        String kode = input.nextLine();

        System.out.print("Merk kamera      : ");
        String merk = input.nextLine();

        System.out.print("Harga sewa/hari  : ");
        double harga = input.nextDouble();
        input.nextLine();

        System.out.println();
        System.out.println("Pilih tipe kamera:");
        System.out.println("1. DSLR");
        System.out.println("2. Mirrorless");
        System.out.println("3. Action Camera");
        System.out.println("4. Cinema Camera");
        System.out.print("Pilihan: ");

        int tipe = input.nextInt();
        input.nextLine();

        Kamera kameraBaru = null;

        switch (tipe) {

            case 1:

                System.out.print("Jenis sensor     : ");
                String sensor = input.nextLine();

                kameraBaru = new KameraDSLR(
                        kode,
                        merk,
                        harga,
                        sensor
                );

                break;

            case 2:

                System.out.print("Resolusi         : ");
                String resolusi = input.nextLine();

                kameraBaru = new KameraMirrorLess(
                        kode,
                        merk,
                        harga,
                        resolusi
                );

                break;

            case 3:

                System.out.print("Tahan air? (y/n) : ");
                String jawaban = input.nextLine();

                boolean tahanAir =
                        jawaban.equalsIgnoreCase("y");

                kameraBaru = new KameraAction(
                        kode,
                        merk,
                        harga,
                        tahanAir
                );

                break;
                
            case 4:
                System.out.print("Resolusi video : ");
                String resolusiVideo = input.nextLine();

                kameraBaru = new KameraCinema(
                        kode,
                        merk,
                        harga,
                        resolusiVideo
                        
                );
                
                break;
            
    
            default:

                System.out.println(
                        "Tipe kamera tidak valid."
                );

                return;
        }

        daftarKamera[jumlahKamera] = kameraBaru;
        jumlahKamera++;

        System.out.println();
        System.out.println(
                "Kamera berhasil ditambahkan!"
        );
    }

    static void tampilkanSemuaKamera() {

        System.out.println();
        System.out.println(
                "=============== DAFTAR KAMERA ==============="
        );

        if (jumlahKamera == 0) {

            System.out.println(
                    "Belum ada data kamera."
            );

            return;
        }

        System.out.printf(
                "%-8s %-15s %-18s %-12s %-15s %-10s%n",
                "Kode",
                "Merk",
                "Jenis",
                "Spesifikasi",
                "Harga/Hari",
                "Status"
        );

        System.out.println(
                "-------------------------------------------------------------------------------"
        );

        for (int i = 0; i < jumlahKamera; i++) {

            // Memanggil method overriding
            daftarKamera[i].tampilkanInfo();
        }

        System.out.println();
        System.out.println(
                "Total objek kamera: "
                + Kamera.getTotalKamera()
        );
    }

    static void cariKamera() {

        System.out.println();
        System.out.println(
                "=============== CARI KAMERA ==============="
        );

        System.out.println("1. Cari berdasarkan kode");
        System.out.println("2. Cari berdasarkan merk");
        System.out.print("Pilih: ");

        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {

            System.out.print("Masukkan kode: ");
            String kode = input.nextLine();

            cariKamera(kode);

        } else if (pilihan == 2) {

            System.out.print("Masukkan merk: ");
            String merk = input.nextLine();

            cariKamera(merk, true);

        } else {

            System.out.println(
                    "Pilihan tidak valid."
            );
        }
    }

    static void cariKamera(String kode) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahKamera; i++) {

            if (daftarKamera[i]
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                daftarKamera[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Kamera dengan kode tersebut tidak ditemukan."
            );
        }
    }

    static void cariKamera(
            String merk,
            boolean berdasarkanMerk) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahKamera; i++) {

            if (daftarKamera[i]
                    .getMerk()
                    .equalsIgnoreCase(merk)) {

                daftarKamera[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println(
                    "Kamera dengan merk tersebut tidak ditemukan."
            );
        }
    }

    static void hitungBiaya() {

        System.out.println();
        System.out.println(
                "========== HITUNG BIAYA SEWA =========="
        );

        System.out.print("Masukkan kode kamera: ");
        String kode = input.nextLine();

        Kamera kamera = null;

        for (int i = 0; i < jumlahKamera; i++) {

            if (daftarKamera[i]
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                kamera = daftarKamera[i];

                break;
            }
        }

        if (kamera == null) {

            System.out.println(
                    "Kamera tidak ditemukan."
            );

            return;
        }

        if (!kamera.isTersedia()) {

            System.out.println(
                    "Kamera sedang disewa."
            );

            return;
        }

        System.out.print("Lama sewa (hari): ");
        int hari = input.nextInt();

        if (hari <= 0) {

            System.out.println(
                    "Jumlah hari harus lebih dari 0."
            );

            return;
        }

        System.out.print("Gunakan diskon? (y/n): ");

        input.nextLine();

        String jawaban = input.nextLine();

        double total;

        if (jawaban.equalsIgnoreCase("y")) {

            System.out.print("Masukkan diskon (%): ");
            double diskon = input.nextDouble();

            if (diskon < 0 || diskon > 100) {

                System.out.println(
                        "Diskon harus antara 0-100%."
                );

                return;
            }

            total = kamera.hitungBiaya(
                    hari,
                    diskon
            );

        } else {

            total = kamera.hitungBiaya(hari);
        }

        System.out.println();
        System.out.println(
                "========== DETAIL PENYEWAAN =========="
        );

        System.out.println(
                "Kode kamera : "
                + kamera.getKode()
        );

        System.out.println(
                "Merk        : "
                + kamera.getMerk()
        );

        System.out.println(
                "Jenis       : "
                + kamera.getJenis()
        );

        System.out.println(
                "Lama sewa   : "
                + hari
                + " hari"
        );

        System.out.printf(
                "Total biaya : Rp%,.0f%n",
                total
        );
    }

    static void ubahStatus() {

        System.out.println();
        System.out.println(
                "========== UBAH STATUS KAMERA =========="
        );

        System.out.print(
                "Masukkan kode kamera: "
        );

        String kode = input.nextLine();

        for (int i = 0; i < jumlahKamera; i++) {

            if (daftarKamera[i]
                    .getKode()
                    .equalsIgnoreCase(kode)) {

                if (daftarKamera[i].isTersedia()) {

                    daftarKamera[i]
                            .setTersedia(false);

                    System.out.println(
                            "Status kamera diubah menjadi DISEWA."
                    );

                } else {

                    daftarKamera[i]
                            .setTersedia(true);

                    System.out.println(
                            "Status kamera diubah menjadi TERSEDIA."
                    );
                }

                return;
            }
        }

        System.out.println(
                "Kamera tidak ditemukan."
        );
    }
    static void prosesKamera(Kamera kamera) {
        System.out.println();
        System.out.println("===== PROSES KAMERA =====");

        System.out.println("Kode  : " + kamera.getKode());
        System.out.println("Jenis : " + kamera.getJenis());

        kamera.tampilkanInfo();
    }
   
    static void simulasiKamera() {

        System.out.println();
        System.out.println("========== SIMULASI KAMERA ==========");

        System.out.print("Masukkan kode kamera: ");
        String kode = input.nextLine();

        for (int i = 0; i < jumlahKamera; i++) {

            if (daftarKamera[i].getKode().equalsIgnoreCase(kode)) {

                prosesKamera(daftarKamera[i]);

                return;
            }
        }

        System.out.println("Kamera tidak ditemukan.");
    }
}