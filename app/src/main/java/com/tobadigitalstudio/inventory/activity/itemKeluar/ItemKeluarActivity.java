package com.tobadigitalstudio.inventory.activity.itemKeluar;

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
import com.tobadigitalstudio.inventory.camera.CameraBarcodeActivity;
import com.tobadigitalstudio.inventory.databinding.ActivityItemKeluarBinding;

public class ItemKeluarActivity extends AppCompatActivity {

    private ActivityItemKeluarBinding binding;
    private static final int CAMERA_REQUEST_CODE = 7777;
    private static final int CUSTOMER_REQUEST_CODE = 62;
    private static final int BARCODE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_keluar);

        binding.toolbar.title.setText(getString(R.string.item_out));
        binding.toolbar.back.setOnClickListener(view -> finish());

        binding.addImage.setOnClickListener(view -> addImage());
        binding.deleteImage.setOnClickListener(v -> deleteImage());
        binding.addCustomer.setOnClickListener(v -> addCustomer());
        binding.addBarcode.setOnClickListener(v -> addBarcode());
    }

    private void addBarcode() {
        Intent intent = new Intent(getApplicationContext(), CameraBarcodeActivity.class);
        startActivityForResult(intent, BARCODE);
    }

    private void addCustomer() {
        Intent intent = new Intent(getApplicationContext(), ListContactActivity.class);
        startActivityForResult(intent, CUSTOMER_REQUEST_CODE);
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