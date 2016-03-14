package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminGoEditUserDAO;
import dto.AdminUserDTO;

/**
 * ユーザー一覧を作成しユーザ編集に遷移するためのアクションクラス
 * @author KAZUHIRO YOSHIHARA
 * @since 1.0
 * @version 1.0
 */
public class AdminGoEditUserAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -5885353247207367329L;

    /**
     * ユーザー一覧のリスト
     */
    private ArrayList< AdminUserDTO> userList = new ArrayList<>();

    /**
     * セッション
     */
    private Map<String,Object>session;

    /**
     * openconnectデーターベースのuserテーブルからユーザー一覧を取得するメソッド
     * @return SUCCESS/ERROR データを取得できたら、リストに格納をしてSUCCESSを返し、セッションにadminIdが存在しない場合LOGINERRORを返します。
     */
    public String execute(){
        if(!session.containsKey("adminId")){
            return ERROR;
        }
        AdminGoEditUserDAO dao = new AdminGoEditUserDAO();
        if(dao.selectAllUserData()){
            userList = dao.getUserList();
        }
        return SUCCESS;
    }

    /**
     * ユーザー一覧のリストを格納する為のメソッド
     * @return userList ユーザー一覧のリスト
     */
    public ArrayList<AdminUserDTO> getUserList() {
        return userList;
    }

    /**
     * ユーザー一覧のリストを格納する為のメソッド
     * @param userList ユーザー一覧のリスト
     */
    public void setuserList(ArrayList<AdminUserDTO> userList) {
        this.userList = userList;
    }

    /**セッションを取得するメソッド
     * @return session セッション
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
