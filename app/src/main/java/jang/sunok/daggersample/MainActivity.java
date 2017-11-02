package jang.sunok.daggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import io.realm.Realm;
import jang.sunok.daggersample.cache.UserRealmStore;
import jang.sunok.daggersample.di.Injector;
import jang.sunok.daggersample.network.UserRestApi;
import retrofit2.Retrofit;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

public class MainActivity extends AppCompatActivity {


    SharedPreferencesStore sharedPreferencesStore;
    Retrofit retrofit;
    Realm realm;

    //Injected by UserModule
    @Inject UserRealmStore userRealmStore;
    @Inject UserRestApi userRestApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get object from Application Component
        retrofit = Injector.getApplicationComponent().retrofit();
        realm = Injector.getApplicationComponent().realm();

        //Also you can use this method
        //retrofit = ((MyApplication)getApplication()).getRetrofit();
        //realm = ((MyApplication)getApplication()).getRealm();

        sharedPreferencesStore = Injector.getApplicationComponent().sharedPreferencesStore();

        //After Inject, you can use UseRealmStore and userRestApi
        Injector.getUserComponent().inject(this);


        //do something what you want

    }
}
