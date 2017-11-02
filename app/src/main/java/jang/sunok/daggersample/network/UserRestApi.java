package jang.sunok.daggersample.network;

import io.reactivex.Single;
import jang.sunok.daggersample.model.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

public interface UserRestApi {

    @GET("{your_url}")
    Single<User> getUser(@Path("id") int id);


}
