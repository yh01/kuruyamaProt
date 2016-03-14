package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminLoginDAO;

/**
 * 管理者ログインするアクションクラス
 * @author TAKESHI BANSHOU
 * @version 1.0
 * @since 1.0
 */
public class AdminLoginAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 4664884338102350731L;

    /**
     * 管理者ID
     */
    private String adminId;

    /**
     * パスワード
     */
    private String password;

    /**
     * セッション
     */
    private Map<String,Object>session;

    /**
     * 検索結果判別のメソッドを格納するための変数
     */
    private boolean res;

    /**
     * 入力された値を条件にopenconnectデータベース内adminテーブルを検索し、検索結果が有るかどうかを判別するメソッド
     * @return SUCCESS/ERROR データベースに入力した値が存在する場合にSUCCESSを返します。存在しない時にERRORを返します。
     */
    public String execute(){
        AdminLoginDAO dao = new AdminLoginDAO();
        res = dao.check(adminId,password);
        if(!res){
            return ERROR;
        }
        session.put("adminId", adminId);
        return SUCCESS;
    }

    /**
     * 管理者IDを取得するメソッド
     * @return adminId 管理者ID
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * 管理者IDを格納するメソッド
     * @param adminId 管理者ID
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * パスワードを取得するメソッド
     * @return password パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを格納するメソッド
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
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