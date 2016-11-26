package recycle.com.example.nandy.dynamicdemo.moudle.detail;

import android.widget.Toast;

import javax.inject.Inject;

import recycle.com.example.nandy.dynamicdemo.databinding.ActivityDynamicDetailBinding;
import recycle.com.example.nandy.dynamicdemo.domain.model.User;

/**
 * Created by nandy on 16/11/16.
 */
public class DynamicDetailPresenter implements DynamicDetailContract.Presenter {

    private final DynamicDetailContract.View view;
    private final ActivityDynamicDetailBinding binding;

    @Inject
    public DynamicDetailPresenter(DynamicDetailContract.View view, ActivityDynamicDetailBinding binding) {
        this.view = view;
        this.binding = binding;
        this.binding.setPresenter(this);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        binding.getUser().setName(charSequence.toString());
    }

    public void onTextChanged2(CharSequence charSequence, int i, int i1, int i2) {
        binding.getUser().setAge(charSequence.toString());
    }

    public void onClick(User user) {
        Toast.makeText(view.getContext(), user.getName(), Toast.LENGTH_LONG).show();
    }

    public void onClick2(User user) {
        Toast.makeText(view.getContext(), user.getAge(), Toast.LENGTH_LONG).show();
    }
}
