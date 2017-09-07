package Data.remote;

import Data.model.JSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MyPC on 06/09/2017.
 */

public interface RequestInterface {
    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();
}
