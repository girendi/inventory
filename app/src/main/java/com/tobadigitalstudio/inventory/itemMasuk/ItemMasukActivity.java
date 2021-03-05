package com.tobadigitalstudio.inventory.itemMasuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityItemMasukBinding;

public class ItemMasukActivity extends AppCompatActivity {

    private ActivityItemMasukBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_masuk);

        binding.toolbar.title.setText(getString(R.string.entry_item));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}