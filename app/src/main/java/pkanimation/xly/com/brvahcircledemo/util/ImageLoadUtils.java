package pkanimation.xly.com.brvahcircledemo.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import pkanimation.xly.com.brvahcircledemo.util.transform.RoundTransform;
import pkanimation.xly.com.brvahcircledemo.util.transform.SimpleCircleTransform;

import static com.bumptech.glide.Glide.with;

/**
 * Created by xuleyuan on 2017/10/12
 */

public class ImageLoadUtils {
    /**
     * 异步加载图片
     *
     * @param imgUrl    图片url
     * @param imageView
     */
    public static void displayImage(Context context, String imgUrl, ImageView imageView) {
        RequestManager rm = Glide.with(context);
        rm.load(imgUrl).centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 异步加载图片
     *
     * @param imgUrl      图片url
     * @param imageView
     * @param drawableRes 默认图片资源id
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void displayImage(Context context, String imgUrl, ImageView imageView, int drawableRes, float round) {
        with(context)
                .load(imgUrl)
                .centerCrop()
                .placeholder(drawableRes)
                .crossFade()
                .dontAnimate()
                .transform(new RoundTransform(context, round))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }


    /**
     * 设置简单的圆头像
     *
     * @param headIconUrl
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void setSimpleCircleHeadIcon(Context context, String headIconUrl, @DrawableRes int defaultResId, final ImageView view) {
        if (TextUtils.isEmpty(headIconUrl)) {
            setDefaultSimpleCircleHeadIcon(context, defaultResId, view);
            return;
        }

        with(context).load(headIconUrl).placeholder(defaultResId)
                .centerCrop().error(defaultResId).crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new SimpleCircleTransform(context)).into(view);
    }

    /**
     * 设置默认的简单的圆头像
     */
    public static void setDefaultSimpleCircleHeadIcon(Context context,
                                                      @DrawableRes int defaultResId, final ImageView view) {
        with(context).load(defaultResId).placeholder(defaultResId)
                .crossFade().centerCrop().error(defaultResId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new SimpleCircleTransform(context)).into(view);

    }
}
