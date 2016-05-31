package com.ivy.common.recyclerview;

import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by ivy on 2016/5/31.
 */
public abstract class BaseMultiAdapter<T extends MultiItemModel> extends BaseAdapter {
    private SparseArray<Integer> layouts;
    public BaseMultiAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    protected int getDefItemViewType(int position) {
        return ((MultiItemModel) mDatas.get(position)).getItemType();
    }


    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getLayoutId(viewType));
    }



    private int getLayoutId(int viewType) {
        return layouts.get(viewType);
    }

    /**
     * 添加类型
     * @param type
     * @param layoutResId
     */
    protected void addItmeType(int type, int layoutResId) {
        if (layouts == null) {
            layouts = new SparseArray<>();
        }
        layouts.put(type, layoutResId);
    }
}
