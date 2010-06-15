package com.tedkomp.whencanigohome;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TextView.SavedState;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainApp extends Activity implements OnClickListener,
		OnTimeChangedListener, OnKeyListener {

	private TextView resultField, finalText;
	private TimePicker picker;
	private EditText lunchField;
	private Button calculateButton;

	// private int hourOfDay, minute, lunch;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		resultField = (TextView) findViewById(R.id.goHomeResult);
		picker = (TimePicker) findViewById(R.id.TimePicker01);
		lunchField = (EditText) findViewById(R.id.lunchTimeField);
		calculateButton = (Button) findViewById(R.id.calculateButton);
		finalText = (TextView) findViewById(R.id.finalText);
		if (savedInstanceState != null) {
			restoreState(savedInstanceState);
			
		} else {
			picker.setCurrentHour(8);
			picker.setCurrentMinute(0);
			lunchField.setText("30");
		}
		picker.setIs24HourView(true);
		calculateButton.setOnClickListener(this);
		picker.setOnTimeChangedListener(this);
		lunchField.setOnKeyListener(this);
	}

	private void updateResult() {

		TimeHandler temp = new TimeHandler(picker.getCurrentHour(), picker.getCurrentMinute());
		temp.addHours(8);
		temp.addMinutes(Integer.parseInt(lunchField.getText().toString()));
		resultField.setText(temp.toString());
		finalText.setText(R.string.goHome);
	}

	@Override
	public void onClick(View v) {		
		int lunch = Integer.parseInt(lunchField.getText().toString());
		if(lunch < 30){
			Toast.makeText(this, R.string.notValidLunch, Toast.LENGTH_SHORT)
					.show();

			lunchField.setText("30");
		}
		updateResult();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("currentHour", picker.getCurrentHour());
		outState.putInt("currentMinute", picker.getCurrentMinute());
		outState.putInt("lunch", Integer.parseInt(lunchField.getText().toString()));
	}

	private void restoreState(Bundle state) {
		int theHour = state.getInt("currentHour");
		int theMinute = state.getInt("currentMinute");
		picker.setCurrentHour(theHour);
		picker.setCurrentMinute(theMinute);
		
		lunchField.setText("" + state.getInt("lunch"));
	}

	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		resetFinalText();
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		resetFinalText();
		return false;
	}

	private void resetFinalText() {
		finalText.setText(R.string.implorePressCalculate);
		resultField.setText("");
	}
}