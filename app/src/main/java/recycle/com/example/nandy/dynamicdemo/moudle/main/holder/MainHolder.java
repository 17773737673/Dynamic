package recycle.com.example.nandy.dynamicdemo.moudle.main.holder;

import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import recycle.com.example.nandy.dynamicdemo.base.BaseBindingViewHolder;
import recycle.com.example.nandy.dynamicdemo.databinding.AdapterCircleItemBinding;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;

/**
 * Created by nandy on 16/11/25.
 */
public abstract class MainHolder extends BaseBindingViewHolder {

    public final AdapterCircleItemBinding itemBinding;

    public MainHolder(ViewDataBinding binding) {
        super(binding);
        itemBinding = (AdapterCircleItemBinding) binding;
        initView(itemBinding.viewStub.getViewStub());
    }

    public abstract void initView(ViewStub viewStub);

    public void bind(DynamicVM.DataBean vm) {
        itemBinding.setVm(vm);
        itemBinding.executePendingBindings();
    }

    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    public static void loadImageFromUrl(ImageView imageView,
                                        String url,
                                        Drawable placeholder) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(placeholder)
                .into(imageView);
    }
}
