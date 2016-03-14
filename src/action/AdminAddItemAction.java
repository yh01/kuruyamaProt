package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminAddItemDAO;

/**
 * 商品情報を追加するアクションクラス
 * @author HARUKI NAKAGAWA
 * @version 1.0
 * @since 1.0
 **/
public class AdminAddItemAction extends ActionSupport implements SessionAware{

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = -9128533430544804905L;

    /**
     * 商品名
     */
    public  String itemName;

    /**
     * 商品説明
     */
    public String explanation;

    /**
     * 商品種別
     */
    public String category;

    /**
     * 値段
     */
    public int price;

    /**
     * 在庫数
     */
    public int itemStock;

    /**
     * 画像パス
     */
    public String imgPath;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * ramenデータベースのramen_itemsに商品情報を追加する為のメソッド
     * @return result 追加に成功したらSUCCESS、失敗したらERRORを返す。
     */
    public String execute() throws SQLException{
        String result =ERROR;
        try{
            AdminAddItemDAO dao = new  AdminAddItemDAO();
            int count = 0;
            count = dao.addItem(itemName,explanation,category,price,itemStock,imgPath);
            if(count > 0){
                result= SUCCESS;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 商品名を取得するメソッド
     * @return itemName商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納するためのメソッド
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 商品情報を取得するためのメソッド
     * @return explanation 商品情報
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * 商品情報を格納するための
     * @param explanation 商品情報
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * 商品種別を取得するためのメソッド
     * @return category 商品種別
     */
    public String getCategory() {
        return category;
    }

    /**
     * 商品種別を格納するためのメソッド
     * @param category 商品種別
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 値段を取得するためのメソッド
     * @return price 値段
     */
    public int getPrice() {
        return price;
    }

    /**
     * 値段を格納するためのメソッド
     * @param price 値段
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 商品種別を取得するためのメソッド
     * @return itemStock 商品種別
     */
    public int getItemStock() {
        return itemStock;
    }

    /**
     * 商品種別を格納するためのメソッド
     * @param itemStock 商品種別
     */
    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    /**
     * 画像パスを取得するためのメソッド
     * @return imgPath 画像パス
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 画像パスを格納するためのメソッド
     * @param imgPath 画像パス
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * セッションを取得するためのメソッド
     * @return session セッション
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するためのメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
