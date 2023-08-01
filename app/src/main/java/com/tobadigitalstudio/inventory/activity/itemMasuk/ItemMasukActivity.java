package com.tobadigitalstudio.inventory.activity.itemMasuk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityItemMasukBinding;


public class ItemMasukActivity extends AppCompatActivity {

    private ActivityItemMasukBinding binding;
    private static final int CAMERA_REQUEST_CODE = 7777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_masuk);

        binding.toolbar.title.setText(getString(R.string.entry_item));
        binding.toolbar.back.setOnClickListener(view -> finish());

        binding.addImage.setOnClickListener(view -> addImage());
        binding.deleteImage.setOnClickListener(v -> deleteImage());
    }

    private void addImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    private void deleteImage(){
        binding.image.setImageBitmap(null);
        binding.image.setVisibility(View.GONE);
        binding.deleteImage.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST_CODE) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                binding.image.setImageBitmap(bitmap);
                binding.image.setVisibility(View.VISIBLE);
                binding.deleteImage.setVisibility(View.VISIBLE);
            }
        }
    }
}