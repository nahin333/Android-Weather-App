package com.example.user.allison;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.CellIdentityCdma;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class SelectedCityActivity extends Activity {

    public static final String IS_CEL = "isCel";
    public static final String LAT = "LAT";
    public static final String LONG = "LON";
    public static final String APPID = "3ef1fd96d47c69d9fc5e567d29923115";

    private TextView dateText, timeText, tempText, humText, cityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_city);

        initViews();

        Double lat = getIntent().getDoubleExtra(LAT, 40.712774);
        Double lon = getIntent().getDoubleExtra(LAT, -0.712774);

        String url =
            "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + APPID;
        WeatherParser weatherParser = new WeatherParser(tempText, humText, cityText, dateText, timeText,
                openOrCreateDatabase("weather", Context.MODE_PRIVATE, null));
        weatherParser.execute(url);

    }

    private void initViews() {
        dateText = findViewById(R.id.selected_city_date);
        timeText = findViewById(R.id.selected_city_time);
        tempText = findViewById(R.id.selected_city_temperature);
        humText = findViewById(R.id.selected_city_probability);
        cityText = findViewById(R.id.selected_city_city);
    }
}
