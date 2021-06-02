package com.maid.web;

import com.maid.Penilaian;
import com.maid.form.FormDaftar;

import java.util.ArrayList;
import java.util.Arrays;

public class Web extends FormDaftar {

    private static final ArrayList<Double> BOBOT_NILAI = new ArrayList<>(Arrays.asList(
            0.4,
            0.35,
            0.25
    ));

    public Web(ArrayList<String> data) {
        super(data.get(0), data.get(1), Float.parseFloat(data.get(2)), Float.parseFloat(data.get(3)), Float.parseFloat(data.get(4)));
    }

    @Override
    public float penilaianTulis() {
        return (float) (this.nilaiTulis * BOBOT_NILAI.get(0));
    }

    @Override
    public float penilaianCoding() {
        return (float) (this.nilaiCoding * BOBOT_NILAI.get(1));
    }

    @Override
    public float penilaianWawancara() {
        return (float) (this.nilaiWawancara * BOBOT_NILAI.get(2));
    }
}
