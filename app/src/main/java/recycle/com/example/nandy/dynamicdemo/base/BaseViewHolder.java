package recycle.com.example.nandy.dynamicdemo.base;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * ViewHolder基类
 * <p/>
 * Created by ZhangWF(zhangwf0929@gmail.com) on 15/4/17.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private T item;
    public int position;
    public Context mContext;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
    }

    public abstract void initView(T item);

    public void setItem(T item, int position) {
        this.item = item;
        this.position = position;
        itemView.setTag(position);
        initView(item);
    }

    public void onItemSelected() {
        itemView.setBackgroundColor(Color.LTGRAY);
    }

    public void onItemClear() {
        itemView.setBackgroundColor(Color.WHITE);
    }

}
