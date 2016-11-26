package recycle.com.example.nandy.dynamicdemo.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseBindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;
    public Context mContext;
    private int position;

    public BaseBindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding;
        mContext = itemView.getContext();
    }

    public T getBinding() {
        return mBinding;
    }
}
