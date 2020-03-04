package com.hanif.adminapp.model;

import com.google.gson.annotations.SerializedName;

public class Stuff {
    @SerializedName("id_barang")
    String idBarang;
    @SerializedName("nama_barang")
    String nama_barang;
    @SerializedName("kategori_barang")
    String kategori_barang;
    @SerializedName("tgl")
    String tgl;
    @SerializedName("harga_awal")
    String harga_awal;
    @SerializedName("deskripsi_barang")
    String deskripsi_barang;

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getKategori_barang() {
        return kategori_barang;
    }

    public void setKategori_barang(String kategori_barang) {
        this.kategori_barang = kategori_barang;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getHarga_awal() {
        return harga_awal;
    }

    public void setHarga_awal(String harga_awal) {
        this.harga_awal = harga_awal;
    }

    public String getDeskripsi_barang() {
        return deskripsi_barang;
    }

    public void setDeskripsi_barang(String deskripsi_barang) {
        this.deskripsi_barang = deskripsi_barang;
    }
}
