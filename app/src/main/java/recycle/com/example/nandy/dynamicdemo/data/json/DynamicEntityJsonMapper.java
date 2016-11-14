package recycle.com.example.nandy.dynamicdemo.data.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class DynamicEntityJsonMapper {

    private final Gson gson;

    @Inject
    public DynamicEntityJsonMapper() {
        this.gson = new Gson();
    }

    public String toJson(Object src) {
        return this.gson.toJson(src);
    }

    public  <T> T fromJson(String jsonString, Class<T> classOfT) {
        T target = null;
        try {
            target = this.gson.fromJson(jsonString, classOfT);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return target;
    }


    public  <T> T fromJson(String jsonString, Type type) {
        T target = null;
        try {
            target = this.gson.fromJson(jsonString, type);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return target;
    }
}
