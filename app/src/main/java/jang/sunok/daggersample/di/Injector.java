package jang.sunok.daggersample.di;


import jang.sunok.daggersample.MyApplication;
import jang.sunok.daggersample.di.component.ApplicationComponent;
import jang.sunok.daggersample.di.component.DaggerApplicationComponent;
import jang.sunok.daggersample.di.component.DaggerUserComponent;
import jang.sunok.daggersample.di.component.UserComponent;
import jang.sunok.daggersample.di.module.ApplicationModule;
import jang.sunok.daggersample.di.module.NetModule;
import jang.sunok.daggersample.di.module.UserModule;

/**
 * Created by jangsunok on 2017. 11. 02.
 */


public class Injector {


    private static ApplicationComponent applicationComponent;
    private static UserComponent userComponent;


    public static void initializeApplicationComponent(MyApplication application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .netModule(new NetModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


    public static UserComponent getUserComponent() {
        if (userComponent == null) {
            userComponent = DaggerUserComponent.builder()
                    .applicationComponent(getApplicationComponent())
                    .userModule(new UserModule())
                    .build();
        }
        return userComponent;
    }
}
