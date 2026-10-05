package com.mycompany.sistempenyewaankamera;

public class Kamera {

    private String kode;
    private String merk;
    private double hargaSewaPerHari;
    private boolean tersedia;

    private static int totalKamera = 0;

    public Kamera(String kode, String merk, double hargaSewaPerHari) {
        this.kode = kode;
        this.merk = merk;
        setHargaSewaPerHari(hargaSewaPerHari);
        this.tersedia = true;

        totalKamera++;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        if (kode != null && !kode.trim().isEmpty()) {
            this.kode = kode;
        } else {
            System.out.println("Kode kamera tidak boleh kosong.");
        }
    }

    public String getMerk() {
        return merk;
    }
    public void setMerk(String merk) {
        if (merk != null && !merk.trim().isEmpty()) {
            this.merk = merk;
        } else {
            System.out.println("Merk kamera tidak boleh kosong.");
        }
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        if (hargaSewaPerHari > 0) {
            this.hargaSewaPerHari = hargaSewaPerHari;
        } else {
            this.hargaSewaPerHari = 0;
            System.out.println("Harga sewa harus lebih dari 0.");
        }
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public static int getTotalKamera() {
        return totalKamera;
    }

    public String getJenis() {
        return "Kamera Umum";
    }

    public void tampilkanInfo() {
        System.out.printf(
                "%-8s %-15s %-18s Rp%,.0f%n",
                kode,
                merk,
                getJenis(),
                hargaSewaPerHari
        );
    }

    public double hitungBiaya(int hari) {
        return hargaSewaPerHari * hari;
    }

    public double hitungBiaya(int hari, double diskon) {
        double total = hargaSewaPerHari * hari;
        return total - (total * diskon / 100);
    }
}
