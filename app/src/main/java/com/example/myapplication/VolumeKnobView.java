package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class VolumeKnobView extends View {
	//private final int knobRadiusMin = 30, knobRadiusMax = 2, indicatorRadiusMin = 128, indicatorRadiusMax = 8;
	int indicatorColor, knobColor;
	Paint paint, indicatorCircle;
	float x, y, knobRadius, indicatorX, indicatorY, indicatorRadius, touchX, rotation;
	float knobRadiusModifier = 4, indicatorRadiusModifier = 16;
	
	
	int[] nums = {283000,
			306300,
			455900,
			588200,
			227400,
			633100,
			1044300,
			456000,
			795100,
			967300,
			300500,
			212700,
			171100,
			509200,
			202500,
			315600,
			9375400,
			203100,
			164600,
			268100,
			207200,
			200500,
			476300,
			275400,
			199800,
			209800,
			205000,
			160900,
			219800,
			191000,
			807400,
			1028900,
			403600,
			277000,
			256900,
			446600,
			163600,
			2382100,
			164100,
			173900,
			16428500,
			295200,
			894800,
			162100,
			520700,
			169600,
			179900,
			9087900,
			371600,
			180400,
			300300,
			920100,
			701400,
			5355800,
			16547100,
			162800,
			172100,
			391200,
			479000,
			178500,
			806700,
			349600,
			165000,
			194400,
			197200,
			181500,
			232100,
			152700,
			159300,
			159800,
			328800,
			624100,
			188700,
			1173400,
			228000,
			167400,
			201300,
			172500,
			184400,
			466400,
			300600,
			271300,
			320600,
			242000,
			183000,
			585100,
			935700,
			385100,
			191800,
			13373000,
			261600,
			184500,
			255300,
			866500,
			818100,
			195300,
			380700,
			419900,
			268600,
			212200,
			207100,
			167700,
			425600,
			200300,
			233500,
			443500,
			165100,
			192000,
			268900,
			1489600,
			142000,
			264000,
			178800,
			191500,
			23651100,
			172200,
			204700,
			197000,
			165300,
			1197800,
			210200,
			329300,
			5628000,
			564900,
			357500,
			294300,
			182000,
			253200,
			249500,
			188600,
			1023400,
			1051200,
			324100,
			259900,
			10990000,
			206900,
			1329600,
			261800,
			163700,
			181400,
			199300,
			155000,
			104800,
			172400,
			202900,
			204000,
			181800,
			254600,
			234900,
			213300,
			204000};
	
	
	public VolumeKnobView(Context context) {
		super(context);
		init(null);
	}
	
	public VolumeKnobView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}
	
	public VolumeKnobView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(attrs);
	}
	
	public VolumeKnobView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(attrs);
	}
	
	@Override
	public boolean onTouchEvent(final MotionEvent event) {
		long StartTime = System.nanoTime();
		new Thread(new Runnable() {
			@Override
			public void run() {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						touchX = event.getX();
						break;
					case MotionEvent.ACTION_MOVE:
						float diffX = event.getX() - touchX;
						rotation += diffX / 3;
						touchX = event.getX();
						invalidate();
						break;
					case MotionEvent.ACTION_UP:
						//Toast.makeText(getContext(), String.valueOf(getRotation()), Toast.LENGTH_SHORT).show();
						break;
				}
			}
		}).start();
		
		
		Log.i("Touch Time - ", String.valueOf(System.nanoTime() - StartTime));
		return true;
	}
	
	private void init(AttributeSet attrs) {
		paint = new Paint();
		indicatorCircle = new Paint();
		
		if (attrs != null) {
			
			TypedArray typedArray = getContext().obtainStyledAttributes(
					attrs, R.styleable.VolumeKnobView);
/*
            knobRadiusModifier = typedArray.getFloat(
                    R.styleable.VolumeKnobView_knob_size_percent,
                    80);

            indicatorRadiusModifier = typedArray.getFloat(
                    R.styleable.VolumeKnobView_indicator_size_percent,
                    80);
*/
			
			knobColor = typedArray.getColor(
					R.styleable.VolumeKnobView_knob_color,
					Color.BLACK);
			
			indicatorColor = typedArray.getColor(
					R.styleable.VolumeKnobView_indicator_color,
					Color.RED);
			typedArray.recycle();
			
		} else {
			knobColor = Color.BLACK;
			indicatorColor = Color.RED;
		}
		
		// changeRadii();
		
		
		y = 0;
		x = 0;
		paint.setStyle(Paint.Style.FILL);
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		indicatorCircle.setFlags(Paint.ANTI_ALIAS_FLAG);
		indicatorCircle.setStyle(Paint.Style.FILL);
	}
	
	public void setIndicatorColor(int indicatorColor) {
		this.indicatorColor = indicatorColor;
	}
	
	public void setKnobColor(int knobColor) {
		this.knobColor = knobColor;
	}
	
	public int getIndicatorColor() {
		return indicatorColor;
	}
	
	public int getKnobColor() {
		return knobColor;
	}
	
	@Override
	public float getRotation() {
		return (float) Math.abs(rotation % 360 / 3.6);
	}

/*    private void changeRadii() {
        if (indicatorRadiusModifier > 100) {
            indicatorRadiusModifier = 100;
        }
        if (indicatorRadiusModifier < 2) {
            indicatorRadiusModifier = 2;
        }
        if(knobRadiusModifier > 100){
            knobRadiusModifier = 100;
        }
        if(knobRadiusModifier < 2){
            knobRadiusModifier = 2;
        }


        float tempa = knobRadiusMin - knobRadiusMax;
        float tempb = tempa/100;
        float tempc = Math.abs(knobRadiusModifier-100);
        float tempd = tempb * tempc;
        float tempe = tempd + knobRadiusMax;
        knobRadiusModifier = tempe;

        float tempf = indicatorRadiusMin - indicatorRadiusMax;
        float tempg = tempf/100;
        float temph = Math.abs(indicatorRadiusModifier-100);
        float tempi = tempg * temph;
        float tempj = tempi + indicatorRadiusMax;
        indicatorRadiusModifier = tempj;

    }*/
	
	@Override
	protected void onDraw(final Canvas canvas) {
		
		long StartTime = System.nanoTime();
		
		
		x = getWidth() / 2;
		y = getHeight() / 2;
		paint.setColor(knobColor);
		indicatorX = x;
		indicatorY = (float) (y + (x / 2.5));
		indicatorCircle.setColor(indicatorColor);
		knobRadius = getWidth() / knobRadiusModifier;
		indicatorRadius = knobRadius / indicatorRadiusModifier;
		canvas.rotate(rotation, x, y);
		canvas.drawCircle(x, y, knobRadius, paint);
		canvas.drawCircle(indicatorX, indicatorY, indicatorRadius, indicatorCircle);
		
		
		Log.i("Draw Time  - ", String.valueOf(System.nanoTime() - StartTime));
		printAvg(nums);
		super.onDraw(canvas);
	}
	
	public void printAvg(final int[] nums) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < nums.length; ++i) {
					sum += nums[i];
				}
				sum = sum / nums.length;
				Log.i("Avg ", String.valueOf(sum));
			}
		}).start();
		
	}
}

























































































































































