package com.soft.parent.basic.result;

/**
 * @Author jiangmb
 * @Time 2018/1/19.
 * 各模块统一定义返回参数
 */
public class DetailResult<T> extends Result {

	/**
	 * 定义返回值类型
	 */
	private T data;

	public DetailResult() {
		super();
	}

	public DetailResult(ResCode resCode) {
		super(resCode);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
