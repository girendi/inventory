package com.tobadigitalstudio.inventory.itemKeluar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityItemKeluarBinding;

public class ItemKeluarActivity extends AppCompatActivity {

    private ActivityItemKeluarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_keluar);

        binding.toolbar.title.setText(getString(R.string.item_out));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}