package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.SearchPurchaseHistoryWithDateDAO;
import dto.AdminPurchaseHistoryDTO;

/**
 * 購入履歴を注文日から検索し表示させるアクションクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 *
 */
public class SearchPurchaseHistoryWithDateAction extends ActionSupport implements SessionAware{

	/**
	 * 検索された年
	 */
	private String year = null;

	/**
	 * 検索された月
	 */
	private String month = null;

	/**
	 * 検索された日
	 */
	private String day = null;

	/**
	 * 検索された注文日を格納する変数
	 */
	private String purchaseDate;

	/**
	 * 購入履歴一覧を格納するリスト
	 */
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();

	/**
	 * セッション
	 */
	private Map<String,Object>session;

	/**
	 * 検索された注文日に関連する購入履歴一覧を、ramenデータベースのhistoryテーブルから取得するメソッド
	 * @return res 未ログインの場合resにloginErrorを格納、検索された注文日と購入履歴を照合し、関連する購入履歴を取得できたらリストに格納し、resにSUCCESSを格納、取得できなかったらresにERRORを格納、resを返します。
	 */
	public String execute(){
		String res = ERROR;
		SearchPurchaseHistoryWithDateDAO dao = new SearchPurchaseHistoryWithDateDAO();
		purchaseDate = year + month + day;

		if(dao.selectSearchedDate(purchaseDate)){
			historyList = dao.getHistoryList();
			res = SUCCESS;
		}
		/*
		if(!session.containsKey("adminId")){
			res = "loginError";
		}
		*/

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
	 * 購入履歴一覧を格納するメソッド
	 * @param historyList
	 */
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
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
	 * 検索された年を取得するメソッド
	 * @return year 検索された年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 検索された年を格納するメソッド
	 * @param year 検索された年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 検索された月を取得するメソッド
	 * @return month 検索された月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 検索された月を格納するメソッド
	 * @param month 検索された月
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 検索された日を取得するメソッド
	 * @return day 検索された日
	 */
	public String getDay() {
		return day;
	}

	/**
	 * 検索された日を取得するメソッド
	 * @param day 検索された日
	 */
	public void setDay(String day) {
		this.day = day;
	}
}
