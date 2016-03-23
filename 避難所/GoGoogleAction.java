package com.internousdevwork.kuruyama.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.internousdevwork.kuruyama.util.GoogleOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Googleのログイン画面へ遷移する為のアクションクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class GoGoogleAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -8512143518893511699L;

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * GoogleでリクエストToken取得できるか確認するメソッド
	 * @return <p>SUCCESS/ERROR リクエストトークンが取得できた場合はSUCCESSを返し、<br>
	 *         取得できなかった場合はERRORを返します。</p>
	 */
	public String execute() {
		GoogleOauth googleOauth = new GoogleOauth();
		if(!googleOauth.getRequestToken(request,response)) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * レスポンスを格納するメソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * リクエストを格納するメソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}