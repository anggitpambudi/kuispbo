package com.maid;

import com.maid.android.Android;
import com.maid.form.FormDaftar;
import com.maid.web.Web;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Android android = null;
        Web web = null;
        Main main = new Main();
        String rawInputMenu;
        int inputMenu;
        String rawInputMenuData;
        int inputMenuData;

        while (true) {
            System.out.println("Form Pendaftaran PT MAID");
            System.out.println("1. Android Development");
            System.out.println("2. Web Development");
            System.out.print("Pilih Jenis Form : ");
            rawInputMenu = main.scanner.nextLine();

            try {
                inputMenu = Integer.parseInt(rawInputMenu);
                if (inputMenu > 0 && inputMenu < 3) {
                    break;
                } else {
                    System.out.println("Input Tidak Valid");
                }
            } catch (Exception e) {
                System.out.println("Input Tidak Valid!");
            }
        }

        ArrayList<String> dataDiri = main.inputDataForm(0);

        if (inputMenu == 1) {
            android = new Android(dataDiri);
        } else {
            web = new Web(dataDiri);
        }

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Edit");
            System.out.println("2. Tampil");
            System.out.println("3. Exit");
            System.out.print("Pilih : ");

            rawInputMenuData = main.scanner.nextLine();

            try {
                inputMenuData = Integer.parseInt(rawInputMenuData);
                if ((inputMenuData > 0) && (inputMenuData < 4)) {
                    switch (inputMenuData) {
                        case 1:
                            dataDiri = main.inputDataForm(1);
                            if (inputMenu == 1) {
                                android.setNilaiTulis(Float.parseFloat(dataDiri.get(2)));
                                android.setNilaiCoding(Float.parseFloat(dataDiri.get(2)));
                                android.setNilaiWawancara(Float.parseFloat(dataDiri.get(2)));

                            } else {
                                web.setNilaiTulis(Float.parseFloat(dataDiri.get(2)));
                                web.setNilaiCoding(Float.parseFloat(dataDiri.get(2)));
                                web.setNilaiWawancara(Float.parseFloat(dataDiri.get(2)));
                            }
                            break;
                        case 2:
                            float nilaiAkhir;
                            String nama;
                            String divisi;
                            if (inputMenu == 1) {
                                nilaiAkhir = (android.penilaianCoding() + android.penilaianTulis() + android.penilaianWawancara());
                                nama = android.getNama();
                                divisi = "Android";
                            } else {
                                nilaiAkhir = (web.penilaianCoding() + web.penilaianTulis() + web.penilaianWawancara());
                                nama = web.getNama();
                                divisi = "Web";
                            }
                            System.out.println("Nilai Akhir : " + nilaiAkhir);
                            if (nilaiAkhir < 70) {
                                System.out.println("Keterangan : GAGAL!");
                                System.out.println("Mohon Maaf Kepada " + nama + " Telah Ditolak Sebagai " + divisi + " Developer");
                            } else {
                                System.out.println("Keterangan : LOLOS!");
                                System.out.println("Selamat Kepada " + nama + " Telah Diterima Sebagai " + divisi + " Developer");
                            }
                            break;
                        case 3:
                            System.exit(1);
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Input Tidak Valid!");
            }
        }

    }

    private String integerInput(String msg) {
        String rawInput;
        int input;

        while (true) {
            System.out.print(msg);
            rawInput = scanner.nextLine();
            try {
                input = Integer.parseInt(rawInput);
                return String.valueOf(input);
            } catch (Exception ignored) {
            }
        }
    }

    private ArrayList<String> inputDataForm(int determine) {

        ArrayList<String> dataDiri = new ArrayList<>();
        int i;
        if (determine == 1) {
            i = 1;
        } else {
            i = 0;
        }
        final String[] INPUT_DATA_MSG = {
                "Input NIK : ",
                "Input Nilai Tes Tulis : ",
                "Input Nilai Tes Coding : ",
                "Input Nilai Tes Wawancara : "
        };

        for (; i < INPUT_DATA_MSG.length; i++) {
            if (i == 1 && determine != 1) {
                System.out.print("Input Nama : ");
                dataDiri.add(scanner.nextLine());
            }
            dataDiri.add(integerInput(INPUT_DATA_MSG[i]));
        }
        return dataDiri;
    }


}
