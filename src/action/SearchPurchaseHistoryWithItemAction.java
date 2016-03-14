package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.SearchPurchaseHistoryWithItemDAO;
import dto.AdminPurchaseHistoryDTO;

/**
 * 購入履歴を商品名から検索し表示させるアクションクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 *
 */
public class SearchPurchaseHistoryWithItemAction extends ActionSupport implements SessionAware{

	/**
	 * 検索された商品名
	 */
	private String itemName;

	/**
	 * セッション
	 */
	private Map<String,Object>session;

	/**
	 * 購入履歴一覧を格納するリスト
	 */
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();

	/**
	 * 検索された注文日に関連する購入履歴一覧を、ramenデータベースのhistoryテーブルから取得するメソッド
	 * @return res 未ログインの場合resにloginErrorを格納、検索された商品名と購入履歴を照合し、関連する購入履歴を取得できたらリストに格納し、resにSUCCESSを格納、取得できなかったらresにERRORを格納、resを返します。
	 */
	public String execute(){

		String res="error";
		SearchPurchaseHistoryWithItemDAO dao = new SearchPurchaseHistoryWithItemDAO();
		if(dao.selectItemName(itemName)){
			setHistoryList(dao.getHistoryList());
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
	 * 検索された商品名を取得するメソッド
	 * @return itemName 検索された商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 検索された商品名を格納するメソッド
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
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

}
