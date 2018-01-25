package com.soft.parent.basic.result;

import java.io.Serializable;
import java.util.List;

/**
 * @Author jiangmb
 * @Time 2018/1/19.
 */
public class PageResult<T> extends Result implements Serializable{
    private static final long serialVersionUID = 1L;

	private Long total;

	private List<T> data;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public PageResult() {
		super();
	}

	public PageResult(ResCode resCode) {
		super(resCode);
	}
}
