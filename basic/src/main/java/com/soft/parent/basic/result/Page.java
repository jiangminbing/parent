package com.soft.parent.basic.result;

import java.io.Serializable;

/**
 * @Author jiangmb
 * @Time 2018/1/19.
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
	/**
	 * 当前页数
	 */
	private Integer pageNo = 1;

	/**
	 * 每页多少条
	 */
	private Integer pageSize = 20;

	/**
	 * 从多少条开始 mysql分页传参
	 */
	private Integer begin = 0;

	/**
	 * 分页长度 mysql分页传参
	 */
	private Integer length;

	/**
	 * 总数据长度
	 */
	private int totalRecords;

	/**
	 * 总页数
	 */
	private int pageCount;

	public Page() {
		super();
	}

	/**
	 * 构造函数
	 * 
	 * @param pageNo
	 * @param pageSize
	 */
	public Page(Integer pageNo, Integer pageSize) {
		this.setPageNo(pageNo);
		this.setPageSize(pageSize);
	}

    /*
    * @return Page
    * 设置开始数和叶长度    *
    *  @param begin
	* @param length
    * */

    public static Page setPage(Integer begin,Integer length) throws Exception{
        if (begin==null||length==null){
            throw new Exception("参数错误");
        }
        Page page=new Page();
            page.setBegin(begin);
            page.setLength(length);
        return page;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo!=null&&pageNo > 1) {
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        }
    }


	public int getBegin() {
		this.begin = this.begin == 0 ? pageSize * (pageNo - 1) : this.begin;
		return begin;
	}

	public int getLength() {
		this.length = length == null ? this.pageSize : 20;
		return length;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		this.pageCount = (int) Math.floor((this.totalRecords * 1.0d) / getLength());
		if (this.totalRecords % this.length != 0) {
			this.pageCount++;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Page{" + "pageNo=" + pageNo + ", pageSize=" + pageSize + ", begin=" + begin + ", length=" + length
				+ ", totalRecords=" + totalRecords + ", pageCount=" + pageCount + '}';
	}

	public void setBegin(Integer begin) {
		if (begin != null && begin > -1) {
			this.begin = begin;
		} else {
			this.begin = 0;
		}
	}

	public void setLength(Integer length) {
		if (length != null) {
			this.length = length;
		} else {
			this.length = 10;
		}

	}
}
