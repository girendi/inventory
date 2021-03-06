package com.tobadigitalstudio.inventory.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tobadigitalstudio.inventory.databases.dao.ContactDao;
import com.tobadigitalstudio.inventory.databases.dao.ItemInDao;
import com.tobadigitalstudio.inventory.databases.dao.ItemOutDao;
import com.tobadigitalstudio.inventory.databases.dao.WarehouseDao;
import com.tobadigitalstudio.inventory.models.Contact;
import com.tobadigitalstudio.inventory.models.ItemIn;
import com.tobadigitalstudio.inventory.models.ItemOut;
import com.tobadigitalstudio.inventory.models.Warehouse;

@Database(entities = {
        Contact.class,
        ItemIn.class,
        ItemOut.class,
        Warehouse.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
    public abstract ItemInDao itemInDao();
    public abstract ItemOutDao itemOutDao();
    public abstract WarehouseDao warehouseDao();

    public static final String DATABASE_NAME = "dbInventory";

    public static AppDatabase instance;

    public static AppDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }

        return instance;
    }
}
