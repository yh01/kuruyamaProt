package dto;

/**
 * 商品編集画面の在庫数グラフを表示する為に必要な、商品名と在庫数を格納、取得するためのクラス
 * @author Yuki Hoshino
 * @version 1.0
 * @since 1.0
 */
public class SelectItemStockListDTO {

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 在庫数
	 */
	private int itemStock;

	/**
	 * 備考
	 */
	private String explanation;

	/**
	 * 価格
	 */
	private int price;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * カテゴリー
	 */
	private String category;

	/**
	 * 商品名を取得するメソッド
	 * @return itemName 商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名を格納するメソッド
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 在庫数を取得するメソッド
	 * @return itemStock 在庫数
	 */
	public int getItemStock() {
		return itemStock;
	}

	/**
	 * 在庫数を格納するメソッド
	 * @param itemStock 在庫数
	 */
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	/**
	 * 備考を取得するメソッド
	 * @return explanation 備考
	 */
	public String getExplanation() {
		return explanation;
	}

	/**
	 * 備考を格納するメソッド
	 * @param explanation 備考
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	/**
	 * 価格を取得するメソッド
	 * @return price 価格
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 価格を格納するメソッド
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price = price;
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
	 * カテゴリーを取得するメソッド
	 * @return category カテゴリー
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * カテゴリーを格納するメソッド
	 * @param category カテゴリー
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
