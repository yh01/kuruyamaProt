package action;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminGoInquiryDAO;
import dto.AdminGoInquiryDTO;

/**
 * お問い合わせ情報を取得するアクションクラス
 * @author TAKESHI BANSHOU
 * @version 1.0
 * @since 1.0
 */
public class AdminGoInquiryAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 5611929963955584523L;

    /**
     * セッション
     */
    private Map<String,Object>session;

    /**
     * お問い合わせ情報リスト
     */
    private ArrayList<AdminGoInquiryDTO> formList;

    /**
     * セッションにadminIdが存在するかどうかを確認し、
     * ramenデータベースのformテーブルからお問い合わせ情報を取得する為のメソッド
     * @return SUCCESS/ERROR お問い合わせ情報を取得できたらSUCCESS、未ログインの場合はERRORを返します。
     * @throws UnknownHostException mongoDBに接続できない場合にスローされます。
     */
    public String execute() throws UnknownHostException{
        if(!session.containsKey("adminId")){
            return ERROR;
        }
        AdminGoInquiryDAO dao = new AdminGoInquiryDAO();
        formList = dao.select();
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

    /**
     * お問い合わせ情報リストを取得するメソッド
     * @return formList お問い合わせ情報リスト
     */
    public ArrayList<AdminGoInquiryDTO> getFormList() {
        return formList;
    }

    /**
     * お問い合わせ情報リストを格納するメソッド
     * @param formList お問い合わせ情報リスト
     */
    public void setFormList(ArrayList<AdminGoInquiryDTO> formList) {
        this.formList = formList;
    }
}