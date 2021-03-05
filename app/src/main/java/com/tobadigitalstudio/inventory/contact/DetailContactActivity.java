package com.tobadigitalstudio.inventory.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityDetailContactBinding;

public class DetailContactActivity extends AppCompatActivity {

    private ActivityDetailContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_contact);

        binding.toolbar.title.setText(getString(R.string.add_contact));
        binding.toolbar.back.setOnClickListener(view -> finish());
    }
}