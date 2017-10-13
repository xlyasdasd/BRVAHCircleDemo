package pkanimation.xly.com.brvahcircledemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

import pkanimation.xly.com.brvahcircledemo.adapter.DynamicsAdapter;
import pkanimation.xly.com.brvahcircledemo.constants.Constants;
import pkanimation.xly.com.brvahcircledemo.model.DynamicsModel;

public class MainActivity extends BaseActivity {

    DynamicsAdapter adapter;
    private RecyclerView recyclerView;
    private List<DynamicsModel> dynamicsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dynamicsModels = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rvDynamics);
        adapter = new DynamicsAdapter(dynamicsModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        fetchData(data);

    }
    /**
     * 获取数据操作
     * @param data
     */
    private void fetchData(String data) {
        List<DynamicsModel> dynamicsModels = JSON.parseArray(data, DynamicsModel.class);
        onGetData(dynamicsModels);
    }
    /**
     * 拿到数据的处理
     * @param dynamicsModelList
     */
    private void onGetData(List<DynamicsModel> dynamicsModelList) {

        for (int i = 0; i < dynamicsModelList.size(); i++) {///遍历所有的数据
            DynamicsModel dynamicsModel = dynamicsModelList.get(i);
            if (dynamicsModel.getAction() == Constants.COMMENT) { // 如果是评论类型的数据，要看是否有图片区分一下布局，这是因为后台没给我区分
                if (TextUtils.isEmpty(dynamicsModel.getImg_urls())) {//如果这个评论没有图片地址
                    dynamicsModel.setItemType(Constants.COMMENT_NONE_IMG);//自己定义没有图片类型的布局
                } else {
                    dynamicsModel.setItemType(Constants.COMMENT_WITH_IMG);//自己定义有图片类型的布局
                }
            } else {//普通动态直接填入后台数据类型
                dynamicsModel.setItemType(dynamicsModel.getAction());
            }
        }
        dynamicsModels.addAll(dynamicsModelList);
        adapter.notifyDataSetChanged();

    }
    /**
     * 这是网络数据
     */
    private String data = "[{\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1506075300,\n" +
            "\t\t\"cid\": 2016,\n" +
            "\t\t\"content\": \"采购订单\",\n" +
            "\t\t\"des\": \"u0090mF9CQX-mp4\",\n" +
            "\t\t\"img_url\": \"http://ouo48szbk.bkt.clouddn.com/160175211281383424\",\n" +
            "\t\t\"img_urls\": \"\",\n" +
            "\t\t\"vid\": 149323\n" +
            "\t}, {\n" +
            "\t\t\"action\": 6,\n" +
            "\t\t\"action_time\": 1505979588,\n" +
            "\t\t\"cost\": 0,\n" +
            "\t\t\"days\": 31,\n" +
            "\t\t\"head\": \"http://image.52doushi.com/static/image/56/90/851903_1481543817044.jpg\",\n" +
            "\t\t\"master_uid\": 851903,\n" +
            "\t\t\"nick\": \"十万个女密码\"\n" +
            "\t}, {\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1506667882,\n" +
            "\t\t\"cid\": 5034,\n" +
            "\t\t\"content\": \"啥也不说\",\n" +
            "\t\t\"des\": \"日式游戏有特“色” 扒衣老司机入侵秋叶原\",\n" +
            "\t\t\"img_url\": \"http://qnimage.52doushi.com/2038419/1502245600061/cover\",\n" +
            "\t\t\"img_urls\": \"http://ouo48szbk.bkt.clouddn.com/2191731/1506668856427,http://ouo48szbk.bkt.clouddn.com/2191731/1506668050915,http://ouo48szbk.bkt.clouddn.com/2191731/1506668837176\",\n" +
            "\t\t\"vid\": 137011\n" +
            "\t},{\n" +
            "\t\t\"action\": 6,\n" +
            "\t\t\"action_time\": 1505979319,\n" +
            "\t\t\"cost\": 0,\n" +
            "\t\t\"days\": 31,\n" +
            "\t\t\"head\": \"http://image.52doushi.com/static/image/53/32/1271907_1490848023628.jpg\",\n" +
            "\t\t\"master_uid\": 1271907,\n" +
            "\t\t\"nick\": \"快厨房InstaChef\"\n" +
            "\t}, {\n" +
            "\t\t\"action\": 6,\n" +
            "\t\t\"action_time\": 1505979240,\n" +
            "\t\t\"cost\": 0,\n" +
            "\t\t\"days\": 31,\n" +
            "\t\t\"head\": \"http://image.52doushi.com/static/image/00/00/12_1490770803370.jpg\",\n" +
            "\t\t\"master_uid\": 1268406,\n" +
            "\t\t\"nick\": \"涛哥测评\"\n" +
            "\t}, {\n" +
            "\t\t\"action\": 3,\n" +
            "\t\t\"action_time\": 1505878018,\n" +
            "\t\t\"des\": \"中国的山寨货是如何碾压世界的？\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/85/25/1916117_1499753673621.jpg\",\n" +
            "\t\t\"vid\": 126881\n" +
            "\t}, {\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1505806501,\n" +
            "\t\t\"cid\": 1002,\n" +
            "\t\t\"content\": \"ll\",\n" +
            "\t\t\"des\": \"头顶青天烧脑无边\",\n" +
            "\t\t\"img_url\": \"http://ouo48szbk.bkt.clouddn.com/首页精选/13.png\",\n" +
            "\t\t\"img_urls\": \"\",\n" +
            "\t\t\"vid\": 130381\n" +
            "\t}, {\n" +
            "\t\t\"action\": 3,\n" +
            "\t\t\"action_time\": 1505806295,\n" +
            "\t\t\"des\": \"我为什么不劝分手 2-5\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/12/25/851903_1495021068509.jpg\",\n" +
            "\t\t\"vid\": 103821\n" +
            "\t}, {\n" +
            "\t\t\"action\": 3,\n" +
            "\t\t\"action_time\": 1505806271,\n" +
            "\t\t\"des\": \"你的男朋友是同性恋吗\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/99/43/851903_1495867268182.jpg\",\n" +
            "\t\t\"vid\": 108038\n" +
            "\t}, {\n" +
            "\t\t\"action\": 3,\n" +
            "\t\t\"action_time\": 1505806265,\n" +
            "\t\t\"des\": \"你的男朋友是同性恋吗\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/99/43/851903_1495867268182.jpg\",\n" +
            "\t\t\"vid\": 108038\n" +
            "\t}, {\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1505804014,\n" +
            "\t\t\"cid\": 4006,\n" +
            "\t\t\"content\": \"你\",\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"img_urls\": \"\",\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1505804008,\n" +
            "\t\t\"cid\": 3008,\n" +
            "\t\t\"content\": \"贵\",\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"img_urls\": \"\",\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1505804001,\n" +
            "\t\t\"cid\": 5003,\n" +
            "\t\t\"content\": \"薛\",\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"img_urls\": \"\",\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803980,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 4005,\n" +
            "\t\t\"gain_content\": \"不想说什么\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505804455467\",\n" +
            "\t\t\"gvid\": 5004,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505804314086\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803930,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 5,\n" +
            "\t\t\"gain_content\": \"德国哈哈表现女性患白血病细胞的那些性能表\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505804621377\",\n" +
            "\t\t\"gvid\": 4004,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505803975909\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803722,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 3007,\n" +
            "\t\t\"gain_content\": \"德国哈哈表现女性患白血病细胞的那些性能表d n\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505803997720\",\n" +
            "\t\t\"gvid\": 5003,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505804492831\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803711,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 3006,\n" +
            "\t\t\"gain_content\": \"德国哈哈表现女性患白血病细胞的那些性能表s b bsb s b z b zna\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505804117451\",\n" +
            "\t\t\"gvid\": 5002,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505803775127\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803709,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 2015,\n" +
            "\t\t\"gain_content\": \"德国哈哈表现女性患白血病细胞的那些性能表s b bsb s b z b zna\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505803912231\",\n" +
            "\t\t\"gvid\": 4003,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505803900471\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803701,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 2014,\n" +
            "\t\t\"gain_content\": \"德国哈哈b x n x h b\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505804608143\",\n" +
            "\t\t\"gvid\": 3004,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505803736381\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803675,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 2013,\n" +
            "\t\t\"gain_content\": \"德国哈哈\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505803959443\",\n" +
            "\t\t\"gvid\": 3003,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 0,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505803779029\",\n" +
            "\t\t\"reply_count\": 0,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}, {\n" +
            "\t\t\"action\": 5,\n" +
            "\t\t\"action_time\": 1506570283,\n" +
            "\t\t\"cid\": 2028,\n" +
            "\t\t\"content\": \"好想继续看细节\",\n" +
            "\t\t\"des\": \"佟丽娅变身女学霸带你玩转生命科学\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/81/26/1916117_1499399830380.jpg\",\n" +
            "\t\t\"img_urls\": \"http://ouo48szbk.bkt.clouddn.com/2194720/1506570737592,http://ouo48szbk.bkt.clouddn.com/2194720/1506570958212\",\n" +
            "\t\t\"vid\": 125677\n" +
            "\t}, {\n" +
            "\t\t\"action\": 2,\n" +
            "\t\t\"action_time\": 1505803658,\n" +
            "\t\t\"des\": \"男人为什么都爱网红脸？2-8\",\n" +
            "\t\t\"gain_cid\": 3005,\n" +
            "\t\t\"gain_content\": \"德国哈哈\",\n" +
            "\t\t\"gain_img\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505804322257\",\n" +
            "\t\t\"gvid\": 2001,\n" +
            "\t\t\"head\": \"http://ouo48szbk.bkt.clouddn.com/2191728/1505808722550\",\n" +
            "\t\t\"img_url\": \"http://image.52doushi.com/static/image/13/46/851903_1495108376759.jpg\",\n" +
            "\t\t\"like_count\": 1,\n" +
            "\t\t\"like_flag\": 0,\n" +
            "\t\t\"nick\": \"萌萌哒\",\n" +
            "\t\t\"play_url\": \"http://ouo4fr79u.bkt.clouddn.com/2191728/1505804240823\",\n" +
            "\t\t\"reply_count\": 3,\n" +
            "\t\t\"uid\": 2191728,\n" +
            "\t\t\"vid\": 104319\n" +
            "\t}]";
}
