package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDeleteItemDAO;

/**
 * 商品情報をデータベースから削除する為のDAOクラス
 * @author KUDO KAZUNORI
 * @version 1.0
 * @since 1.0
 */
public class  AdminDeleteItemAction extends ActionSupport{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -5342958602388366916L;

    /**
     *  削除する商品名
     */
    private int itemId;

    /**
     *  削除の結果
     */
    private String ans;

    /**
     *  削除件数
     */
    private int res;

    /**
     * ramenデータベースのramen_itemの商品情報を削除する為のメソッド
     * @return res 削除に成功した場合はSUCCESS、失敗した場合はERRORを返します。
     */
    public String execute(){
        AdminDeleteItemDAO dao = new AdminDeleteItemDAO();
        res = dao.delete(itemId);
        if(res != 0){
            ans="削除に成功しました。";
            return SUCCESS;
        }else{
            ans="削除できませんでした。";
            return ERROR;
        }
    }

    /**
     * 削除する商品名を取得します。
     * @return 削除する商品名
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 削除する商品名を設定します。
     * @param itemId 削除する商品名
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 削除の結果を取得します。
     * @return 削除の結果
     */
    public String getAns() {
        return ans;
    }

    /**
     * 削除の結果を格納します。
     * @param ans 削除の結果
     */
    public void setAns(String ans) {
        this.ans = ans;
    }
}