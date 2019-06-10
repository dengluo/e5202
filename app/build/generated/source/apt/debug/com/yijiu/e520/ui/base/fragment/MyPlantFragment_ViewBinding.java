// Generated code from Butter Knife. Do not modify!
package com.yijiu.e520.ui.base.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yijiu.e520.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyPlantFragment_ViewBinding implements Unbinder {
  private MyPlantFragment target;

  @UiThread
  public MyPlantFragment_ViewBinding(MyPlantFragment target, View source) {
    this.target = target;

    target.ll_no_date_img = Utils.findRequiredViewAsType(source, R.id.ll_no_date_img, "field 'll_no_date_img'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyPlantFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ll_no_date_img = null;
  }
}
