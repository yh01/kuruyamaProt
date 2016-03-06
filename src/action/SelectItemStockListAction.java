package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.SelectItemStockListDAO;
import dto.SelectItemStockListDTO;

public class SelectItemStockListAction extends ActionSupport{
	public List<SelectItemStockListDTO> D3GraphList = new ArrayList<SelectItemStockListDTO>();
	public String execute(){
		SelectItemStockListDAO dao = new SelectItemStockListDAO();
		String result = SUCCESS;
		if(!dao.select()){
			return ERROR;
		}
		D3GraphList = dao.getD3GraphList();
		return result;
	}

	public List<SelectItemStockListDTO> getD3GraphList() {
		return D3GraphList;
	}
	public void setD3GraphList(List<SelectItemStockListDTO> d3GraphList) {
		D3GraphList = d3GraphList;
	}

}
