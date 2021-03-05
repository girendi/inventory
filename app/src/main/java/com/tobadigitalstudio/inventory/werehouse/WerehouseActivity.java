package com.tobadigitalstudio.inventory.werehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityWerehouseBinding;

public class WerehouseActivity extends AppCompatActivity {

    private ActivityWerehouseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_werehouse);

        binding.toolbar.title.setText(getString(R.string.warehouse));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}