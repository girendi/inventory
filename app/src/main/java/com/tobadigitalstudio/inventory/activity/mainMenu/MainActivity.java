package com.tobadigitalstudio.inventory.activity.mainMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.activity.LoginActivity;
import com.tobadigitalstudio.inventory.adapter.SimpleRecyclerAdapter;
import com.tobadigitalstudio.inventory.databinding.ActivityMainBinding;
import com.tobadigitalstudio.inventory.databinding.ItemListMenuBinding;
import com.tobadigitalstudio.inventory.models.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.iconShutdown.setOnClickListener(view -> shutdown());
        getCurrentDate();
        showListMenu();
    }

    private void showListMenu() {
        ArrayList<MenuItem> menuList = new MainMenu().getListMenu(getApplicationContext());
        binding.rvMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SimpleRecyclerAdapter<MenuItem> adapter = new SimpleRecyclerAdapter<>(menuList, R.layout.item_list_menu, (holder, item) -> {
            ItemListMenuBinding mBinding = (ItemListMenuBinding) holder.getLayoutBinding();
            if (item.getMenuLogo() != null) {
                mBinding.ivIcon.setImageResource(item.getMenuLogo());
            }
            mBinding.tvName.setText(item.getMenuName());
            mBinding.tvDesc.setText(item.getMenuDescription());
            mBinding.entryItem.setOnClickListener(v -> {
                if (item.getRunnable() != null) {
                    item.getRunnable().run();
                }
            });
        });
        binding.rvMenu.setAdapter(adapter);
        adapter.setMainData(menuList);
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