package pkanimation.xly.com.brvahcircledemo.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by xuleyuan on 2017/8/29
 */

public class DynamicsModel implements  MultiItemEntity {

    private int action;
    private int itemType;
    private long action_time;
    private int vid; //,
    private String des; //,
    private String img_url; //,
    private String ain_img; //,
    private String play_url; //,
    private int gain_cid; //,
    private String gain_content; //,
    private String gift_img; //,
    private int uid; //,
    private String uid_nick; //,
    private int to_uid; //,
    private String to_uid_nick; //,
    private String gift_name; //
    private int cid; //,
    private String content; //,
    private String img_urls; //
    private String days; //,
    private String head; //,
    private String nick; //,
    private int master_uid; //,
    private int cost; //
    private String gain_img; //

    public void setAction(int action) {
        this.action = action;
    }

    public void setAction_time(long action_time) {
        this.action_time = action_time;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setAin_img(String ain_img) {
        this.ain_img = ain_img;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }

    public void setGain_cid(int gain_cid) {
        this.gain_cid = gain_cid;
    }

    public void setGain_content(String gain_content) {
        this.gain_content = gain_content;
    }

    public void setGift_img(String gift_img) {
        this.gift_img = gift_img;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUid_nick(String uid_nick) {
        this.uid_nick = uid_nick;
    }

    public void setTo_uid(int to_uid) {
        this.to_uid = to_uid;
    }

    public void setTo_uid_nick(String to_uid_nick) {
        this.to_uid_nick = to_uid_nick;
    }

    public void setGift_name(String gift_name) {
        this.gift_name = gift_name;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImg_urls(String img_urls) {
        this.img_urls = img_urls;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setMaster_uid(int master_uid) {
        this.master_uid = master_uid;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getGain_img() {
        return gain_img;
    }

    public void setGain_img(String gain_img) {
        this.gain_img = gain_img;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getAction() {
        return action;
    }

    public long getAction_time() {
        return action_time;
    }

    public int getVid() {
        return vid;
    }

    public String getDes() {
        if (des == null)
            return "";
        return des;
    }

    public String getImg_url() {
        if (img_url == null)
            return "";
        return img_url;
    }

    public String getAin_img() {
        return ain_img;
    }

    public String getPlay_url() {
        return play_url;
    }

    public int getGain_cid() {
        return gain_cid;
    }

    public String getGain_content() {
        return gain_content;
    }

    public String getGift_img() {
        return gift_img;
    }

    public int getUid() {
        return uid;
    }

    public String getUid_nick() {
        return uid_nick;
    }

    public int getTo_uid() {
        return to_uid;
    }

    public String getTo_uid_nick() {
        return to_uid_nick;
    }

    public String getGift_name() {
        return gift_name;
    }

    public int getCid() {
        return cid;
    }

    public String getContent() {
        if (content == null)
            return "";
        return content;
    }

    public String getImg_urls() {
        return img_urls;
    }

    public String getDays() {
        return days;
    }

    public String getHead() {
        return head;
    }

    public String getNick() {
        if (nick == null)
            return "";
        return nick;
    }

    public int getMaster_uid() {
        return master_uid;
    }

    public int getCost() {
        return cost;
    }
}
