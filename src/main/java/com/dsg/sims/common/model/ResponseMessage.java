package com.dsg.sims.common.model;

import java.util.Map;
/**
 * 返回信息对象
 * author JieChen
 * createTime 3/15/16 5:13 PM
 */
public class ResponseMessage {

    /**
     * 状态
     */
    private int state;

    /**
     * 消息体
     */
    private Map<String,Object> messageBody;

    public ResponseMessage(int state, Map<String, Object> messageBody) {
        this.state = state;
        this.messageBody = messageBody;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Map<String, Object> getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Map<String, Object> messageBody) {
        this.messageBody = messageBody;
    }

}
