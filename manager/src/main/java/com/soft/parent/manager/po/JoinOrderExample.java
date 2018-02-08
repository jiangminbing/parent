package com.soft.parent.manager.po;

import java.util.ArrayList;
import java.util.List;

public class JoinOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer begin;

    protected Integer length;

    public JoinOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setBegin(Integer begin) {
        this.begin=begin;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setLength(Integer length) {
        this.length=length;
    }

    public Integer getLength() {
        return length;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andJoinOrderIdIsNull() {
            addCriterion("join_order_id is null");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdIsNotNull() {
            addCriterion("join_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdEqualTo(Integer value) {
            addCriterion("join_order_id =", value, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdNotEqualTo(Integer value) {
            addCriterion("join_order_id <>", value, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdGreaterThan(Integer value) {
            addCriterion("join_order_id >", value, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_order_id >=", value, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdLessThan(Integer value) {
            addCriterion("join_order_id <", value, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("join_order_id <=", value, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdIn(List<Integer> values) {
            addCriterion("join_order_id in", values, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdNotIn(List<Integer> values) {
            addCriterion("join_order_id not in", values, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("join_order_id between", value1, value2, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("join_order_id not between", value1, value2, "joinOrderId");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberIsNull() {
            addCriterion("join_order_number is null");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberIsNotNull() {
            addCriterion("join_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberEqualTo(String value) {
            addCriterion("join_order_number =", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberNotEqualTo(String value) {
            addCriterion("join_order_number <>", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberGreaterThan(String value) {
            addCriterion("join_order_number >", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("join_order_number >=", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberLessThan(String value) {
            addCriterion("join_order_number <", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("join_order_number <=", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberLike(String value) {
            addCriterion("join_order_number like", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberNotLike(String value) {
            addCriterion("join_order_number not like", value, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberIn(List<String> values) {
            addCriterion("join_order_number in", values, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberNotIn(List<String> values) {
            addCriterion("join_order_number not in", values, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberBetween(String value1, String value2) {
            addCriterion("join_order_number between", value1, value2, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberNotBetween(String value1, String value2) {
            addCriterion("join_order_number not between", value1, value2, "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdsIsNull() {
            addCriterion("order_ids is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdsIsNotNull() {
            addCriterion("order_ids is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdsEqualTo(String value) {
            addCriterion("order_ids =", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsNotEqualTo(String value) {
            addCriterion("order_ids <>", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsGreaterThan(String value) {
            addCriterion("order_ids >", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsGreaterThanOrEqualTo(String value) {
            addCriterion("order_ids >=", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsLessThan(String value) {
            addCriterion("order_ids <", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsLessThanOrEqualTo(String value) {
            addCriterion("order_ids <=", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsLike(String value) {
            addCriterion("order_ids like", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsNotLike(String value) {
            addCriterion("order_ids not like", value, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsIn(List<String> values) {
            addCriterion("order_ids in", values, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsNotIn(List<String> values) {
            addCriterion("order_ids not in", values, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsBetween(String value1, String value2) {
            addCriterion("order_ids between", value1, value2, "orderIds");
            return (Criteria) this;
        }

        public Criteria andOrderIdsNotBetween(String value1, String value2) {
            addCriterion("order_ids not between", value1, value2, "orderIds");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Integer value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Integer value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Integer value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Integer value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Integer value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Integer> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Integer> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Integer value1, Integer value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andJoinOrderNumberLikeInsensitive(String value) {
            addCriterion("upper(join_order_number) like", value.toUpperCase(), "joinOrderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderIdsLikeInsensitive(String value) {
            addCriterion("upper(order_ids) like", value.toUpperCase(), "orderIds");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}