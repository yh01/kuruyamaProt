package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.SelectItemStockListDAO;
import dto.SelectItemStockListDTO;

/**
 * 商品編集画面の在庫数グラフを表示する為に必要な、商品名と在庫数をD3GraphListに格納するアクションクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 */
public class SelectItemStockListAction extends ActionSupport{

	/**
	 * 商品名と在庫数を格納するリスト
	 */
	public List<SelectItemStockListDTO> D3GraphList = new ArrayList<SelectItemStockListDTO>();

	/**
	 * 商品名と在庫数をD3GraphListに格納するメソッド
	 * @return result SUCCESSをresultに格納します。もし必要な商品名と在庫数が受け取れなければresultにERRORを格納しresultを返します。受け取れればD3GraphListに値を格納、resultを返します。
	 */
	public String execute(){
		SelectItemStockListDAO dao = new SelectItemStockListDAO();
		String result = SUCCESS;
		if(!dao.select()){
			return ERROR;
		}
		D3GraphList = dao.getD3GraphList();
		return result;
	}

	/**
	 * 商品名と在庫数を取得するメソッド
	 * @return D3GraphList 商品名と在庫数を格納するリスト
	 */
	public List<SelectItemStockListDTO> getD3GraphList() {
		return D3GraphList;
	}

	/**
	 * 商品名と在庫数を格納するメソッド
	 * @param d3GraphList 商品名と在庫数を格納するリスト
	 */
	public void setD3GraphList(List<SelectItemStockListDTO> d3GraphList) {
		D3GraphList = d3GraphList;
	}

}
