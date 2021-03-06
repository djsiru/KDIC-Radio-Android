package edu.grinnell.kdic.schedule;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * The object in which data for individual shows is stored.
 * The start and end times as stored as ints representing hours
 * on a 24hr clock. 
 * The day is stored as an int in accordance with the android Calendar class
 */
public class Show implements Parcelable {

	protected String title;
	protected int day;
	protected int starttime;
	protected int endtime;

	public Show(String title, int starttime, int endtime, int day) {
		this.title = title;
		this.starttime = starttime;
		this.endtime = endtime;
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public int getStartTime() {
		if (starttime < 5)
			return starttime + 24;
		return starttime;
	}

	public int getEndTime() {
		if (endtime < 5)
			return endtime + 24;
		return endtime;
	}

	public int getDay() {
		return day;
	}

	@Override
	public int describeContents() {
		return (day + starttime) * title.charAt(0);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(title);
		dest.writeInt(starttime);
		dest.writeInt(endtime);
		dest.writeInt(day);
	}
}
