package com.elksa.sample.testtextinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup error fields
        final TextInputLayout layoutError = findViewById(R.id.layout_phone_error);
        final TextInputEditText txtPhoneError = findViewById(R.id.txt_phone_error);
        txtPhoneError.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && txtPhoneError.getText().toString().length() < 8) {
                    layoutError.setError(getString(R.string.error_phone));
                }
            }
        });

        // Setup hint color
        final TextInputLayout layoutDisabledHint = findViewById(R.id.layout_text_disabled_hint);
        //layoutDisabledHint.setDefaultHintTextColor(getResources().getColorStateList(R.color.selector_edithintcolor));

        final TextInputLayout layoutDisabledText = findViewById(R.id.layout_text_disabled);
        findViewById(R.id.btn_change_status).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDisabledHint.setEnabled(!layoutDisabledHint.isEnabled());
                layoutDisabledText.setEnabled(!layoutDisabledText.isEnabled());
            }
        });
    }
}
