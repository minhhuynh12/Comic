package Data.remote;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
/**
 * Created by MyPC on 04/09/2017.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
