package com.ivy.common.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by ivy on 2016/5/31.
 */
public class ImageUtils {

    public static void displayUrl(Context context,String url,ImageView imageView,ImageBean ...beans){
        if (beans.length<1){
        Glide.with(context).load(url).into(imageView);
        }else{
            display(context, url, imageView, false, beans[0]);
        }
    }

    public static void displayLocal(Context context,String path,ImageView imageView,ImageBean ...beans){
        if (beans.length<1) {
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
        }else{
            display(context,path,imageView,true,beans[0]);
        }
    }

    private static void display(Context context, String url, ImageView imageView, boolean isLocal,ImageBean bean) {
        DrawableTypeRequest manager=Glide.with(context).load(url);
        if (bean.isCircle()){
            manager.bitmapTransform(new CropCircleTransformation(context));
        }
        if (bean.isRadius()){
            manager.bitmapTransform(new RoundedCornersTransformation(context,bean.getRadiusSize(), 0));
        }
        if (bean.getPlaceHolder()!=0){
            manager.placeholder(bean.getPlaceHolder());
        }
        if (isLocal){
            manager.diskCacheStrategy(DiskCacheStrategy.NONE);
        }else{
            manager.diskCacheStrategy(DiskCacheStrategy.ALL);
        }
        manager.into(imageView);
    }

}
