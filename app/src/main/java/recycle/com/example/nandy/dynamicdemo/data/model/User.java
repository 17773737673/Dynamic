package recycle.com.example.nandy.dynamicdemo.data.model;

/**
 * Created by nandy on 16/11/11.
 */
public class User {

    private String name;
    private String avatar;
    private String age;

    public User(String name, String avatar, String age) {
        this.name = name;
        this.avatar = avatar;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAge() {
        return age;
    }
}
