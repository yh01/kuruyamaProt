package com.internousdevwork.kuruyama.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdevwork.kuruyama.dao.AdminDeleteItemsDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 商品情報をデータベースから削除する為のアクションクラス
 * @author KUDO KAZUNORI
 * @version 1.0
 * @since 1.0
 */
public class  AdminDeleteItemsAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -5342958602388366916L;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     *  商品ID
     */
    private int itemId;

    /**
     *  削除メッセージ
     */
    private String deleteMessage;

    /**
     *  更新件数
     */
    private int count;

    /**
     * kuruyamaデータベースのramen_itemsの商品情報を削除する為のメソッド
     * @return SUCCESS/ERROR 削除に成功した場合はSUCCESS、失敗した場合はERRORを返します。
     */
    public String execute(){
        if(!session.containsKey("adminId")){
            return ERROR;
        }
        AdminDeleteItemsDAO dao = new AdminDeleteItemsDAO();
        count = dao.delete(itemId);
        if(count > 0){
            deleteMessage="削除に成功しました。";
            return SUCCESS;
        }else{
            deleteMessage="削除できませんでした。";
            return SUCCESS;
        }
    }

    /**
     * 商品IDを取得するメソッド
     * @return itemId 商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納するメソッド
     * @param itemId 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 削除メッセージを取得するメソッド
     * @return deleteMessage 削除メッセージ
     */
    public String getDeleteMessage() {
        return deleteMessage;
    }

    /**
     * 削除メッセージを格納するメソッド
     * @param deleteMessage 削除メッセージ
     */
    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    /**
     * セッションを格納するメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}