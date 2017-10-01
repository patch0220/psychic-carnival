package com.everydapes.carnival.screens.login;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everydapes.carnival.base.BaseMvpController;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;


public class LoginController extends BaseMvpController {
    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return null;
    }

    @Override
    protected void onViewBound(@NonNull View view) {

    }

    @Override
    protected void injectDependencies() {

    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return null;
    }
}
