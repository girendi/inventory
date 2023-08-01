package com.tobadigitalstudio.inventory.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.activity.mainMenu.MainActivity;
import com.tobadigitalstudio.inventory.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private final static String USERNAME = "user";
    private final static String PASSWORD = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.btnLogin.setOnClickListener(view ->checkUserLogin());
    }

    private boolean isEmpty(){
        return binding.username.getText().toString().equals("") && binding.password.getText().toString().equals("");
    }

    private void checkUserLogin(){
        if (isEmpty()){
            Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (binding.username.getText().toString().equals(USERNAME) && binding.password.getText().toString().equals(PASSWORD)) viewDashboard();
        else Toast.makeText(this, "Username dan Password anda salah!", Toast.LENGTH_SHORT).show();
    }

    private void viewDashboard(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}