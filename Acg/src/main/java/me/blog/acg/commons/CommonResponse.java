package me.blog.acg.commons;

/**
 * 通用的返回信息，
 * 调用HTTP接口等统一的响应（返回）信息。
 *
 */
public class CommonResponse {

	public static final int SUCCESS_CODE = 1;
	public static final int FAIL_CODE_INLINE_MSG = 0;
	public static final int FAIL_CODE_POPUP_MSG = 2;
	public static final int FAIL_CODE_UNLOGIN = -1;

	/**状态 1-成功， 0-失败*/
	private int status;

	/**提示信息*/
	private String info;

	/**返回的数据*/
	private Object data;

	/**
	 * 默认构造函数。
	 */
	public CommonResponse() {

	}



	/**
	 * 指定返回数据的构造函数。
	 * @param status
	 * @param info
	 * @param data
	 */
	public CommonResponse(int status, String info, Object data) {
		this.status = status;
		this.info = info;
		this.data = data;
	}

	public CommonResponse(Object data){
		this.setData(data);
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

