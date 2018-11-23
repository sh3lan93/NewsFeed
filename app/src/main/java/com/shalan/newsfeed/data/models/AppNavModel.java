package com.shalan.newsfeed.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class AppNavModel implements Parcelable {
    private int id;
    private boolean isSelected;
    private int icon;
    private String navTitle;

    public AppNavModel() {
    }

    public AppNavModel(int id, int icon, String navTitle) {
        this.id = id;
        this.isSelected = false;
        this.icon = icon;
        this.navTitle = navTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getNavTitle() {
        return navTitle;
    }

    public void setNavTitle(String navTitle) {
        this.navTitle = navTitle;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        dest.writeInt(this.icon);
        dest.writeString(this.navTitle);
    }

    protected AppNavModel(Parcel in) {
        this.id = in.readInt();
        this.isSelected = in.readByte() != 0;
        this.icon = in.readInt();
        this.navTitle = in.readString();
    }

    public static final Parcelable.Creator<AppNavModel> CREATOR = new Parcelable.Creator<AppNavModel>() {
        @Override
        public AppNavModel createFromParcel(Parcel source) {
            return new AppNavModel(source);
        }

        @Override
        public AppNavModel[] newArray(int size) {
            return new AppNavModel[size];
        }
    };
}
