package com.nowcoder.community.entity;

import java.util.HashMap;
import java.util.Map;

public class Event {

    private String topic;//主题，时间类型
    private int userId;//事件触发的人
    private int entityType;//赞，评论，回复,实体类型
    private int entityId;//
    private int entityUserId;//实体作者
    private Map<String, Object> data = new HashMap<>();//存储额外的字段，封装到map

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {
        //通过返回this，可以连续set其他属性  setTopic().setUserId().……
        this.topic = topic;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Event setData(String key, Object value) {
        //可以连续调用
        this.data.put(key, value);
        return this;
    }

}
