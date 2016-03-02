package action;

import java.util.ArrayList;

import dao.SearchPurchaseHistoryWithItemDAO;
import dto.AdminPurchaseHistoryDTO;

public class SearchPurchaseHistoryWithItemAction {
	private String itemName;
	private ArrayList<AdminPurchaseHistoryDTO> historyList = new ArrayList<AdminPurchaseHistoryDTO>();
	public String execute(){
		String res="error";
		SearchPurchaseHistoryWithItemDAO dao = new SearchPurchaseHistoryWithItemDAO();
		if(dao.selectItemName(itemName)){
			setHistoryList(dao.getHistoryList());
			res = "success";
		}
		return res;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ArrayList<AdminPurchaseHistoryDTO> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(ArrayList<AdminPurchaseHistoryDTO> historyList) {
		this.historyList = historyList;
	}

}
