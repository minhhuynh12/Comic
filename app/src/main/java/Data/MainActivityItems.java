package Data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MyPC on 29/08/2017.
 */

public class MainActivityItems implements Serializable {
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
//    @SerializedName("slug")
//    public String slug;
}
