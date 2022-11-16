package edu.bzu.inclassactivity.projone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText weightID ;
    private EditText hieghtID;
    private SwitchCompat switchID; // used SwComp due to emulator suggestion
    private Button btnCalcID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAllViewByID( );

        btnCalcID.setOnClickListener(view -> {
            String w  = weightID.getText().toString().trim();
            String h = hieghtID.getText().toString().trim();

            if (!w.equals("") && !h.equals(""))  {
                boolean check = switchID.isChecked();

                double getBMI = calcBMI(Double.parseDouble(w),Double.parseDouble(h),check);
                Toast.makeText(this, "BMI Value is : " + getBMI, Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void initAllViewByID( ) {
        weightID = findViewById(R.id.weightID);
        hieghtID = findViewById(R.id.hieghtID);
        switchID = findViewById(R.id.switchID);
        btnCalcID = findViewById(R.id.btnCalcID);
    }

    private double calcBMI (double weight, double hieght, boolean isMale) {

            double res =  weight / (hieght * hieght);
        if (isMale) // true for male false for female
            res = res * (double) (5/100);
        return res;
    }
}