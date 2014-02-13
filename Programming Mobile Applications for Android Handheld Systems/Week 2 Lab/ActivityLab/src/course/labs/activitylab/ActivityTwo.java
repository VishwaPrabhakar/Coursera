package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	int mCreate = 0;
	int mStart = 0;
	int mResume = 0;
	int mRestart = 0;

	// Create variables for each of the TextViews, called
	// mTvCreate, etc.
	TextView mTvCreate;
	TextView mTvStart;
	TextView mTvResume;
	TextView mTvRestart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// Assign the appropriate TextViews to the TextView variables
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);

		Button closeButton = (Button) findViewById(R.id.bClose);
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// This function closes Activity Two
				finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {
			// Restore value of counters from saved state
		    mRestart = savedInstanceState.getInt(RESTART_KEY);
		    mResume = savedInstanceState.getInt(RESUME_KEY);
		    mStart = savedInstanceState.getInt(START_KEY);
		    mCreate = savedInstanceState.getInt(CREATE_KEY);
		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// Update the appropriate count variable
		mCreate++;
		// Update the user interface via the displayCounts() method
		displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();
		Log.i(TAG, "Entered the onStart() method");

		// Update the appropriate count variable
		mStart++;
		// Update the user interface
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(TAG, "Entered the onResume() method");

		// Update the appropriate count variable
		mResume++;
		// Update the user interface
		displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();
		Log.i(TAG, "Entered the onRestart() method");

		// Update the appropriate count variable
		mRestart++;
		// Update the user interface
		displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save counter state information with a collection of key-value pairs
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	}
}