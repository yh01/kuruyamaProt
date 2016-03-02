package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.SearchPurchaseHistoryWithDateDAO;
import dto.AdminPurchaseHistoryDTO;

public class SearchPurchaseHistoryWithDateAction extends ActionSupport implements SessionAware{
	private String purchaseDate = null;
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();
	private Map<String,Object>session;

	public String execute(){
		String res="error";
		SearchPurchaseHistoryWithDateDAO dao = new SearchPurchaseHistoryWithDateDAO();

		/*
		if(session.containsKey("adminId") && dao.selectSearchedDate(purchaseDate)){
			historyList = dao.getHistoryList();
			res = "success";
		}
		*/

		if(dao.selectSearchedDate(purchaseDate)){
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
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
