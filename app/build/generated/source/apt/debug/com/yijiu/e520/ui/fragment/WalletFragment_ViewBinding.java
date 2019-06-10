// Generated code from Butter Knife. Do not modify!
package com.yijiu.e520.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yijiu.e520.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WalletFragment_ViewBinding implements Unbinder {
  private WalletFragment target;

  @UiThread
  public WalletFragment_ViewBinding(WalletFragment target, View source) {
    this.target = target;

    target.tv_header_title = Utils.findRequiredViewAsType(source, R.id.tv_header_title, "field 'tv_header_title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WalletFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_header_title = null;
  }
}
