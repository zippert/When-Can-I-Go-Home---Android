package com.tedkomp.whencanigohome;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TimePicker;

public class MyTimePicker extends TimePicker {

	public MyTimePicker(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyTimePicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setCurrentHour(Integer currentHour) {
		// TODO Auto-generated method stub
		super.setCurrentHour(currentHour);
		requestLayout();
	}

	@Override
	public void setCurrentMinute(Integer currentMinute) {
		// TODO Auto-generated method stub
		super.setCurrentMinute(currentMinute);
		requestLayout();
	}

}
