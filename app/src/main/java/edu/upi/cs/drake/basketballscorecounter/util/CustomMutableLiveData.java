package edu.upi.cs.drake.basketballscorecounter.util;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.databinding.Observable;

/**
 * Created by drake on 3/15/2018.
 */

public class CustomMutableLiveData <T extends BaseObservable> extends MutableLiveData<T>{

    @Override
    public void setValue(T value){
        super.setValue(value);
        value.addOnPropertyChangedCallback(callback);
    }

    Observable.OnPropertyChangedCallback callback = new Observable.OnPropertyChangedCallback() {
        @Override
        public void onPropertyChanged(Observable observable, int i) {
            setValue(getValue());
        }
    };
}
