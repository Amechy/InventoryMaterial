package com.example.inventoryMaterial.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 30/10/17.
 */

public class Sector implements Parcelable {

    private int _ID;
    private String name;
    private String shortname;
    private String description;
    private int _dependencyID;
    private boolean enabled;
    private boolean defult;


    protected Sector(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
        _dependencyID = in.readInt();
        enabled = in.readByte() != 0;
        defult = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int get_dependencyID() {
        return _dependencyID;
    }

    public void set_dependencyID(int _dependencyID) {
        this._dependencyID = _dependencyID;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDefult() {
        return defult;
    }

    public void setDefult(boolean defult) {
        this.defult = defult;
    }


    public Sector(int _ID, String name, String shortname, String description, int _dependencyID, boolean enabled, boolean defult) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this._dependencyID = _dependencyID;
        this.enabled = enabled;
        this.defult = defult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(shortname);
        dest.writeString(description);
        dest.writeInt(_dependencyID);
        dest.writeByte((byte) (enabled ? 1 : 0));
        dest.writeByte((byte) (defult ? 1 : 0));
    }
}
