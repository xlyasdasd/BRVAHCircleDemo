package pkanimation.xly.com.brvahcircledemo.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xiemy on 2016/9/23.
 */

public class DividerLine extends Y_DividerItemDecoration {

    public DividerLine(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        Y_Divider divider = null;
        switch (itemPosition % 2) {
            case 0:
                //每一行第一个显示rignt和bottom
                divider = new Y_DividerBuilder()
                        .setRightSideLine(true, 0xffffffff, 5, 0, 0)
                        .setBottomSideLine(true, 0xffffffff, 5, 0, 0)
                        .create();
                break;
            case 1:
                //每一行第二个显示rignt和bottom
                divider = new Y_DividerBuilder()
                        .setRightSideLine(true, 0xffffffff, 5, 0, 0)
                        .setBottomSideLine(true, 0xffffffff, 5, 0, 0)
                        .create();
                break;
            case 2:
                //每一行第三个显示rignt和bottom
                divider = new Y_DividerBuilder()
                        .setRightSideLine(true, 0xffffffff, 5, 0, 0)
                        .setBottomSideLine(true, 0xffffffff, 5, 0, 0)
                        .create();
                break;
            case 3:
                //每一行第四个显示rignt和bottom
                divider = new Y_DividerBuilder()
                        .setBottomSideLine(true, 0xffffffff, 5, 0, 0)
                        .create();
                break;
            default:
                break;
        }
        return divider;
    }
}