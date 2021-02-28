package com.daanidev.puppyadoptionlist.ui.main.model

import android.os.Parcel
import android.os.Parcelable

data class PuppyModel(val puppyID:Int, val name:String?, val bread:String?, val age:String?,
                      val gender:String?, val length:Float, val color:String?, val image:Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(puppyID)
        parcel.writeString(name)
        parcel.writeString(bread)
        parcel.writeString(age)
        parcel.writeString(gender)
        parcel.writeFloat(length)
        parcel.writeString(color)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PuppyModel> {
        override fun createFromParcel(parcel: Parcel): PuppyModel {
            return PuppyModel(parcel)
        }

        override fun newArray(size: Int): Array<PuppyModel?> {
            return arrayOfNulls(size)
        }
    }

}