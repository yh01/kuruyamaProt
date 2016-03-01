package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminGoPurchaseHistoryDAO;
import dto.AdminGoPurchaseHistoryDTO;

public class AdminGoPurchaseHistoryAction extends ActionSupport{
	private ArrayList<AdminGoPurchaseHistoryDTO> historyList = new ArrayList<AdminGoPurchaseHistoryDTO>();
	public String execute(){
		String res=ERROR;
		AdminGoPurchaseHistoryDAO dao = new AdminGoPurchaseHistoryDAO();
		if(dao.selectAllHistoryData()){
			historyList = dao.getHistoryList();
			res = SUCCESS;
		}
		return res;
	}
	public ArrayList<AdminGoPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<AdminGoPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}
}
