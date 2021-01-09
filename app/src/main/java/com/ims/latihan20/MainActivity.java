package com.ims.latihan20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.ims.setting.Globalvar;

public class MainActivity extends AppCompatActivity {

    RadioGroup Radio_RG;
    RadioButton Radio_RB;
    Button B_Submit;
    RatingBar RTB;
    CheckBox Chk1, Chk2, Chk3, Chk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Listen_B_Submit();
    }

    private void Inisial() {
        Radio_RG = findViewById(R.id.RadioGroup_Main_RG);
        B_Submit = findViewById(R.id.button_Main_Submit);
        RTB = findViewById(R.id.ratingBar_Main_Pedas);
        Chk1 = findViewById(R.id.checkBox_Main_Chk1);
        Chk2 = findViewById(R.id.checkBox_Main_Chk2);
        Chk3 = findViewById(R.id.checkBox_Main_Chk3);
        Chk4 = findViewById(R.id.checkBox_Main_Chk4);
    }

    private void Listen_B_Submit() {
        B_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Get_ID = Radio_RG.getCheckedRadioButtonId();
                Radio_RB = findViewById(Get_ID);
                if(Radio_RB == null){
                    Toast.makeText(MainActivity.this, "Silakan pilih makanan.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String Makanan = Radio_RB.getText().toString();
                float Pedas = RTB.getRating();
                boolean Chk1_Val = Chk1.isChecked();
                boolean Chk2_Val = Chk2.isChecked();
                boolean Chk3_Val = Chk3.isChecked();
                boolean Chk4_Val = Chk4.isChecked();
                Intent In = new Intent(MainActivity.this, ResultActivity.class);
                In.putExtra(Globalvar.EXTRA_MAKANAN, Makanan);
                In.putExtra(Globalvar.EXTRA_PEDAS,Pedas);
                In.putExtra(Globalvar.EXTRA_CHK1,Chk1_Val);
                In.putExtra(Globalvar.EXTRA_CHK2,Chk2_Val);
                In.putExtra(Globalvar.EXTRA_CHK3,Chk3_Val);
                In.putExtra(Globalvar.EXTRA_CHK4,Chk4_Val);
                startActivity(In);
            }
        });
    }

}
