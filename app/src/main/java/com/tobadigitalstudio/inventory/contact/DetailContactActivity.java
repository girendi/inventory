package com.tobadigitalstudio.inventory.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databases.AppDatabase;
import com.tobadigitalstudio.inventory.databases.dao.ContactDao;
import com.tobadigitalstudio.inventory.databinding.ActivityDetailContactBinding;
import com.tobadigitalstudio.inventory.models.Contact;

public class DetailContactActivity extends AppCompatActivity {

    private ActivityDetailContactBinding binding;
    private ContactDao database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_contact);

        database = AppDatabase.getInstance(this).contactDao();

        binding.toolbar.title.setText(getString(R.string.add_contact));
        binding.toolbar.back.setOnClickListener(view -> finish());
        binding.toolbar.confirm.setOnClickListener(view -> addContact());
    }

    public void addContact(){
        String name = binding.contactName.getText().toString();
        String phone = binding.phone.getText().toString();
        String address = binding.address.getText().toString();
        database.insertContact(new Contact(phone, name, address));
        finish();
    }
}