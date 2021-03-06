package com.tobadigitalstudio.inventory.databases.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tobadigitalstudio.inventory.models.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContact(Contact contact);

    @Query("SELECT * FROM contact")
    List<Contact> readDataContact();
}
