package com.maid.form;

import com.maid.Penilaian;

public class FormDaftar implements Penilaian {

    protected String nik;
    protected String nama;
    protected float nilaiTulis;
    protected float nilaiCoding;
    protected float nilaiWawancara;

    public FormDaftar(String nik, String nama, float nilaiTulis, float nilaiCoding, float nilaiWawancara) {
        this.nik = nik;
        this.nama = nama;
        this.nilaiTulis = nilaiTulis;
        this.nilaiCoding = nilaiCoding;
        this.nilaiWawancara = nilaiWawancara;
    }

    public String getNik() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNilaiTulis(float nilaiTulis) {
        this.nilaiTulis = nilaiTulis;
    }

    public void setNilaiCoding(float nilaiCoding) {
        this.nilaiCoding = nilaiCoding;
    }

    public void setNilaiWawancara(float nilaiWawancara) {
        this.nilaiWawancara = nilaiWawancara;
    }

    @Override
    public float penilaianTulis() {
        return 0;
    }

    @Override
    public float penilaianCoding() {
        return 0;
    }

    @Override
    public float penilaianWawancara() {
        return 0;
    }
}
