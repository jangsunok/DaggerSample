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


    @Provides
    @PerActivity
    public UserRestApi provideUserRestApi(Retrofit retrofit) {
        //Retrofit is injected by ApplicationComponent(NetModule)
        return retrofit.create(UserRestApi.class);
    }

    @Provides
    @PerActivity
    public UserRealmStore provideUserRealmStore(Realm realm) {
        //Realm is injected by ApplicationComponent(ApplicationModule)
        return new UserRealmStore(realm);
    }

}
