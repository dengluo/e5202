// Generated code from Butter Knife. Do not modify!
package com.yijiu.e520.ui.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yijiu.e520.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131296306;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.mEtUserName = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'mEtUserName'", EditText.class);
    target.mEtPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'mEtPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_login, "method 'login'");
    view2131296306 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.login(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEtUserName = null;
    target.mEtPassword = null;

    view2131296306.setOnClickListener(null);
    view2131296306 = null;
  }
}
