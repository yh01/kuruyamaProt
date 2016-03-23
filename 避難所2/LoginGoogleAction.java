package com.internousdevwork.kuruyama.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.kuruyama.dao.CartDAO;
import com.internousdevwork.kuruyama.dao.LoginOauthDAO;
import com.internousdevwork.kuruyama.dto.LoginOauthDTO;
import com.internousdevwork.kuruyama.util.GoogleOauth;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Googleでログインする為のクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */
public class LoginGoogleAction extends ActionSupport implements SessionAware,ServletRequestAware{

	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -2061731425003625142L;

	/**
	 *  OAuthサービス元の名前を格納している変数
	 */
	static final String OAUTH_NAME = "google";

	/**
	 * リクエスト
	 */
	private HttpServletRequest request;

	/**
	 * セッションに保存する為の変数
	 */
	private Map<String, Object> session;

	/**
	 * Googleでログインできるか判定する為のメソッド
     * @return SUCCESS/ERROR <p>アクセストークンを取得した際にnullの場合、または初回ログイン時に<br>
	 *         テーブル(user)へのインサートに失敗した場合にERRORを返します。<br>
	 *         そうでなかった場合はSUCCESSを返し、ID、カート内の商品総数(id,<br>
	 *         sumOfCartItems)をセッションへ保存します。</p>
	 */
	public String execute(){
		GoogleOauth googleOauth = new GoogleOauth();
		Map<String, String> userMap = null;
		userMap = googleOauth.getAccessToken(request);
		if (userMap == null) {
			return ERROR;
		}
		String oauthId = userMap.get("id");
		String userName = userMap.get("name");
		String email = userMap.get("email");
		LoginOauthDAO dao = new LoginOauthDAO();
		if (dao.select(oauthId, OAUTH_NAME)) {
			LoginOauthDTO dto = dao.getLoginOauthDTO();
			int userId = dto.getId();
			session.put("id", dto.getId());
			CartDAO cartDao = new CartDAO();
			if(cartDao.selectSumOfCartItems(userId)<0){
				return ERROR;
			}
			int sumOfCartItems = cartDao.selectSumOfCartItems(userId);
			session.put("sumOfCartItems", sumOfCartItems);
			return SUCCESS;
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
	  *  セッションを格納するメソッド
	  *  @param session セッション
	  */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	 /**
	  * セッションを取得するメソッド
	  * @return session セッション
	  */
	public Map<String, Object> getSession() {
		return session;
	}

	 /**
	  * リクエストを取得するメソッド
	  * @param request リクエスト
	  */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}