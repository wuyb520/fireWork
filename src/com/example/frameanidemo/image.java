package com.example.frameanidemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class OriginaFramelActivity extends Activity {

	private static final String TAG = "original";


	
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${relativePackage}.${activityClass}" >
    <ImageView
        android:id="@+id/image01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:scaleType="fitXY"
        android:src="@drawable/aabb" />
</RelativeLayout>
————————————————
版权声明：本文为CSDN博主「zhangtian6691844」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zhangtian6691844/article/details/51743571
public class MainActivity extends Activity {
	private ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image = (ImageView)findViewById(R.id.image01);        
        //设置图片的位置
		MarginLayoutParams margin9 = new MarginLayoutParams(
				image.getLayoutParams());
		margin9.setMargins(400, 10, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
		RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(margin9);
		layoutParams9.height = 600;//设置图片的高度
		layoutParams9.width = 800; //设置图片的宽度
		image.setLayoutParams(layoutParams9);
	}
}


ImageView hero = (ImageView)findById(R.id.hero);
int[] location = new int[2];
hero.getLocationInWindow(location);//获取Imageview在屏幕中的位置
Animation heroTranslate = new TranslateAnimation(location[0]-150f,location[0],0f,0f);//移动动画
hero.setAnimation(heroTranslate);
heroTranslate.setDuration(1000);
hero.setImageDrawable(getResources().getDrawable(R.mipmap.hero_bg));
heroTranslate.start();
————————————————
版权声明：本文为CSDN博主「wf_kingofring」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/wf_kingofring/article/details/50145163


https://blog.csdn.net/u010273007/article/details/70215677?utm_source=app&app_version=4.16.0&code=app_1562916241&uLinkId=usr1mkqgl919blen

https://blog.csdn.net/u010273007/article/details/70215677?utm_source=app&app_version=4.16.0&code=app_1562916241&uLinkId=usr1mkqgl919blen


public class MainActivity extends Activity {  
    /*声明ImageView变量*/  
      private ImageView mImageView01;  
      /*声明相关变量作为存储图片宽高,位置使用*/  
      private int intWidth, intHeight, intDefaultX, intDefaultY;  
      private float mX, mY;   
      /*声明存储屏幕的分辨率变量 */  
      private int intScreenX, intScreenY;  
  
      public void onCreate(Bundle savedInstanceState)  
      {  
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.main);  
          
        drawBackground();  
          
        /* 取得屏幕对象 */  
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm);  
          
        /* 取得屏幕解析像素 */  
        intScreenX = dm.widthPixels;  
        intScreenY = dm.heightPixels;  
          
        /* 设置图片的宽高 */  
        intWidth = 100;  
        intHeight = 100;  
        /*通过findViewById构造器创建ImageView对象*/   
        mImageView01 =(ImageView) findViewById(R.id.myImageView1);  
        /*将图片从Drawable赋值给ImageView来呈现*/  
        mImageView01.setImageResource(R.drawable.body);  
          
        /* 初始化按钮位置居中 */  
        RestoreButton();  
          
        /* 当点击ImageView，还原初始位置 */  
        mImageView01.setOnClickListener(new Button.OnClickListener()  
        {  
          public void onClick(View v)  
          {  
            RestoreButton();  
          }  
        });  
      }  
        
      //加载背景颜色  
      public void drawBackground()      
               {      
                   GradientDrawable grad = new GradientDrawable(       
                              Orientation.TL_BR,      
                              new int[] {    
                                             Color.rgb(0, 0, 127),      
                                             Color.rgb(0, 0, 255),      
                                             Color.rgb(127, 0, 255),      
                                             Color.rgb(127, 127, 255),      
                                             Color.rgb(127, 255, 255),      
                                             Color.rgb(255, 255, 255)    
                                         }       
                   );       
                   this.getWindow().setBackgroundDrawable(grad);      
               }      
  
        
      /*覆盖触控事件*/  
      public boolean onTouchEvent(MotionEvent event)   
      {  
        /*取得手指触控屏幕的位置*/  
        float x = event.getX();  
        float y = event.getY();  
          
        try  
        {  
          /*触控事件的处理*/  
          switch (event.getAction())   
          {  
            /*点击屏幕*/  
            case MotionEvent.ACTION_DOWN:  
              picMove(x, y);  
                break;  
            /*移动位置*/  
            case MotionEvent.ACTION_MOVE:  
              picMove(x, y);  
                break;  
            /*离开屏幕*/  
            case MotionEvent.ACTION_UP:  
              picMove(x, y);    
                break;  
          }  
        }catch(Exception e)  
          {  
            e.printStackTrace();  
          }  
        return true;  
      }  
      /*移动图片的方法*/  
      private void picMove(float x, float y)  
      {  
        /*默认微调图片与指针的相对位置*/  
        mX=x-(intWidth/2);  
        mY=y-(intHeight/2);  
          
        /*防图片超过屏幕的相关处理*/  
        /*防止屏幕向右超过屏幕*/  
        if((mX+intWidth)>intScreenX)  
        {  
          mX = intScreenX-intWidth;  
        }  
        /*防止屏幕向左超过屏幕*/  
        else if(mX<0)  
        {  
          mX = 0;  
        }  
        /*防止屏幕向下超过屏幕*/  
        else if ((mY+intHeight)>intScreenY)  
        {  
          mY=intScreenY-intHeight;  
        }  
        /*防止屏幕向上超过屏幕*/  
        else if (mY<0)  
        {  
          mY = 0;  
        }  
        /*通过log 来查看图片位置*/  
        Log.i("jay", Float.toString(mX)+","+Float.toString(mY));  
        /* 以setLayoutParams方法，重新安排Layout上的位置 */  
        mImageView01.setLayoutParams  
        (  
          new AbsoluteLayout.LayoutParams  
          (intWidth,intHeight,(int) mX,(int)mY)  
        );  
      }  
        
      /* 还原ImageView位置的事件处理 */  
      public void RestoreButton()  
      {  
        intDefaultX = ((intScreenX-intWidth)/2);  
        intDefaultY = ((intScreenY-intHeight)/2);  
        /*Toast还原位置坐标*/  
        mMakeTextToast  
        (  
          "("+  
          Integer.toString(intDefaultX)+  
          ","+  
          Integer.toString(intDefaultY)+")",true  
        );  
          
        /* 以setLayoutParams方法，重新安排Layout上的位置 */  
        mImageView01.setLayoutParams  
        (  
          new AbsoluteLayout.LayoutParams  
          (intWidth,intHeight,intDefaultX,intDefaultY)  
        );  
      }  
        
      /*自定义一发出信息的方法*/  
      public void mMakeTextToast(String str, boolean isLong)  
      {  
        if(isLong==true)  
        {  
          Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();  
        }  
        else  
        {  
          Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();  
        }  
      }  
}  


