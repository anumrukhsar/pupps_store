package com.example.androiddevchallenge.model

import android.os.Parcel
import android.os.Parcelable

data class Puppy(var name: String?, var gender: String?, val desc:String?, var puppyImage:Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }


    companion object CREATOR : Parcelable.Creator<Puppy> {
        override fun createFromParcel(parcel: Parcel): Puppy {
            return Puppy(parcel)
        }

        override fun newArray(size: Int): Array<Puppy?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(gender)
        parcel.writeString(desc)
        parcel.writeInt(puppyImage)
    }

    override fun describeContents(): Int {
        return 0
    }
}