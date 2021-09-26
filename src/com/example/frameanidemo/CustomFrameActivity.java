package com.example.frameanidemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.frameanidemo.view.FrameAnimation;

public class CustomFrameActivity extends Activity {

	protected static final String TAG = "Custom";

	private FrameAnimation frameView;

	int[] srcId =
	{ R.drawable.penguin_happy_3_1, R.drawable.penguin_happy_3_2, R.drawable.penguin_happy_3_3,
			R.drawable.penguin_happy_3_4, R.drawable.penguin_happy_3_5, R.drawable.penguin_happy_3_6,
			R.drawable.penguin_happy_3_7, R.drawable.penguin_happy_3_8, R.drawable.penguin_happy_3_9,
			R.drawable.penguin_happy_3_10, R.drawable.penguin_happy_3_11, R.drawable.penguin_happy_3_12,
			R.drawable.penguin_happy_3_13 };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		frameView = (FrameAnimation) findViewById(R.id.ani_view);
		frameView.setBitmapResoursID(srcId);

		frameView.setOnFrameFinisedListener(new FrameAnimation.OnFrameFinishedListener() {

			@Override
			public void onStop()
			{
				Log.e(TAG, "stop");
			}

			@Override
			public void onStart()
			{
				Log.e(TAG, "start");

				Log.e(TAG, Runtime.getRuntime().totalMemory() / 1024 + "k");
			}
		});
		
		frameView.start();
	}
}
