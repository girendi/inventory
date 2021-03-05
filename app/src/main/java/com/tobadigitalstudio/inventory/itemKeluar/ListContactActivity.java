package com.tobadigitalstudio.inventory.itemKeluar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityListContactBinding;

public class ListContactActivity extends AppCompatActivity {

    private ActivityListContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_contact);

        binding.toolbar.title.setText(getString(R.string.contact));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}