package com.everydapes.carnival.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.everydapes.carnival.common.utils.TextUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        injectDependencies();
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutResId());
        ButterKnife.bind(this);
    }

    protected abstract void injectDependencies();
    @LayoutRes
    protected abstract int provideLayoutResId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Setup action bar
     * @param toolbar
     * @param title
     */
    protected void setupActionBar(Toolbar toolbar, String title) {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            if (!TextUtils.isEmpty(title)) {
                getSupportActionBar().setTitle(title);
            } else {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }

    /**
     * Setup action bar
     * @param toolbar
     */
    protected void setupActionBar(Toolbar toolbar) {
        setupActionBar(toolbar, null);
    }
}
