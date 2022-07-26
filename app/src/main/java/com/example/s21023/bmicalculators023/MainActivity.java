package com.example.s21023.bmicalculators023;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HellowListener listener = new HellowListener();

        Button keisan = findViewById(R.id.keisan);
        keisan.setOnClickListener(listener);

        Button btClear = findViewById(R.id.Clear);
        btClear.setOnClickListener(listener);
    }

    private class HellowListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            TextView himan = findViewById(R.id.himando_kekka);
            TextView tekisei = findViewById(R.id.taiju_kekka);

            EditText nenrei = findViewById(R.id.editNenrei);
            EditText sintou = findViewById(R.id.editSintyo);
            EditText taiju = findViewById(R.id.editTaiju);

            Float nenrei1 = Float.parseFloat(nenrei.getText().toString());
            Float sintyo1 = Float.parseFloat(sintou.getText().toString());
            Float taiju1 = Float.parseFloat(taiju.getText().toString());

            sintyo1 = sintyo1 / 100;

            int id = view.getId();

            switch (id){
                case R.id.keisan:
                    double BMI = 0;
                    BMI = taiju1 / (sintyo1 * sintyo1);

                    if(BMI < 18.5){
                        himan.setText("低体重");
                        himan.setTextColor(Color.RED);
                    }else if(BMI >= 18.5 && BMI < 25){
                        himan.setText("普通体重");
                        himan.setTextColor(Color.YELLOW);
                    }else if(BMI >= 25 && BMI < 30){
                        himan.setText("肥満度（１）");
                        himan.setTextColor(Color.MAGENTA);
                    }else if(BMI >= 30 && BMI < 35){
                        himan.setText("肥満度（２）");
                        himan.setTextColor(Color.BLUE);
                    }else if(BMI >= 35 && BMI < 40){
                        himan.setText("肥満度（３）");
                        himan.setTextColor(Color.GREEN);
                    }else{
                        himan.setText("肥満度（４）");
                        himan.setTextColor(Color.DKGRAY);
                    }

                    if(nenrei1 < 16){
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                    }
                    double tai = 0;
                    tai = (sintyo1 * sintyo1) * 22;
                    tekisei.setText(String.format("%.1f",tai));
                    break;

                case R.id.Clear:
                    himan.setText("");
                    tekisei.setText("");
                    nenrei.setText("");
                    sintou.setText("");
                    taiju.setText("");
                    break;
            }
        }
    }
}