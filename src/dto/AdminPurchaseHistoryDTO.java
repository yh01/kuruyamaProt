package dto;

public class AdminPurchaseHistoryDTO {
	private int salesId;
	private int userId;
	private String itemName;
	private int NumberOfItem;
	private String dateTime;
	private String postalCode;
	private String Address;
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getNumberOfItem() {
		return NumberOfItem;
	}
	public void setNumberOfItem(int numberOfItem) {
		NumberOfItem = numberOfItem;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}
