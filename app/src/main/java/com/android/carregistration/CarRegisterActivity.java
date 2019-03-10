package com.android.carregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class CarRegisterActivity extends AppCompatActivity {

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_register);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_electric_yes:
                if (checked) type = getResources().getString(R.string.electric);
                break;
            case R.id.radio_electric_hybrid:
                if (checked) type = getResources().getString(R.string.hybrid);
                break;
            case R.id.radio_electric_no:
                if (checked) type = getResources().getString(R.string.nonelectric);
                break;
        }
    }

    public void onSubmitClicked(View view) {
        String brand = ((EditText) findViewById(R.id.brand_edit_text)).getText().toString();
        boolean suv = ((CheckBox) findViewById(R.id.convertible_checkbox)).isChecked();

        if (brand != null && type != null) {
            Car car = new Car(brand, suv, type);
            Intent data = new Intent();
            data.putExtra(Keys.CAR_INFO, car);
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
