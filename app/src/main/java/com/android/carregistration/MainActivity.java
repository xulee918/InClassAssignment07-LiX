package com.android.carregistration;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RequestCodes.ADD_CAR_INFO && resultCode == RESULT_OK) {
            TextView textView = findViewById(R.id.showcar_text_view);
            Car car = (Car) data.getSerializableExtra(Keys.CAR_INFO);

            String oldCars = textView.getText().toString();
            if (oldCars == null || oldCars.length() == 0) {
                oldCars = "";
            } else {
                oldCars = oldCars + "\n\n";
            }
            textView.setText(oldCars + car.toString());
        }
    }

    public void registerACar(View view) {
        Intent intent = new Intent(this, CarRegisterActivity.class);
        startActivityForResult(intent, RequestCodes.ADD_CAR_INFO);
    }
}
