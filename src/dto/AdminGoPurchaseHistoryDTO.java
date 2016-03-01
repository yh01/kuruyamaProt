package dto;

public class AdminGoPurchaseHistoryDTO {
	private int salesId;
	private int userId;
	private String itemName;
	private int NumberoOfItem;
	private String dateTime;

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
	public int getNumberoOfItem() {
		return NumberoOfItem;
	}
	public void setNumberoOfItem(int numberoOfItem) {
		NumberoOfItem = numberoOfItem;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
}
