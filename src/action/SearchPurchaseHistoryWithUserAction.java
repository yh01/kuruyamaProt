package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import dao.SearchPurchaseHistoryWithUserDAO;
import dto.AdminPurchaseHistoryDTO;

public class SearchPurchaseHistoryWithUserAction extends ActionSupport{
	private int userId;

	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();
	public String execute(){
		String res="error";
		SearchPurchaseHistoryWithUserDAO dao = new SearchPurchaseHistoryWithUserDAO();
		if(dao.selectUserId(userId)){
			historyList = dao.getHistoryList();
			res = "success";
		}
		return res;
	}
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
