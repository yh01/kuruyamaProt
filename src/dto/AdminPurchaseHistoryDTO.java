package dto;

/**
 * 購入履歴一覧を表示させるために必要な情報を取得、格納するためのクラス
 * @author Yuki Hoshino
 * @since 1.0
 * @version 1.0
 */
public class AdminPurchaseHistoryDTO {

	/**
	 * 購入ID
	 */
	private int salesId;

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 個数
	 */
	private int NumberOfItem;

	/**
	 * 購入日
	 */
	private String dateTime;

	/**
	 * 郵便番号
	 */
	private String postalCode;

	/**
	 * 住所
	 */
	private String Address;

	/**
	 * 購入IDを取得するメソッド
	 * @return salesId 購入ID
	 */
	public int getSalesId() {
		return salesId;
	}

	/**
	 * 購入IDを格納するメソッド
	 * @param salesId 購入ID
	 */
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	/**
	 * ユーザーIDを取得するメソッド
	 * @return userId ユーザーID
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを格納するメソッド
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 商品名を取得するメソッド
	 * @return 商品名
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
	 * 個数を取得するメソッド
	 * @return NumberOfItem 個数
	 */
	public int getNumberOfItem() {
		return NumberOfItem;
	}

	/**
	 * 個数を格納するメソッド
	 * @param numberOfItem
	 */
	public void setNumberOfItem(int numberOfItem) {
		NumberOfItem = numberOfItem;
	}

	/**
	 * 注文日を取得するメソッド
	 * @return dateTime 注文日
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * 注文日を格納するメソッド
	 * @param dateTime
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * 郵便番号を取得するメソッド
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * 郵便番号を格納するメソッド
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 住所を取得するメソッド
	 * @return Address 住所
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * 住所を格納するメソッド
	 * @param address
	 */
	public void setAddress(String address) {
		Address = address;
	}
}
