package com.ims.praktikum1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView TV_Makanan;
    TextView TV_Harga1;
    TextView TV_Pedas;
    TextView TV_Harga2;
    TextView TV_Tambahan;
    TextView TV_Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Inisial();
        Get_Var();
    }

    private void Inisial() {
        TV_Makanan = (TextView) findViewById(R.id.textView_Result_Makananval);
        TV_Harga1 = (TextView) findViewById(R.id.textView_Result_Harga1val);
        TV_Pedas = (TextView) findViewById(R.id.textView_Result_Pedasval);
        TV_Harga2 = (TextView) findViewById(R.id.textView_Result_Harga2val);
        TV_Tambahan = (TextView) findViewById(R.id.textView_Result_Tambahanval);
        TV_Total = (TextView) findViewById(R.id.textView_Result_Totalval);
    }
    private void Get_Var() {
        //Ambil data yang dikirim dari MainActivity
        Bundle bundle = getIntent().getExtras();

        //Cetak Nama Makanan
        String Makanan = bundle.getString("Makanan");
        TV_Makanan.setText(": " + Makanan);

        //Cetak Harga Makanan
        int Harga1 = Harga_Makanan(Makanan);
        TV_Harga1.setText(": Rp " + String.format("%,2d",Harga1));

        //Cetak Nama Pedas
        float Pedas = bundle.getFloat("Pedas");
        String Nama_Pedas = Level_Pedas(Pedas);
        TV_Pedas.setText(": " + Nama_Pedas);

        //Cetak Tambahan
        boolean Nasi = bundle.getBoolean("chk1_val");
        int Harga_Nasi = Tambahan_Nasi(Nasi);
        boolean Kerupuk = bundle.getBoolean("chk2_val");
        int Harga_Kerupuk = Tambahan_Kerupuk(Kerupuk);
        boolean Lalapan = bundle.getBoolean("chk3_val");
        int Harga_Lalapan = Tambahan_Lalapan(Lalapan);
        boolean Sambel = bundle.getBoolean("chk4_val");
        int Harga_Sambel = Tambahan_Sambel(Sambel);

        //Cetak Tulisan Tambahan
        String Tulisan_Tambahan = Tulisan_Tambahan(Nasi,Kerupuk,Lalapan,Sambel);
        TV_Tambahan.setText(": " + Tulisan_Tambahan);

        //Cetak Total Tambahan
        int Total_Tamhahan = Harga_Nasi + Harga_Kerupuk + Harga_Lalapan + Harga_Sambel;
        TV_Harga2.setText(": Rp " + String.format("%,2d",Total_Tamhahan));

        //Cetak Total Bayar
        int Total_Bayar = Harga1 + Total_Tamhahan;
        TV_Total.setText(": Rp " + String.format("%,2d",Total_Bayar));
    }

    //Fungsi untuk menentukan harga makanan
    private int Harga_Makanan(String Nama) {
        int Harga = 0;
        if(Nama.equals("Rendang")) {
            Harga = 22000;
        } else if(Nama.equals("Ikan Lele")) {
            Harga = 15000;
        } else if(Nama.equals("Ayam Bakar")) {
            Harga = 18000;
        } else {
            Harga = 10000;
        }
        return Harga;
    }

    //Fungsi untuk memberi nama level pedas
    private String Level_Pedas(float RTB) {
        String Lvl = "";
        if(RTB >= 5) {
            Lvl = "Pedas Lidah Mertua";
        } else if(RTB >= 4) {
            Lvl = "Pedas Digebukin";
        } else if(RTB >= 3) {
            Lvl = "Pedas Diselingkuhin";
        } else if(RTB >= 2){
            Lvl = "Pedas Medesah";
        } else {
            Lvl = "Pedas Noob";
        }
        return Lvl;
    }

    private int Tambahan_Nasi(boolean Chk_Nasi) {
        int Nasi = 0;
        if(Chk_Nasi == true){
            Nasi = 8000;
        } else {
            Nasi = 0;
        }
        return Nasi;
    }

    private int Tambahan_Kerupuk(boolean Chk_Kerupuk) {
        int Kerupuk = 0;
        if(Chk_Kerupuk == true){
            Kerupuk = 3000;
        } else {
            Kerupuk = 0;
        }
        return Kerupuk;
    }

    private int Tambahan_Lalapan(boolean Chk_Lalapan) {
        int Lalapan = 0;
        if(Chk_Lalapan == true){
            Lalapan = 5000;
        } else {
            Lalapan = 0;
        }
        return Lalapan;
    }

    private int Tambahan_Sambel(boolean Chk_Sambel) {
        int Sambel = 0;
        if(Chk_Sambel == true){
            Sambel = 5000;
        } else {
            Sambel = 0;
        }
        return Sambel;
    }

    private String Tulisan_Tambahan(boolean Chk1, boolean Chk2, boolean Chk3, boolean Chk4) {
        String Tulisan = "";
        if(Chk1 == true){
            Tulisan += "Nasi ";
        }
        if(Chk2 == true) {
            Tulisan += "Kerupuk ";
        }
        if(Chk3 == true) {
            Tulisan += "Lalapan ";
        }
        if(Chk4 == true) {
            Tulisan += "Sambel ";
        }
        return  Tulisan;
    }

}
