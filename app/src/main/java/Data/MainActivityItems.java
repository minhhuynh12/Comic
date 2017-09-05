package Data;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MyPC on 29/08/2017.
 */

public class MainActivityItems implements Serializable {
    @SerializedName("title")
    public String name;
    @SerializedName("id")
    public String id;
    @SerializedName("slug")
    public String slug;
    @SerializedName("imageUrls")
    public ArrayList<String> imageUrls;
}
