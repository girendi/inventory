package com.tobadigitalstudio.inventory.werehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityDetailWereHouseBinding;

public class DetailWereHouseActivity extends AppCompatActivity {

    private ActivityDetailWereHouseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_were_house);

        binding.toolbar.title.setText(getString(R.string.add_item));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}