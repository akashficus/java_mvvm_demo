package com.rf.javamvvmdemo.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.rf.javamvvmdemo.R;

public abstract class BaseActivity<VB extends ViewDataBinding> extends AppCompatActivity {

    @LayoutRes
    private final int layoutRes;
    protected VB viewDataBinding;

    public BaseActivity(@LayoutRes int layoutRes) {
        this.layoutRes = layoutRes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, layoutRes);
    }

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public <T> void moveToNextScreenWithFinishActivity(Class<T> nextMoveClass) {
        Intent intent = new Intent(getApplicationContext(), nextMoveClass);
        startActivity(intent);
        finish();
    }

    public void moveToNextScreen(Class<? extends AppCompatActivity> nextMoveClass) {
        Intent intent = new Intent(getApplicationContext(), nextMoveClass);
        startActivity(intent);
    }

    public void sessionExpired() {
        AlertDialog mBuilder = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.key_session_expired))
                .setMessage(R.string.key_you_session_has_expired)
                .setPositiveButton(R.string.key_ok, null)
                .show();

        mBuilder.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(view -> {
            //startActivity(new Intent(this, SignInActivity.class));
            finishAffinity();
        });
    }

    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}