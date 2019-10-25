package com.hao.xu.lang.score.entity;

import java.math.BigDecimal;

public class Score {

    public Score(String cid, BigDecimal score) {
        this.cid = cid;
        this.score = score;
    }

    public Score() {
    }

    private Integer sid;

    private String cid;

    private BigDecimal score;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }


}