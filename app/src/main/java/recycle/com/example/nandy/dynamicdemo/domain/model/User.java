package recycle.com.example.nandy.dynamicdemo.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import recycle.com.example.nandy.dynamicdemo.BR;

/**
 * Created by nandy on 16/11/11.
 */
public class User extends BaseObservable {

    private String name;
    private String avatar;
    private String age;

    public User(String name, String avatar, String age) {
        this.name = name;
        this.avatar = avatar;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    @Bindable
    public String getAge() {
        return age;
    }
}
