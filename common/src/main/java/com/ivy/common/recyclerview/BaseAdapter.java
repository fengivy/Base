package com.ivy.common.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivy on 2016/5/31.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{
    protected List<T> mDatas;
    private Context mContext;
    private int mLayoutId;
    private LayoutInflater mInflater;
    public BaseAdapter(Context context,int layoutId){
        mContext=context;
        mLayoutId=layoutId;
        if (mDatas==null){
            mDatas=new ArrayList<>();
        }
        mInflater= LayoutInflater.from(mContext);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateDefViewHolder(parent,viewType);
    }

    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, mLayoutId);
    }

    protected BaseViewHolder createBaseViewHolder(ViewGroup parent,int viewType){
        return new BaseViewHolder(mContext,mInflater.inflate(mLayoutId,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder,mDatas.get(position),position);
    }

    @Override
    public int getItemViewType(int position) {
        return getDefItemViewType(position);
    }

    protected int getDefItemViewType(int position){
        return super.getItemViewType(position);
    }

    public abstract void convert(BaseViewHolder holder,T item,int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);

    }

    public void add(int position, T item) {
        mDatas.add(position, item);
        notifyItemInserted(position);
    }


    public void resetData(List<T> data) {
        this.mDatas = data;
        notifyDataSetChanged();
    }

    public void addData(List<T> data){
        this.mDatas.addAll(data);
        notifyDataSetChanged();
    }

    public List<T> getData(){
        return mDatas;
    }
}
