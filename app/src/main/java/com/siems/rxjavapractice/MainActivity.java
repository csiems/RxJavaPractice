package com.siems.rxjavapractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> helloObservable = Observable.create(
            new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> sub) {
                    sub.onNext("Hello, World!");
                    sub.onCompleted();
                }
            }
        );

        Subscriber<String> helloSubscriber = new Subscriber<String>() {

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }
        };

        helloObservable.subscribe(helloSubscriber);

    }
}
