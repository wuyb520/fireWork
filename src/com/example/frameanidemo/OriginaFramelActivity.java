package com.example.frameanidemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class OriginaFramelActivity extends Activity {

	private static final String TAG = "original";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_original);

		ImageView iv_original = (ImageView) findViewById(R.id.iv_orginal);
		AnimationDrawable ani = (AnimationDrawable) iv_original.getDrawable();
		ani.start();//播放动画
		
		//打印出程序占用的内存
		Log.e(TAG, Runtime.getRuntime().totalMemory()/1024 + "k");
	}
}
