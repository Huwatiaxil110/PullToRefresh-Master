package com.handmark.pulltorefresh.samples;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CurveView extends View{
    int drawY;
    float anchorX, anchorY;
    Paint mPaint;

    public CurveView(Context context) {
        this(context, null);
    }

    public CurveView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CurveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setColor(getResources().getColor(R.color.colorCurce));
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(getPath(), mPaint);
    }

    Path mPath;
    private Path getPath(){
        Log.e("XXXX", "drawY = " + drawY);
        mPath = new Path();
        mPath.reset();
        anchorX = getWidth()/2;
        anchorY = -2*drawY;
//		Log.e("TAG", "LoadingLayout: (width, height) = (" + getWidth()+ ", " +getHeight()+ ")");
//		Log.e("TAG", "Innerlayout: (width, height) = (" + mInnerLayout.getWidth()+ ", " +mInnerLayout.getHeight()+ ")");
//		Log.e("TAG", "drawY = " + drawY);
        mPath.moveTo(0, 0);
        mPath.quadTo(anchorX, anchorY, getWidth(), 0);

        return mPath;
    }

    public void setDrawY(int drawY){
        this.drawY = drawY;
        postInvalidate();
    }
}
