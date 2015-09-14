package store.web;

public class ViewConstants {

	/**
	 * html
	 */
	public static final String MEDIA_TYPE_HTML = "text/html; charset=utf-8";

	/**
	 * json
	 */
	public static final String MEDIA_TYPE_JSON = "application/json; charset=utf-8";

	/**
	 * ajax
	 */
	public static final String STATUS = "status";

	/**
	 * ajax
	 */
	public static final String MSG = "msg";

	public static final String SUCCESS = "success";

	/**
	 * 
	 */
	public static final String EXP_REASON = "reason";

	/**
	 * 
	 */
	public static final String JSON_STATUS_OK = "{\"status\":1,\"success\":true}";

	/**
	 * 
	 */
	public static final String JSON_STATUS_NO = "{\"status\":0,\"success\":false}";

	/**
	 * 
	 */
	public static final int NO = 0;
	/**
	 * 
	 */
	public static final int OK = 1;

	/**
	 * 
	 */
	public static final String JSON_STATUS_NON_LOGIN = "{\"status\":0,\"msg\":\"non_login\",\"reason\":\"请您登陆后再进行相关操作！\"}";

	/**
	 * 
	 */
	public static final String BAD_REQUEST = "bad_request";

	public static final String UNKNOWN_ERROR = "Erro desconhecido";

	/**
	 * 
	 */
	public static final String ERROR_PAGE = "error";
}
