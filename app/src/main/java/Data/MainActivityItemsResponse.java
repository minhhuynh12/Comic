package Data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MyPC on 29/08/2017.
 */

public class MainActivityItemsResponse implements Serializable {
    @SerializedName("data")
    public ArrayList<MainActivityItems> data;
}
