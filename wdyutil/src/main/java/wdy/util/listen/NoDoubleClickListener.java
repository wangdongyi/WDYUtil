package wdy.util.listen;

import android.view.View;

import java.util.Calendar;

/**
 * 作者：王东一
 * 创建时间：2017/5/8.
 */

public abstract class NoDoubleClickListener implements View.OnClickListener {
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    protected abstract void onNoDoubleClick(View v);
}
