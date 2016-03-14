package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminSearchItemDAO;
import dto.AdminItemDTO;
/**
 * 商品情報を商品名から検索するクラス
 * @author HARUKI NAKAGAWA
 * @version 1.0
 * @since 1.0
 */
public class AdminSearchItemAction extends ActionSupport implements SessionAware {

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 5758008504287026297L;

    /**
     * 戻り値を格納するための変数
     */
    private String result;

    /**
     *
     * 商品名
     */
    private String itemName;

    /**
     *セッション
     */
    private Map<String, Object>session;

    /**
     * 商品リスト
     */
    private ArrayList<AdminItemDTO> list = new ArrayList<AdminItemDTO>();

    /**
     * 商品情報を商品名をもとに検索、ramenデータベースのramen_itemsテーブルから取得し、検索結果を表示する為のメソッド
     * @return result 検索結果の表示に成功したらSUCCESS、失敗したらERRORを返す。
     * @throw データベース・アクセス・エラーに関する例外を出します。
     */
    public String execute()throws SQLException{
        result = ERROR;
        AdminSearchItemDAO dao = new AdminSearchItemDAO();
        if(dao.select(itemName)){
            list = dao.getSelectList();
            result = SUCCESS;
        }
        return result;
    }

    /**
     * 商品名を取得ためのメソッド
     * @return itemName 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納ためのメソッド
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * セッションを取得するためのメソッド
     * @return session セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するためのメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 商品リストを取得するためのメソッド
     * @return list 商品リスト
     */
    public ArrayList<AdminItemDTO> getList() {
        return list;
    }

    /**
     * 商品リストを格納するためのメソッド
     * @param list  商品リスト
     */
    public void setList(ArrayList<AdminItemDTO> list) {
        this.list = list;
    }

}
