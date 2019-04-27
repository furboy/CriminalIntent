package com.ctech.aleco.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public class PictureUtils {


        public static Bitmap getScaledBitmap(String path, Activity activity){
            Point size = new Point();
            activity.getWindowManager().getDefaultDisplay().getSize(size);
            return getScaledBitmap(path, size.x, size.y);
        }


    public static Bitmap getScaledBitmap(String path, int destWidith, int destHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidith = options.outWidth;
        float srcHeight = options.outHeight;

        int inSampleSize = 1;
        if (srcHeight > destHeight || srcWidith > destHeight){
            float heightScale = srcHeight / destHeight;
            float widithScale = srcWidith / destWidith;

            inSampleSize = Math.round(heightScale > widithScale ? heightScale : widithScale);
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        return  BitmapFactory.decodeFile(path, options);
    }
}
