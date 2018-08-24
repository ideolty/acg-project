package me.blog.acg.commons;

import java.util.List;

/**
 * 分页搜索的结果bean
 *
 */
public class AdminQueryResult<T> {
	private Long total;
	private List<T> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
