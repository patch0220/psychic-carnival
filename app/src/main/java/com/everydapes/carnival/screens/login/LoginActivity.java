package com.everydapes.carnival.screens.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bluelinelabs.conductor.ChangeHandlerFrameLayout;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.everydapes.carnival.R;
import com.everydapes.carnival.screens.login.email.EmailLoginController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.fl_container)
    ChangeHandlerFrameLayout container;

    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        router = Conductor.attachRouter(this, container, savedInstanceState);
        router.setRoot(RouterTransaction.with(new EmailLoginController())
                .popChangeHandler(new FadeChangeHandler())
                .pushChangeHandler(new FadeChangeHandler())
                .tag(EmailLoginController.class.getSimpleName()));
    }
}
