package jang.sunok.daggersample.cache;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.realm.Realm;
import jang.sunok.daggersample.model.User;

/**
 * Created by Mathpresso on 2017-11-02.
 */

public class UserRealmStore {

    Realm realm;

    @Inject
    public UserRealmStore(Realm realm) {
        this.realm = realm;
    }


    @Nullable
    public User getUser(int userId){
        User realmResult = realm.where(User.class).equalTo("id", userId).findFirst();
        if(realmResult==null) return null;
        return realm.copyFromRealm(realmResult);
    }

}
