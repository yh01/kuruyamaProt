package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminUpdateStockDAO;

/**
 * 商品をデータベースに追加する為のアクションクラス
 * @author KUDO KAZUNORI
 * @version 1.0
 * @since 1.0
 */
public class AdminUpdateStockAction extends ActionSupport{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 5955353808002410229L;

    /**
     * 在庫を追加する商品ID
     */
    private int upItemId;

    /**
     * 追加する個数
     */
    private int upItemStock;

    /**
     * 結果
     */
    String ans;

    /**
     * アップデートするためのメソッドを格納するための変数
     */
    private int res;

    /**
     * 商品在庫を追加する為のメソッド
     * @return SUCCESS/ERROR 消去に成功した場合はSUCCESS、失敗した場合はERRORを返します。
     */
    public String execute(){
        AdminUpdateStockDAO dao = new AdminUpdateStockDAO();
        res = dao.update(upItemId,upItemStock);
        if(res != 0){
            ans = "更新に成功しました。";
            return SUCCESS;
        }
        ans = "更新できませんでした。";
        return ERROR;
    }

    /**
     * 追加する商品IDを取得する為のメソッド
     * @return upItemId 商品ID
     */
    public int getUpItemId() {
        return upItemId;
    }

    /**
     * 追加する商品IDを格納する為のメソッド
     * @param upItemId 商品ID
     */
    public void setItemId(int upItemId) {
        this.upItemId = upItemId;
    }

    /**
     * 追加する個数を取得する為のメソッド
     * @return upItemStock 追加する商品
     */
    public int getUpItemStock() {
        return upItemStock;
    }

    /**
     * 追加する個数を格納する為のメソッド
     * @param upItemStock 追加する商品
     */
    public void setUpItemStock(int upItemStock) {
        this.upItemStock = upItemStock;
    }
}