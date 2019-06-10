// Generated code from Butter Knife. Do not modify!
package com.yijiu.e520.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yijiu.e520.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131296479;

  private View view2131296480;

  private View view2131296481;

  private View view2131296478;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tab_receipt, "field 'tab_receipt' and method 'click'");
    target.tab_receipt = Utils.castView(view, R.id.tab_receipt, "field 'tab_receipt'", TextView.class);
    view2131296479 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tab_team, "field 'tab_team' and method 'click'");
    target.tab_team = Utils.castView(view, R.id.tab_team, "field 'tab_team'", TextView.class);
    view2131296480 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tab_wallet, "field 'tab_wallet' and method 'click'");
    target.tab_wallet = Utils.castView(view, R.id.tab_wallet, "field 'tab_wallet'", TextView.class);
    view2131296481 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tab_my, "field 'tab_my' and method 'click'");
    target.tab_my = Utils.castView(view, R.id.tab_my, "field 'tab_my'", TextView.class);
    view2131296478 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tab_receipt = null;
    target.tab_team = null;
    target.tab_wallet = null;
    target.tab_my = null;

    view2131296479.setOnClickListener(null);
    view2131296479 = null;
    view2131296480.setOnClickListener(null);
    view2131296480 = null;
    view2131296481.setOnClickListener(null);
    view2131296481 = null;
    view2131296478.setOnClickListener(null);
    view2131296478 = null;
  }
}
