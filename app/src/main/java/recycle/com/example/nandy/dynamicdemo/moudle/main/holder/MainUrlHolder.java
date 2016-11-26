package recycle.com.example.nandy.dynamicdemo.moudle.main.holder;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import recycle.com.example.nandy.dynamicdemo.R;
import recycle.com.example.nandy.dynamicdemo.databinding.ViewStubImageBodyBinding;
import recycle.com.example.nandy.dynamicdemo.databinding.ViewStubUrlBodyBinding;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;

/**
 * Created by nandy on 16/11/25.
 */
public class MainUrlHolder extends MainHolder {

    private ViewStubUrlBodyBinding viewStubUrlBodyBinding;

    public MainUrlHolder(ViewDataBinding binding) {
        super(binding);
    }

    @Override
    public void initView(ViewStub viewStub) {
        viewStub.setLayoutResource(R.layout.view_stub_url_body);
        viewStub.inflate();
    }

    @Override
    public void bind(DynamicVM.DataBean vm) {
        super.bind(vm);
        viewStubUrlBodyBinding = (ViewStubUrlBodyBinding) itemBinding.viewStub.getBinding();
        viewStubUrlBodyBinding.setLink(vm.getLink());
    }
}
