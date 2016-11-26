package recycle.com.example.nandy.dynamicdemo.moudle.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import recycle.com.example.nandy.dynamicdemo.AppConstants;
import recycle.com.example.nandy.dynamicdemo.R;
import recycle.com.example.nandy.dynamicdemo.base.BaseBindingViewHolder;
import recycle.com.example.nandy.dynamicdemo.base.BaseRecycleViewAdapter;
import recycle.com.example.nandy.dynamicdemo.databinding.AdapterCircleItemBinding;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;
import recycle.com.example.nandy.dynamicdemo.moudle.main.holder.MainHolder;
import recycle.com.example.nandy.dynamicdemo.moudle.main.holder.MainImageHolder;
import recycle.com.example.nandy.dynamicdemo.moudle.main.holder.MainUrlHolder;
import recycle.com.example.nandy.dynamicdemo.moudle.main.holder.MainVideoHolder;

/**
 * Created by nandy on 16/11/25.
 */
public class MainAdapter extends BaseRecycleViewAdapter<DynamicVM.DataBean> {


    public MainAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(BaseBindingViewHolder holder, int position) {
        DynamicVM.DataBean dataBean = get(position);
        MainHolder mainHolder = (MainHolder) holder;
        mainHolder.bind(dataBean);
    }

    @Override
    public BaseBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getBaseBindingViewHolder(parent, viewType);
    }

    private BaseBindingViewHolder getBaseBindingViewHolder(ViewGroup parent, int viewType) {
        BaseBindingViewHolder baseBindingViewHolder = null;
        AdapterCircleItemBinding itemBinding = DataBindingUtil.inflate(mLayoutInflater,
                R.layout.adapter_circle_item, parent, false);
        switch (viewType) {
            case 1:
                baseBindingViewHolder = new MainImageHolder(itemBinding);
                break;
            case 2:
                baseBindingViewHolder = new MainUrlHolder(itemBinding);
                break;
            case 3:
                baseBindingViewHolder = new MainVideoHolder(itemBinding);
                break;
        }
        return baseBindingViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        DynamicVM.DataBean dataBean = get(position);
        switch (dataBean.getType()) {
            case AppConstants.TYPE_IMG:
                type = 1;
                break;
            case AppConstants.TYPE_URL:
                type = 2;
                break;
            case AppConstants.TYPE_VIDEO:
                type = 3;
                break;
        }
        return type;
    }
}
