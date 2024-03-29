package com.tobadigitalstudio.inventory.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.helpers.PermissionHelper;

public class SplashActivity extends AppCompatActivity {

    PermissionHelper permissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        permissionHelper = new PermissionHelper(this);
        checkAndRequestPermissions();
    }

    private void checkAndRequestPermissions() {
        permissionHelper.permissionListener(() -> {
            new Handler().postDelayed(
                    () -> {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }, 3000
            );
        });

        permissionHelper.checkAndRequestPermissions();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionHelper.onRequestCallBack(requestCode, permissions, grantResults);
    }
}