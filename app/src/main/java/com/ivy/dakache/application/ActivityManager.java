package com.ivy.dakache.application;

import android.app.Activity;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author ivy
 * @description 应用程序Activity管理类：用于Activity管理和应用程序退出
 */
public class ActivityManager {

    private static final Stack<Activity> activityStack = new Stack<>();

    /**
     * 返回activity的个数
     *
     * @return
     */
    public static int getActivityStackSize() {
        return activityStack.size();
    }

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity) {
        if (activityStack == null)
            return;
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public static Activity getCurrentActivity() {
        if (activityStack == null || activityStack.size() < 1)
            return null;
        return activityStack.lastElement();
    }

    /**
     * 获取前一个Activity
     */
    public static Activity getLastActivity() {
        if (activityStack == null || activityStack.size() < 2)
            return null;
        return activityStack.get(activityStack.size() - 2);
    }


    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public static void finishActivity() {
        if (activityStack == null || activityStack.size() < 1)
            return;
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        if (activityStack == null)
            return;
        Iterator<Activity> it = activityStack.iterator();
        while (it.hasNext()) {
            Activity activity = it.next();
            if (cls.equals(activity.getClass())) {
                it.remove();
                activity.finish();
            }

        }
    }

    /**
     * 返回第一次出现此activity的index
     */
    public static int indexOfActivity(Class<?> cls) {
        if (activityStack != null) {
            Iterator<Activity> it = activityStack.iterator();
            for (int i = 0; it.hasNext(); i++) {
                Activity activity = it.next();
                if (cls.equals(activity.getClass())) {
                    return i;
                }

            }
        }
        return -1;
    }

    /**
     * 返回最后一次出现activity的index
     */
    public static int lastOfActivity(Class<?> cls) {
        if (activityStack != null) {
            Iterator<Activity> it = activityStack.iterator();
            for (int i = activityStack.size() - 1; it.hasNext(); i--) {
                Activity activity = it.next();
                if (cls.equals(activity.getClass())) {
                    return i;
                }

            }
        }
        return -1;
    }

    /**
     * 返回指定位置的activity
     */
    public static Activity getActivityAt(int index) {
        if (activityStack == null || activityStack.size() <= index)
            return null;
        return activityStack.get(index);
    }


    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        if (activityStack == null)
            return;
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束其他Activity除本身之外
     */
    public static void finishOtherActivity() {
        if (activityStack == null)
            return;
        Iterator<Activity> it = activityStack.iterator();
        while (it.hasNext()) {
            Activity activity1 = it.next();
            Activity activity = getCurrentActivity();
            if (activity != null && !activity.getClass().equals(activity1.getClass())) {
                it.remove();
                activity1.finish();
            }
        }
    }

    /**
     * 退出应用程序
     */
    public static void appExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //            System.runFinalizersOnExit(true);
            System.exit(0);
        }
    }
}