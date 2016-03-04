package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.D3SelectListDAO;
import dto.D3SelectListDTO;

public class D3SelectListAction extends ActionSupport{
	public List<D3SelectListDTO> D3GraphList = new ArrayList<D3SelectListDTO>();
	public String execute(){
		D3SelectListDAO dao = new D3SelectListDAO();
		String result = SUCCESS;
		if(!dao.select()){
			return ERROR;
		}
		D3GraphList = dao.getD3GraphList();
		return result;
	}

	public List<D3SelectListDTO> getD3GraphList() {
		return D3GraphList;
	}
	public void setD3GraphList(List<D3SelectListDTO> d3GraphList) {
		D3GraphList = d3GraphList;
	}

}
