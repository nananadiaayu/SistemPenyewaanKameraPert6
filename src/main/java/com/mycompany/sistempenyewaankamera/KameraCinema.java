package com.mycompany.sistempenyewaankamera;

public class KameraCinema extends Kamera {

    private String resolusiVideo;

    public KameraCinema(String kode, String merk, double hargaSewaPerHari, String resolusiVideo) {
        super(kode, merk, hargaSewaPerHari);
        this.resolusiVideo = resolusiVideo;
    }

    public String getResolusiVideo() {
        return resolusiVideo;
    }

    public void setResolusiVideo(String resolusiVideo) {
        this.resolusiVideo = resolusiVideo;
    }

    @Override
    public String getJenis() {
        return "Cinema Camera";
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf(
                "%-8s %-15s %-18s %-12s Rp%,.0f %-10s%n",
                getKode(),
                getMerk(),
                getJenis(),
                resolusiVideo,
                getHargaSewaPerHari(),
                isTersedia() ? "Tersedia" : "Disewa"
        );
    }
}