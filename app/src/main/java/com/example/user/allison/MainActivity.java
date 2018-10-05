package com.example.user.allison;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    RadioGroup rad;
    Spinner spinner;
    Button go;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rad = findViewById(R.id.radio_unit);
        spinner = findViewById(R.id.activity_main_location);
        go = findViewById(R.id.activity_main_go);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isCel = true;
                Intent intent = new Intent(MainActivity.this, SelectedCityActivity.class);
                switch (rad.getCheckedRadioButtonId()) {
                    case R.id.activity_main_celcius:
                        isCel = true;
                        break;

                    case R.id.activity_main_fahrenheit:
                        isCel = false;
                        break;
                }
                double lat = 40.712774, lon = -74.006091;

                intent.putExtra(SelectedCityActivity.IS_CEL, isCel);
                intent.putExtra(SelectedCityActivity.LAT, lat);
                intent.putExtra(SelectedCityActivity.LONG, lon);
                startActivity(intent);
            }
        });

        findViewById(R.id.prevButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
