package com.tobadigitalstudio.inventory.models

import android.os.Parcel
import android.os.Parcelable

data class MenuItem (
    var caseId: Int? = null,
    var menuLogo: Int? = null,
    var menuName: String? = null,
    var menuDescription: String? = null,
    var runnable: Runnable? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        TODO("runnable")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(caseId)
        parcel.writeValue(menuLogo)
        parcel.writeString(menuName)
        parcel.writeString(menuDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MenuItem> {
        override fun createFromParcel(parcel: Parcel): MenuItem {
            return MenuItem(parcel)
        }

        override fun newArray(size: Int): Array<MenuItem?> {
            return arrayOfNulls(size)
        }
    }
}