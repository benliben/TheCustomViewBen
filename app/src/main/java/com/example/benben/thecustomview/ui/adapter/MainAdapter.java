package com.example.benben.thecustomview.ui.adapter;

import android.speech.tts.Voice;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.benben.thecustomview.R;

/**
 * Created by benben on 2016/4/27.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private String[] mDatas = null;
    private OnItemClickListener mListener;


    public MainAdapter(String[] mDatas) {
        this.mDatas = mDatas;
    }

    /**创建ViewHolder*/
    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {

         View   view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        MainHolder mHolder = new MainHolder(view);
        return mHolder;

    }

    /**绑定viewHolder*/
    @Override
    public void onBindViewHolder(final MainHolder holder, int position) {
        holder.mTx.setText(mDatas[position]);

        /**设置监听*/
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置
                    mListener.ItemClickListener(holder.itemView, pos);//把事情交给实现类去实现
                }
            });
        }
    }

    /**数据的数量*/
    @Override
    public int getItemCount() {
        return mDatas.length;
    }

    /**自定义的viewHolder，持有每一个item的所有界面的元素*/
    public class MainHolder extends RecyclerView.ViewHolder {
        private TextView mTx;
        public MainHolder(View itemView) {
            super(itemView);
            mTx = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    /**添加点击事件*/
    public interface OnItemClickListener{
        void ItemClickListener(View view, int position);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
