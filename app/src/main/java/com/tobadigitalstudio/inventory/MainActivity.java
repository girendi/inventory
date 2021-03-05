package com.tobadigitalstudio.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.contact.ContactActivity;
import com.tobadigitalstudio.inventory.databinding.ActivityMainBinding;
import com.tobadigitalstudio.inventory.itemKeluar.ItemKeluarActivity;
import com.tobadigitalstudio.inventory.itemMasuk.ItemMasukActivity;
import com.tobadigitalstudio.inventory.report.ReportActivity;
import com.tobadigitalstudio.inventory.werehouse.WerehouseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getCurrentDate();
        binding.iconShutdown.setOnClickListener(view -> shutdown());
        binding.entryItem.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ItemMasukActivity.class)));
        binding.itemOut.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ItemKeluarActivity.class)));
        binding.warehouse.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), WerehouseActivity.class)));
        binding.report.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ReportActivity.class)));
        binding.contact.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ContactActivity.class)));
    }

    private void shutdown(){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    private void getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMM", Locale.getDefault());
        String currentDateAndTime = sdf.format(new Date());
        binding.tvTime.setText(currentDateAndTime);
    }
}