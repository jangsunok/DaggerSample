package jang.sunok.daggersample.di.component;


import dagger.Component;
import jang.sunok.daggersample.MainActivity;
import jang.sunok.daggersample.di.PerActivity;
import jang.sunok.daggersample.di.module.UserModule;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

@PerActivity
@Component(modules = {UserModule.class})
public interface UserComponent {

    void inject(MainActivity activity);


}
