import com.google.gson.GsonBuilder;

public interface ToJson {
    default String toJson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .creat()
                .toJson(this);
    }
}
