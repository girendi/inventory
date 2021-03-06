package com.tobadigitalstudio.inventory.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databases.AppDatabase;
import com.tobadigitalstudio.inventory.databases.dao.ContactDao;
import com.tobadigitalstudio.inventory.databinding.ActivityContactBinding;
import com.tobadigitalstudio.inventory.models.Contact;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private final static String DETAIL = "detail";
    private final static String ADD = "add";
    private final static String STATUS = "status";

    private ContactDao database;
    private ArrayList<Contact> listContact;
    private ContactListAdapter adapter;

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact);

        binding.toolbar.title.setText(getString(R.string.contact));
        binding.toolbar.back.setOnClickListener(view -> finish());
        binding.toolbar.confirm.setOnClickListener(view -> detailContact(ADD));

        listContact = new ArrayList<>();
        database = AppDatabase.getInstance(this).contactDao();

        binding.rvWarehouse.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ContactListAdapter(this, listContact);
        binding.rvWarehouse.setAdapter(adapter);

        getListContact();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListContact();
    }

    private void getListContact(){
        listContact.addAll(database.readDataContact());
        adapter.notifyDataSetChanged();
    }

    private void detailContact(String status){
        Intent intent = new Intent(getApplicationContext(), DetailContactActivity.class);
        intent.putExtra(STATUS, status);
        startActivity(intent);
    }
}