package com.hanif.test.model;

import com.google.gson.annotations.SerializedName;

public class Auction {

    @SerializedName("id_barang")
    String idBarang;
    @SerializedName("harga_awal")
    String harga_awal;
    String tgl_lelang;
    String harga_akhir;
    String status;

    public String getId_barang() {
        return idBarang;
    }

    public void setId_barang(String id_barang) {
        this.idBarang = id_barang;
    }

    public String getHarga_awal() {
        return harga_awal;
    }

    public void setHarga_awal(String harga_awal) {
        this.harga_awal = harga_awal;
    }

    public String getTgl_lelang() {
        return tgl_lelang;
    }

    public void setTgl_lelang(String tgl_lelang) {
        this.tgl_lelang = tgl_lelang;
    }

    public String getHarga_akhir() {
        return harga_akhir;
    }

    public void setHarga_akhir(String harga_akhir) {
        this.harga_akhir = harga_akhir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
