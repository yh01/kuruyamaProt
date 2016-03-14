package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.SearchPurchaseHistoryWithUserDAO;
import dto.AdminPurchaseHistoryDTO;

/**
 * 購入履歴をユーザーIDから検索し表示させるアクションクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 *
 */
public class SearchPurchaseHistoryWithUserAction extends ActionSupport implements SessionAware{

	/**
	 * 検索されたユーザーID
	 */
	private int userId;

	/**
	 * セッション
	 */
	private Map<String,Object>session;

	/**
	 * 購入履歴一覧を格納するリスト
	 */
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();

	/**
	 * 検索されたユーザーIDに関連する購入履歴一覧を、ramenデータベースのhistoryテーブルから取得するメソッド
	 * @return res 未ログインの場合resにloginErrorを格納、検索されたユーザーIDと購入履歴を照合し、関連する購入履歴を取得できたらリストに格納し、resにSUCCESSを格納、取得できなかったらresにERRORを格納、resを返します。
	 */
	public String execute(){
		String res="error";
		SearchPurchaseHistoryWithUserDAO dao = new SearchPurchaseHistoryWithUserDAO();
		boolean selectUser = dao.selectUserId(userId);
		if(selectUser){
			historyList = dao.getHistoryList();
			res = "success";
		}
		/*
		if(!session.containsKey("adminId")){
			res = "loginError";
		}
		*/

		return res;
	}

	/**
	 * セッションを取得するメソッド
	 * @return
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
	 * 購入履歴一覧を取得するメソッド
	 * @return historyList 購入履歴一覧のリスト
	 */
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}

	/**
	 * 購入履歴一覧を格納するメソッド
	 * @param historyList
	 */
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}

	/**
	 * 検索されたユーザーIDを取得するメソッド
	 * @return userId 検索されたユーザーID
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 検索されたユーザーIDを格納するメソッド
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
