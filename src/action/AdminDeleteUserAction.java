package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDeleteUserDAO;

/**
 * ユーザーを削除するためのアクションクラス
 * @author KAZUHIRO YOASHIHARA
 * @since 1.0
 * @version 1.0
 */
public class AdminDeleteUserAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 6069481709682626931L;

    /**
     * 削除するユーザーのID
     */
    public String id;

    /**
     * セッション
     */
    private Map<String,Object>session;

    /**
     * ユーザーを削除するDAOクラスのインスタンス
     */
    AdminDeleteUserDAO dao = new AdminDeleteUserDAO();

    /**
     * openconnectデーターベースのuserテーブルからユーザーの削除を行うメソッド
     * @return SUCCESS/ERROR/LOGINERROR 削除件数が1件以上の場合はSUCCESS、0件の場合はERROR、未ログインの場合にLOGINERRORを返します。
     */
    public String execute(){
        if(!session.containsKey("adminId")){
            return "LOGINERROR";
        }
        int count = dao.delete(Integer.parseInt(id));
        if(count != 0){
            return SUCCESS;
            }
        return ERROR;
    }

    /**
     * 削除するユーザーのIDを取得するメソッド
     * @return id 削除するユーザーのID
     */
    public String getId(){
      return id;
    }

    /**
     * 削除するユーザーのIDを格納するメソッド
     * @param id 削除するユーザーのID
     */
    public void setId(String id){
      this.id = id;
    }

    /**セッションを取得するメソッド
     * @return  session セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**セッションを格納するメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}