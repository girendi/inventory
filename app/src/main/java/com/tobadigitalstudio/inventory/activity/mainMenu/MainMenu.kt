package com.tobadigitalstudio.inventory.activity.mainMenu

import android.content.Context
import android.content.Intent
import com.tobadigitalstudio.inventory.R
import com.tobadigitalstudio.inventory.activity.contact.ContactActivity
import com.tobadigitalstudio.inventory.activity.itemKeluar.ItemKeluarActivity
import com.tobadigitalstudio.inventory.activity.itemMasuk.ItemMasukActivity
import com.tobadigitalstudio.inventory.activity.report.ReportActivity
import com.tobadigitalstudio.inventory.activity.werehouse.WarehouseActivity
import com.tobadigitalstudio.inventory.models.MenuItem

class MainMenu {

    fun getListMenu(context: Context): ArrayList<MenuItem> {
        val listMenu: ArrayList<MenuItem> = arrayListOf()

        val menuIn = MenuItem()
        menuIn.caseId = 1
        menuIn.menuLogo = R.drawable.icon_item_masuk
        menuIn.menuName = context.getString(R.string.entry_item)
        menuIn.menuDescription = context.getString(R.string.entry_item_today)
        val menuInRunnable = Runnable {
            val intent = Intent(context, ItemMasukActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        menuIn.runnable = menuInRunnable
        listMenu.add(menuIn)

        val menuOut = MenuItem()
        menuOut.caseId = 2
        menuOut.menuLogo = R.drawable.icon_item_keluar
        menuOut.menuName = context.getString(R.string.item_out)
        menuOut.menuDescription = context.getString(R.string.item_out_today)
        val menuOutRunnable = Runnable {
            val intent = Intent(context, ItemKeluarActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        menuOut.runnable = menuOutRunnable
        listMenu.add(menuOut)

        val menuWarehouse = MenuItem()
        menuWarehouse.caseId = 3
        menuWarehouse.menuLogo = R.drawable.icon_gudang
        menuWarehouse.menuName = context.getString(R.string.warehouse)
        menuWarehouse.menuDescription = context.getString(R.string.all_items)
        val menuWarehouseRunnable = Runnable {
            val intent = Intent(context, WarehouseActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        menuWarehouse.runnable = menuWarehouseRunnable
        listMenu.add(menuWarehouse)

        val menuReport = MenuItem()
        menuReport.caseId = 4
        menuReport.menuLogo = R.drawable.icon_laporan
        menuReport.menuName = context.getString(R.string.report)
        menuReport.menuDescription = context.getString(R.string.view_report)
        val menuReportRunnable = Runnable {
            val intent = Intent(context, ReportActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        menuReport.runnable = menuReportRunnable
        listMenu.add(menuReport)

        val menuContact = MenuItem()
        menuContact.caseId = 5
        menuContact.menuLogo = R.drawable.icon_kontak
        menuContact.menuName = context.getString(R.string.contact)
        menuContact.menuDescription = context.getString(R.string.list_contact)
        val menuContactRunnable = Runnable {
            val intent = Intent(context, ContactActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
        menuContact.runnable = menuContactRunnable
        listMenu.add(menuContact)

        return listMenu;
    }

}