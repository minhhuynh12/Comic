package Data.remote;



import java.util.List;

import Data.model.SOAnswersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswersObjects();
}