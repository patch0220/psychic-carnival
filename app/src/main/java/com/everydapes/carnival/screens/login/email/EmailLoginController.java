package com.everydapes.carnival.screens.login.email;

import android.Manifest;
import android.app.LoaderManager;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.everydapes.carnival.BaseApplication;
import com.everydapes.carnival.R;
import com.everydapes.carnival.base.BaseMvpController;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * A login screen that offers login via email/password.
 */
public class EmailLoginController extends BaseMvpController<EmailLoginView, EmailLoginPresenter> implements EmailLoginView {

    @Inject
    Provider<EmailLoginPresenter> presenterProvider;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_login, container, false);
    }

    @Override
    protected void onViewBound(@NonNull View view) {

    }

    @Override
    protected void injectDependencies() {
        BaseApplication.get(getApplicationContext()).getAppComponent().plus(new EmailLoginModule(this)).inject(this);
    }

    @NonNull
    @Override
    public EmailLoginPresenter createPresenter() {
        return presenterProvider.get();
    }

    private void checkPermissions() {
        RxPermissions rxPermissions = new RxPermissions(getActivity());
        rxPermissions
                .request(Manifest.permission.READ_CONTACTS)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull Boolean aBoolean) {
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
