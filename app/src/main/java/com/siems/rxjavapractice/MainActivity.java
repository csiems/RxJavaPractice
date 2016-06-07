package com.siems.rxjavapractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

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


        Observable.just("Nice to meet you.")
            .subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    System.out.println(s);
                }
            });

        Observable.just("And how about this lambda?")
                .subscribe(s -> System.out.println(s));
    }
}
