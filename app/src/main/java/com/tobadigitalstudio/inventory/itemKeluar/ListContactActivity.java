package com.tobadigitalstudio.inventory.itemKeluar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.contact.ContactListAdapter;
import com.tobadigitalstudio.inventory.databases.AppDatabase;
import com.tobadigitalstudio.inventory.databases.dao.ContactDao;
import com.tobadigitalstudio.inventory.databinding.ActivityListContactBinding;
import com.tobadigitalstudio.inventory.models.Contact;

import java.util.ArrayList;

public class ListContactActivity extends AppCompatActivity {

    private ActivityListContactBinding binding;

    private ContactDao database;
    private ArrayList<Contact> listContact;
    private ContactListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_contact);

        binding.toolbar.title.setText(getString(R.string.contact));
        binding.toolbar.back.setOnClickListener(view -> finish());
        binding.toolbar.confirm.setVisibility(View.GONE);

        listContact = new ArrayList<>();
        database = AppDatabase.getInstance(this).contactDao();

        binding.rvContact.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ContactListAdapter(new ArrayList<>());
        binding.rvContact.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListContact();
    }

    private void getListContact(){
        listContact.clear();
        listContact.addAll(database.readDataContact());
        if (adapter == null){
            adapter = new ContactListAdapter(listContact);
        }else {
            adapter.setContacts(listContact);
        }
        adapter.notifyDataSetChanged();
    }
}