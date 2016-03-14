package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * セッション情報を削除しログイン画面に遷移するアクションクラス
 * @author TAKESHI BANSHOW
 * @version 1.0
 * @since 1.0
 **/
public class AdminLogoutAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -4660046986057292904L;
    /**
     * セッション
     */
    private Map<String,Object>session;

    /**
     * セッション情報を削除し管理者ログインに遷移させる為のメソッド
     * @return SUCCESS 常にSUCCESSを返します。
     */
    public String execute(){
        session.clear();
        return SUCCESS;
    }

    /**
     * セッションを取得するメソッド
     * @return session セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
