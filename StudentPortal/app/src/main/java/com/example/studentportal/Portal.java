package com.example.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

class Portal implements Parcelable {
	private String mPortalTitle;
	private String mPortalURL;
	
	protected Portal(Parcel in) {
		mPortalTitle = in.readString();
		mPortalURL = in.readString();
	}
	
	public Portal(String mPortalTitle, String mPortalURL) {
		this.mPortalTitle = mPortalTitle;
		this.mPortalURL = mPortalURL;
	}
	
	public static final Creator<Portal> CREATOR = new Creator<Portal>() {
		@Override
		public Portal createFromParcel(Parcel in) {
			return new Portal(in);
		}
		
		@Override
		public Portal[] newArray(int size) {
			return new Portal[size];
		}
	};
	
	public String getmPortalTitle() {
		return mPortalTitle;
	}
	
	public void setmPortalTitle(String mPortalTitle) {
		this.mPortalTitle = mPortalTitle;
	}
	
	public String getmPortalURL() {
		return mPortalURL;
	}
	
	public void setmPortalURL(String mPortalURL) {
		this.mPortalURL = mPortalURL;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel parcel, int i) {
		
		parcel.writeString(mPortalTitle);
		parcel.writeString(mPortalURL);
	}
}
