package Data.remote;

/**
 * Created by MyPC on 04/09/2017.
 */

public class ApiUtils {
//    private ApiUtils() {}
//
//    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
//
//    public static APIService getAPIService() {
//
//        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
//    }

    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }

}
