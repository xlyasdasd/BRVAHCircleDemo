package pkanimation.xly.com.brvahcircledemo.divider;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by xuleyuan on 2017/8/13
 */

public class Dp2Px {
    private Dp2Px() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int convert(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }


}