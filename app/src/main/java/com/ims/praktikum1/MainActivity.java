package com.ims.praktikum1;

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

public class MainActivity extends AppCompatActivity {

    RadioGroup Radio_RG;
    RadioButton Radio_RB;
    Button B_Submit;
    RatingBar RTB;
    CheckBox Chk1;
    CheckBox Chk2;
    CheckBox Chk3;
    CheckBox Chk4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Listen_B_Submit();
    }

    private void Inisial() {
        Radio_RG = (RadioGroup) findViewById(R.id.RadioGroup_Main_RG);
        B_Submit = (Button) findViewById(R.id.button_Main_Submit);
        RTB = (RatingBar) findViewById(R.id.ratingBar_Main_Pedas);
        Chk1 = (CheckBox) findViewById(R.id.checkBox_Main_Chk1);
        Chk2 = (CheckBox) findViewById(R.id.checkBox_Main_Chk2);
        Chk3 = (CheckBox) findViewById(R.id.checkBox_Main_Chk3);
        Chk4 = (CheckBox) findViewById(R.id.checkBox_Main_Chk4);
    }

    private void Listen_B_Submit() {
        B_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Get_ID = Radio_RG.getCheckedRadioButtonId();
                Radio_RB = (RadioButton) findViewById(Get_ID);
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
                In.putExtra("Makanan", Makanan);
                In.putExtra("Pedas",Pedas);
                In.putExtra("chk1_val",Chk1_Val);
                In.putExtra("chk2_val",Chk2_Val);
                In.putExtra("chk3_val",Chk3_Val);
                In.putExtra("chk4_val",Chk4_Val);
                startActivity(In);
            }
        });
    }

}
