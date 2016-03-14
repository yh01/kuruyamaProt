package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminGoEditProductDAO;
import dto.AdminItemDTO;

/**
 *  商品管理画面に推移する為のアクションクラス
 * @author HARUKI NAKAGAWA
 * @version 1.0
 * @since 1.0
 */
public class AdminGoEditProductAction extends ActionSupport implements SessionAware{

	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 5909136720738028727L;

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 商品情報リスト
	 */
	private ArrayList<AdminItemDTO> list = new ArrayList<AdminItemDTO>();

	/**
	 * ramenデータベースのrmen_itemテーブルの情報を取得するためのメソッド
	 * @return SUCCESS/ERROR 取得に成功した場合はSUCCESS、失敗した場合はERRORを返します。
	 */
	public String execute(){
		if(!session.containsKey("adminId")){
			return ERROR;
		}
		AdminGoEditProductDAO dao = new  AdminGoEditProductDAO();
		if(dao.selectMySQL()){
			list = dao.getSelectList();
			return SUCCESS;
		}
		return ERROR;
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
	 * 商品情報リストを取得するためのメソッド
	 * @return list リスト
	 */
	public ArrayList<AdminItemDTO> getList() {
		return list;
	}

	/**
	 * 商品情報リストを格納するためのメソッド
	 * @param list リスト
	 */
	public void setList(ArrayList<AdminItemDTO> list) {
		this.list = list;
	}
}
