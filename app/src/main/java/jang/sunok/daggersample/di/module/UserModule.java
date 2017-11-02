package jang.sunok.daggersample.di.module;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import jang.sunok.daggersample.cache.UserRealmStore;
import jang.sunok.daggersample.di.PerActivity;
import jang.sunok.daggersample.network.UserRestApi;
import retrofit2.Retrofit;

/**
 * Created by jangsunok on 2017. 11. 02.
 */
@Module
public class UserModule {
    Realm realm;
    Retrofit retrofit;

    public UserModule(Realm realm, Retrofit retrofit) {
        this.realm = realm;
        this.retrofit = retrofit;
    }

    @Provides
    @PerActivity
    public UserRestApi provideUserRestApi() {
        return retrofit.create(UserRestApi.class);
    }

    @Provides
    @PerActivity
    public UserRealmStore provideUserRealmStore() {
        return new UserRealmStore(realm);
    }

}
