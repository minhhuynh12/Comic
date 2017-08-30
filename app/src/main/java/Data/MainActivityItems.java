package Data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MyPC on 29/08/2017.
 */

public class MainActivityItems implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public String id;
    @SerializedName("slug")
    public String slug;
}
