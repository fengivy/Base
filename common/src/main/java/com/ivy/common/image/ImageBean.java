package com.ivy.common.image;

/**
 * Created by ivy on 2016/5/31.
 */
public class ImageBean {
    private boolean isCircle=false;
    private boolean isRadius=false;
    private int radiusSize=0;
    private int placeHolder=0;

    public boolean isCircle() {
        return isCircle;
    }

    public void setIsCircle(boolean isCircle) {
        this.isCircle = isCircle;
    }

    public boolean isRadius() {
        return isRadius;
    }

    public void setIsRadius(boolean isRadius) {
        this.isRadius = isRadius;
    }

    public int getRadiusSize() {
        return radiusSize;
    }

    public void setRadiusSize(int radiusSize) {
        this.radiusSize = radiusSize;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
    }


}
