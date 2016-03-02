package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminGoPurchaseHistoryDAO;
import dto.AdminPurchaseHistoryDTO;

public class AdminGoPurchaseHistoryAction extends ActionSupport{
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();
	public String execute(){
		String res=ERROR;
		AdminGoPurchaseHistoryDAO dao = new AdminGoPurchaseHistoryDAO();
		if(dao.selectAllHistoryData()){
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
	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
}
