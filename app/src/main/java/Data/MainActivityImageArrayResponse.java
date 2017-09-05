package Data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MyPC on 30/08/2017.
 */

public class MainActivityImageArrayResponse implements Serializable {
    @SerializedName("imageUrls")
    public ArrayList<MainActivityItems> imageUrlsArray;
}
