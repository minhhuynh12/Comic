package Data.remote;


import Data.model.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by MyPC on 04/09/2017.
 */

public interface APIService {
    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);
}
