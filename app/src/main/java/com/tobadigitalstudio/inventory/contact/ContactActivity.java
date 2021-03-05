package com.tobadigitalstudio.inventory.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact);

        binding.toolbar.title.setText(getString(R.string.contact));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}