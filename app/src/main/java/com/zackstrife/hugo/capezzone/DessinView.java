package com.zackstrife.hugo.capezzone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ZackStrife on 3/14/2016.
 */
public class DessinView extends View {

    private Paint paint = new Paint();
    protected Path path =new Path();
    private int Stroke=10;
    private Context appContext;

    public DessinView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Récupérer le contexte
        appContext = context;
        //Définir précisement le pinceau
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Stroke);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                break;

                case MotionEvent.ACTION_UP:
                    break;
        }
        invalidate();
        return true;
    }

    public void setPaintColor(int couleur){
        paint.setColor(couleur);
    }


    public void setStroke(int stroke) {
        Stroke = stroke;
    }
}
