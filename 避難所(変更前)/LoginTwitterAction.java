package com.internousdevwork.kuruyama.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.kuruyama.dao.CartDAO;
import com.internousdevwork.kuruyama.dao.LoginOauthDAO;
import com.internousdevwork.kuruyama.dto.LoginOauthDTO;
import com.internousdevwork.kuruyama.util.TwitterOauth;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Twitterでログインする為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */

public class LoginTwitterAction extends ActionSupport implements SessionAware, ServletRequestAware,ServletResponseAware{

	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 5267317856658763160L;

	/**
	 * OAuthサービス元の名前を格納している変数
	 */
	static final String OAUTH_NAME = "Twitter";

	/**
	 * レスポンス
	 */
	private HttpServletResponse response;

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * セッションに保存する為の変数
	 */
	public Map<String, Object> session;

	/**
	 * Twitterでログインできるか判定する為のメソッド
	 * @return SUCCESS/ERROR <p>アクセストークンを取得した際にnullの場合、または初回ログイン時に<br>
	 *         テーブル(user)へのインサートに失敗した場合にERRORを返します。<br>
	 *         そうでなかった場合はSUCCESSを返し、ID、カート内の商品総数(id,<br>
	 *         sumOfCartItems)をセッションへ保存します。</p>
	 */
	public String execute() {
		TwitterOauth twitterOauth = new TwitterOauth();
		String[] userData = new String[3];
		userData = twitterOauth.getAccessToken(request, response);
		if (userData == null) {
			return ERROR;
		}
		String oauthId = userData[0];
		String userName = userData[1];
		String email = userData[2];
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(oauthId, OAUTH_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			int userId = dto.getId();
			session.put("id", userId);
			CartDAO cartDao = new CartDAO();
			if(cartDao.selectSumOfCartItems(userId)<0){
				return ERROR;
			}
			int sumOfCartItems = cartDao.selectSumOfCartItems(userId);
			session.put("sumOfCartItems", sumOfCartItems);
		}
		if (!dao.insert(userName, email, oauthId, OAUTH_NAME)) {
			return ERROR;
		}
		dao.select(oauthId, OAUTH_NAME);
		LoginOauthDTO dto = dao.getLoginOauthDTO();
		session.put("id", dto.getId());
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

	/**
	 * セッションを格納するメソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * セッションを取得するメソッド
	 * @return Session セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}
}