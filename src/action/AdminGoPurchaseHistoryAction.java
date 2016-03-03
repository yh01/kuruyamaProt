package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminGoPurchaseHistoryDAO;
import dto.AdminPurchaseHistoryDTO;

/**
 * 購入履歴を表示させるアクションクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 */
/**
 * @author Yuki Hoshino
 * @since 1.0
 * @version 1.0
 */
public class AdminGoPurchaseHistoryAction extends ActionSupport implements SessionAware{

	/**
	 * 購入履歴一覧を格納するリスト
	 *
	 */
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();

	/**
	 * セッション
	 */
	private Map<String,Object>session;


	/**
	 * ramenデータベースのhistoryテーブルから購入履歴一覧を取得するメソッド
	 * @return res 未ログインの場合resにloginErrorを格納、データを取得できたらリストに格納し、resにSUCCESSを格納、取得できなかったらresにERRORを格納、resを返します。
	 */
	public String execute(){
		String res = "error";
		AdminGoPurchaseHistoryDAO dao = new AdminGoPurchaseHistoryDAO();

		if(!session.containsKey("adminId")){
			res = "loginError";
		}

		if(dao.selectAllHistoryData()){
			historyList = dao.getHistoryList();
			res = "success";
		}
		return res;
	}

	/**
	 * 購入履歴一覧を取得するメソッド
	 * @return historyList 購入履歴一覧のリスト
	 */
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}

	/**
	 * 購入履歴を格納するメソッド 購入履歴一覧のリスト
	 * @param historyList
	 */
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
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
