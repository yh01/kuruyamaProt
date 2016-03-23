package com.internousdevwork.kuruyama.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.kuruyama.dao.AdminUpdateItemStockDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品をデータベースに追加する為のアクションクラス
 * @author KUDO KAZUNORI
 * @version 1.0
 * @since 1.0
 */
public class AdminUpdateItemStockAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 5955353808002410229L;

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * 在庫数
     */
    private int itemStock;

    /**
     * 更新メッセージ
     */
    String updateMessage;

    /**
     * 更新件数
     */
    private int count;

    /**
     * セッション
     */
    private Map<String,Object> session;

    /**
     * 商品在庫を追加する為のメソッド
     * @return SUCCESS/ERROR 更新に成功した場合はSUCCESS、失敗した場合はERRORを返します。
     */
    public String execute(){
    	if(!session.containsKey("adminId")){
            return ERROR;
        }
        AdminUpdateItemStockDAO dao = new AdminUpdateItemStockDAO();
        count = dao.update(itemId,itemStock);
        if(count > 0){
            updateMessage = "更新に成功しました。";
            return SUCCESS;
        }
        updateMessage = "更新できませんでした。";
        return SUCCESS;
    }

    /**
     * 商品IDを取得する為のメソッド
     * @return itemId 商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納する為のメソッド
     * @param itemId 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 在庫数を取得する為のメソッド
     * @return itemStock 在庫数
     */
    public int getItemStock() {
        return itemStock;
    }

    /**
     * 在庫数を格納する為のメソッド
     * @param itemStock 在庫数
     */
    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * セッションを取得するメソッド
     * @return セッション
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