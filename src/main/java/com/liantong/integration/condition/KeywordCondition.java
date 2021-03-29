package com.liantong.integration.condition;

import com.liantong.integration.pojo.Keyword;
import indi.mybatis.flying.annotations.ConditionMapperAnnotation;
import indi.mybatis.flying.models.Conditionable;
import indi.mybatis.flying.models.Limitable;
import indi.mybatis.flying.models.Sortable;
import indi.mybatis.flying.statics.ConditionType;

import java.util.List;

/**
 * 关键字条件查询
 */
public class KeywordCondition extends Keyword implements Conditionable {

    private static final long serialVersionUID = 1L;

    private Limitable limiter;

    private Sortable sorter;

    @ConditionMapperAnnotation(dbFieldName = "bid", conditionType = ConditionType.EQUAL)
    private Integer bidEquals;

    public List<String> getBidIn() {
        return bidIn;
    }

    public void setBidIn(List<String> bidIn) {
        this.bidIn = bidIn;
    }

    @ConditionMapperAnnotation(dbFieldName = "bid", conditionType = ConditionType.IN)
    private List<String> bidIn;

    public String getNameHeadLike() {
        return nameHeadLike;
    }

    public void setNameHeadLike(String nameHeadLike) {
        this.nameHeadLike = nameHeadLike;
    }

    @ConditionMapperAnnotation(dbFieldName = "name", conditionType = ConditionType.HEAD_LIKE)
    private String nameHeadLike;

    public Limitable getLimiter() {
        return limiter;
    }

    public void setLimiter(Limitable limiter) {
        this.limiter = limiter;
    }

    public Sortable getSorter() {
        return sorter;
    }

    public void setSorter(Sortable sorter) {
        this.sorter = sorter;
    }

    public Integer getBidEquals() {
        return bidEquals;
    }

    public void setBidEquals(Integer bidEquals) {
        this.bidEquals = bidEquals;
    }
}
