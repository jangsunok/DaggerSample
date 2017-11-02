package jang.sunok.daggersample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import jang.sunok.daggersample.MyApplication;
import jang.sunok.daggersample.SharedPreferencesStore;
import jang.sunok.daggersample.di.module.ApplicationModule;
import jang.sunok.daggersample.di.module.NetModule;
import retrofit2.Retrofit;

/**
 * Created by jangsunok on 2017. 11. 02.
 */


@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {
    Realm realm();

    SharedPreferencesStore sharedPreferencesStore();

    Retrofit retrofit();

    void inject(MyApplication application);

}