<?xml version="1.0" encoding="utf-8"?>
<AbsoluteLayout
  android:id="@+id/widget27"
  android:layout_width="fill_parent"
  android:layout_height="fill_parent"
  xmlns:android="http://schemas.android.com/apk/res/android"
  >
  <TextView
    android:id="@+id/myTextView"    
    android:layout_width="fill_parent" 
    android:layout_height="wrap_content" 
    android:layout_x="80dip"
    android:text="@string/hello"
    />
  <ImageView
    android:id="@+id/myImageView1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    >
  </ImageView>
</AbsoluteLayout>
————————————————
版权声明：本文为CSDN博主「大明ZeroSon」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/wdaming1986/article/details/6788097

<Button
    android:id="@+id/btnRight"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginLeft="22dp"
    android:layout_toRightOf="@+id/btnLeft"
    android:text="Right"/>
<Button
    android:id="@+id/btnLeft"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Left"/>
<ImageView
    android:id="@+id/image1"
    android:layout_width="135dp"
    android:layout_height="135dp"
    android:layout_alignParentLeft="true"
    android:layout_margin="89dp"
    android:src="@drawable/image1"/>



    button1.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick(View view) {
            RelativeLayout.LayoutParams par
                    = (RelativeLayout.LayoutParams) image1.getLayoutParams();
            if(par.leftMargin - 5 > 0){
                par.leftMargin -= 5;
            }
            image1.setLayoutParams(par);
        }
    });
https://blog.csdn.net/xzizbb/article/details/72824898?utm_source=app&app_version=4.16.0&code=app_1562916241&uLinkId=usr1mkqgl919blen

    button2.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int screen_width = size.x;
            int screen_height = size.y;
            RelativeLayout.LayoutParams par =
                    (RelativeLayout.LayoutParams)image1.getLayoutParams();
            if(par.leftMargin + 5 < screen_width - par.width){
               par.leftMargin += 5;
            }
            image1.setLayoutParams(par);
        }
    });

 image1.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)image1.getLayoutParams();
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    int x_cord = (int)event.getRawX();
                    int y_cord = (int)event.getRawY();
                    par.leftMargin = x_cord - par.width / 2;
                    par.topMargin = y_cord - par.height / 2 ;
                    image1.setLayoutParams(par);
                    break;
                default:
                    break;
            }
            return true;
        }

    });
移动控件的三种方式

 RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mGirl.getLayoutParams();
                layoutParams.leftMargin = mGirl.getLeft()+100;
                layoutParams.topMargin = mGirl.getTop()+100;
                mGirl.setLayoutParams(layoutParams);
				
				动画效果实现
				
				TranslateAnimation animation = new TranslateAnimation(0,100,0,100);
                animation.setDuration(300);
                animation.setFillAfter(true);
                mGirl.startAnimation(animation);
				
				
				
				
				                final int left = mGirl.getLeft();
                final int top = mGirl.getTop();
                final ValueAnimator animator = ValueAnimator.ofInt(1,100);
                animator.setDuration(400);
                animator.setInterpolator(new LinearInterpolator());
                animator.addUpdateListener(animation1 -> {
                    int current = (int) animator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mGirl.getLayoutParams();
                    layoutParams.leftMargin = left+current;
                    layoutParams.topMargin = top+current;
                    mGirl.setLayoutParams(layoutParams);
                });
                animator.start();

https://blog.csdn.net/qq_36188774/article/details/82715027

.Scroll实现
mGirl.scrollBy(-100,-100);

public void scrollBy(int x, int y) {
        scrollTo(mScrollX + x, mScrollY + y);
    }
 
public void scrollTo(int x, int y) {
        if (mScrollX != x || mScrollY != y) {
            int oldX = mScrollX;
            int oldY = mScrollY;
            mScrollX = x;
            mScrollY = y;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            if (!awakenScrollBars()) {
                postInvalidateOnAnimation();
            }
        }
    }
}
