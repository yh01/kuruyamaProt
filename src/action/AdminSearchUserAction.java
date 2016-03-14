package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminSearchUserDAO;
import dto.AdminUserDTO;

/**
 * ユーザーの検索を行うクラス
 * @author KAZUHIRO YOSHIHARA
 * @since 1.0
 * @version 1.0
 */
public class AdminSearchUserAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -3871345004062036185L;

    /**
     * ユーザーの検索条件
     */
    public String userName;

    /**
     * ユーザー一覧のリスト
     */
    private ArrayList< AdminUserDTO> userList = new ArrayList<>();

    /**
     * セッション
     */
    private Map<String,Object>session;

    /**
     * openconnectデータベースのuserテーブルから検索条件に一致した<br>
     * ユーザー情報を取得し、リストに格納するメソッド
     * @return SUCCESS/ERROR 成功した場合にSUCCESS、失敗した場合にERRORを返します。
     */
    public String execute(){
        if(!session.containsKey("adminId")){
            return ERROR;
        }
        AdminSearchUserDAO dao = new AdminSearchUserDAO();
        userList=dao.searchUser(userName);
        if(userList.isEmpty()){
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * 検索するユーザー名を取得するメソッド
     * @return userName 検索するユーザー名
     */
    public String getId(){
        return userName;
    }

    /**
     * 検索するユーザー名を格納するメソッド
     * @param userName 検索するユーザー名
     */
    public void setId(String userName){
        this.userName = userName;
    }

    /**
     * ユーザーのリストを取得する為のメソッド
     * @return userList ユーザーのリスト
     */
    public ArrayList<AdminUserDTO> getUserList() {
        return userList;
    }

    /**
     * ユーザーのリストを格納する為のメソッド
     * @param userList ユーザーのリスト
     */
    public void setuserList(ArrayList<AdminUserDTO> userList) {
        this.userList = userList;
    }

    /**
     * セッションを取得するメソッド
     * @return セッション
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