package com.example.canvas;

import androidx.appcompat.app.AppCompatActivity;
import com.example.canvas.geometry.*;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        setContentView(drawView);

        handler = new Handler();
        //Поток который будет обновлять канвас
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            drawView.invalidate();
                        }
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();


    }

    class DrawView extends View{
        Paint p;
        Circle[] circles;


        boolean firstTime = true;
        int canvasHeight, canvasWidth;

        public DrawView(Context context){
            super(context);
            p = new Paint();

        }


        @Override
        protected void onDraw(Canvas canvas) {
            canvasHeight = getHeight();
            canvasWidth = getWidth();

            if (firstTime){
                firstTime = false;
                canvas.drawColor(Color.WHITE);
                p.setColor(Color.BLACK);
                InitFigures(15);// 15 кругов

                for (Circle c:
                     circles) {
                    canvas.drawCircle(c.getX(),c.getY(),c.getRadius(),p);
                }
            }else {
                Update(canvas);
            }

        }

        public void changeColor(){
            Random rnd = new Random();
            p.setColor( Color.rgb( rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))   );
        }

        private void InitFigures(int count){
            circles = new Circle[count];

            for (int i = 0; i < count; i++) {
                Circle c = new Circle();
                c.setRadius(new Random().nextInt(100) + 20);
                //попытка не заспавнить заблиско к краю
                c.setY(new Random().nextInt(canvasHeight - (2 * c.getRadius())) + (c.getRadius()* 2));
                c.setX(new Random().nextInt(canvasWidth - (2 * c.getRadius())) + (c.getRadius()* 2));
                //горизнатльная и вертикальная скорость
                c.setOffsetX(new Random().nextInt(8) + 1);
                c.setOffsetY(new Random().nextInt(8) + 1);
                circles[i] = c;
            }

        }

        void Update(Canvas canvas){
            canvas.drawColor(Color.WHITE);

            for (Circle c:
                    circles) {
                //Vertical
                if ((c.getY()-c.getRadius()) <= 0){
                    c.setOffsetY(-c.getOffsetY());
                    changeColor();
                }
                else if ((c.getY()+c.getRadius()) >= canvasHeight){
                    c.setOffsetY(-c.getOffsetY());

                }//Horizontal
                else if ((c.getX()-c.getRadius()) <= 0){
                    c.setOffsetX(-c.getOffsetX());

                }
                else if ((c.getX()+c.getRadius()) >= canvasWidth){
                    c.setOffsetX(-c.getOffsetX());

                }
                c.offset();
                canvas.drawCircle(c.getX(),c.getY(),c.getRadius(),p);
            }

        }


    }


    //ENDE
}