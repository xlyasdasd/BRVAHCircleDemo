package pkanimation.xly.com.brvahcircledemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pkanimation.xly.com.brvahcircledemo.R;
import pkanimation.xly.com.brvahcircledemo.constants.Constants;
import pkanimation.xly.com.brvahcircledemo.model.DynamicsModel;
import pkanimation.xly.com.brvahcircledemo.util.DateUtil;
import pkanimation.xly.com.brvahcircledemo.util.ImageLoadUtils;

import static pkanimation.xly.com.brvahcircledemo.util.DateUtil.FULL_TIME;

/**
 * 我的动态适配器
 * Created by xuleyuan on 2017/8/30
 */
public class DynamicsAdapter extends BaseMultiItemQuickAdapter<DynamicsModel, BaseViewHolder> {

    private static final int COMMENT_WITH_IMG = 100;
    private static final int COMMENT_NONE_IMG = 101;
    private static final int NONE_IMG = 0;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public DynamicsAdapter(List<DynamicsModel> data) {//构造函数中需要把所有的布局类型与布局关联起来，漏了会出resource not found error
        super(data);
        addItemType(Constants.SHARE_VIDEO, R.layout.dynamics_share_video);
        addItemType(Constants.SHARE_GAIN, R.layout.dynamics_share_gain);
        addItemType(Constants.LIKE_VIDEO, R.layout.dynamics_like_video);
        addItemType(Constants.GIFT, R.layout.dynamics_gift);
        addItemType(Constants.BAISHI, R.layout.dynamics_baishi);
        addItemType(Constants.COMMENT_WITH_IMG, R.layout.dynamice_comment_with_imgs);
        addItemType(Constants.COMMENT_NONE_IMG, R.layout.dynamics_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DynamicsModel item) {
        long at = item.getAction_time() * 1000;
        String formatData = DateUtil.getDataFormat(at);
        String actionTime = DateUtil.getTime(at, FULL_TIME);
        helper.setText(R.id.tvDynamicsDate, formatData);
        switch (helper.getItemViewType()) {
            case Constants.SHARE_VIDEO://分享视频的布局，对应了 上面                   ⬆️构造函数填入的布局，下面以此类推，要做的就是填入数据
                actionTime = mContext.getString(R.string.share_video, actionTime);
                helper.setText(R.id.tvAction, actionTime);
                helper.setText(R.id.tvContent, item.getContent());
                ImageLoadUtils.displayImage(mContext, item.getImg_url(), (ImageView) helper.getView(R.id.ivVideo));
                helper.addOnClickListener(R.id.ivOperation);
                break;

            case Constants.SHARE_GAIN:
                actionTime = mContext.getString(R.string.dynamic_results, actionTime);
                ImageLoadUtils.displayImage(mContext, item.getImg_url(), (ImageView) helper.getView(R.id.ivVideo));
                ImageLoadUtils.displayImage(mContext, item.getGain_img(), (ImageView) helper.getView(R.id.ivGain), 0, 3);
                helper.setText(R.id.tvDes, item.getDes());
                helper.setText(R.id.tvContent, item.getGain_content());
                helper.addOnClickListener(R.id.ivOperation);
                helper.setOnClickListener(R.id.ivGain, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;

            case Constants.LIKE_VIDEO:
                actionTime = mContext.getString(R.string.like_video, actionTime);
                ImageLoadUtils.displayImage(mContext, item.getImg_url(), (ImageView) helper.getView(R.id.ivVideo));
                helper.setText(R.id.tvDes, item.getDes());
                helper.getView(R.id.rlLikeVideo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;

            case Constants.GIFT:
                actionTime = mContext.getString(R.string.dynamic_send_gift, actionTime);
                ImageLoadUtils.displayImage(mContext, item.getGift_img(), (ImageView) helper.getView(R.id.ivSendGiftIcon));
//                StyleBuilder giftSb = new StyleBuilder();
//                String gNick = mContext.getString(R.string.quotes, item.getTo_uid_nick());
//                giftSb.addTextStyle(mContext.getString(R.string.dynamic_send_a_gift, item.getGift_name())).commit()
//                        .addTextStyle(gNick).textColor(mContext.getResources().getColor(R.color.color_4B64FF)).commit();
//                giftSb.show((TextView) helper.getView(R.id.tvGiftAction));
                helper.addOnClickListener(R.id.ivOperation);
                break;

            case COMMENT_NONE_IMG:
                actionTime = mContext.getString(R.string.publish_comment, actionTime);
                ImageLoadUtils.displayImage(mContext, item.getImg_url(), (ImageView) helper.getView(R.id.ivVideo));
                helper.setText(R.id.tvDes, item.getDes());
                if (!TextUtils.isEmpty(item.getContent())) {
                    helper.setVisible(R.id.tvContent, true);
                    helper.setText(R.id.tvContent, item.getContent());
                } else {
                    helper.setVisible(R.id.tvContent, false);
                }
                helper.addOnClickListener(R.id.ivOperation);
                helper.getView(R.id.ivVideo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                break;

            case COMMENT_WITH_IMG:
                actionTime = mContext.getString(R.string.publish_comment, actionTime);
                ImageLoadUtils.displayImage(mContext, item.getImg_url(), (ImageView) helper.getView(R.id.ivVideo));
                RecyclerView recyclerView = helper.getView(R.id.rvCommentImg);
                String[] a = item.getImg_urls().split(",");
                List<String> imgs = new ArrayList<>();
                Collections.addAll(imgs, a);
                setCommentImgList(recyclerView, imgs);
                helper.setText(R.id.tvDes, item.getDes());
                if (!TextUtils.isEmpty(item.getContent())) {
                    helper.setText(R.id.tvContent, item.getContent());
                } else {
                    helper.setVisible(R.id.tvContent, false);
                }
                helper.getView(R.id.ivVideo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;

            case Constants.BAISHI:
                actionTime = mContext.getString(R.string.dynamic_from_master, actionTime);
                helper.setText(R.id.tvBaishiCost, mContext.getString(R.string.dynamic_master_cost, item.getCost()));
                helper.setText(R.id.tvBaishiAction, mContext.getString(R.string.dynamic_master_from, item.getNick()));
                ImageLoadUtils.setSimpleCircleHeadIcon(mContext, item.getHead(), NONE_IMG, (ImageView) helper.getView(R.id.ivMasterHead));
                helper.getView(R.id.ivMasterHead).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
        }

        helper.setText(R.id.tvAction, actionTime);
        helper.setTag(R.id.ivOperation, item);
        helper.addOnClickListener(R.id.ivOperation);
    }

    /**
     * 设置动态评论图片
     *
     * @param recyclerView
     * @param imgList
     */
    private void setCommentImgList(RecyclerView recyclerView, List<String> imgList) {
        if (imgList != null) {
            return;
        }
//        GridLayoutManager gridManager = new GridLayoutManager(mContext, 4);
//        recyclerView.setLayoutManager(gridManager);
//        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
//        dividerLine.setSize(DipUtil.dipToPixels(9));
//        recyclerView.addItemDecoration(dividerLine);
//        dividerLine.setColor(R.color.white);
//        recyclerView.setAdapter(adapter);
    }
}
