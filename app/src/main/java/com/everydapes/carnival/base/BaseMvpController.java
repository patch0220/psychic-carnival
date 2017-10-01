package com.everydapes.carnival.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.conductor.MvpController;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpController<V extends MvpView, P extends MvpPresenter<V>> extends MvpController<V, P> {

    private Unbinder unbinder;

    protected BaseMvpController() {
        super();
    }

    protected BaseMvpController(Bundle args) {
        super(args);
    }

    protected abstract View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container);

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        setRetainViewMode(RetainViewMode.RETAIN_DETACH);
        injectDependencies();

        View view = inflateView(inflater, container);
        unbinder = ButterKnife.bind(this, view);
        getMosbyLifecycleListener().postCreateView(this, view);
        onViewBound(view);
        return view;
    }

    protected abstract void onViewBound(@NonNull View view);

    protected abstract void injectDependencies();

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        unbinder.unbind();
        unbinder = null;
    }

}
