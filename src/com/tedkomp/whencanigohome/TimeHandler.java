package com.tedkomp.whencanigohome;

public class TimeHandler {
	private int hourOfDay, minute;

	public TimeHandler(int hourOfDay, int minute) {
		if (hourOfDay >= 0 && hourOfDay <= 23 && minute >= 0 && minute <= 59) {
			this.hourOfDay = hourOfDay;
			this.minute = minute;
		}
	}

	public void addMinutes(int nbrOfMinutes) {

		while (nbrOfMinutes > 59) {
			nbrOfMinutes -= 60;
			addHours(1);
		}

		int currMin = minute + nbrOfMinutes;

		if (currMin > 59) {
			addHours(1);
			currMin -= 60;			
		} 
		minute = currMin;
	}

	public void addHours(int nbrOfHours) {
		hourOfDay += nbrOfHours;
		if (hourOfDay > 23) {
			hourOfDay -= 24;
		}
	}

	@Override
	public String toString() {
		return "" + hourOfDay + ":" + (minute < 10 ? "0" + minute : minute);
	}

}
