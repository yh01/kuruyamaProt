package dto;

/**
* ユーザー情報を格納する為のDTOクラス
* @author KAZUHIRO YOSHIHARA
* @since 1.0
* @version 1.0
*/
public class AdminUserDTO {

    /**
     * ユーザーID
     */
    private int id;

    /**
     * パスワード
     */
    private String password;

    /**
     * ユーザー名
     */
    private String userName;

    /**
     * メールアドレス
     */
    private String mailAddress;

    /**
     * 住所
     */
    private String Address;

    /**
     * 電話番号
     */
    private String cellNumber;

    /**
     * ユーザーIDを取得するメソッド
     * @return id ユーザーID
     */
    public int getId() {
        return id;
    }

    /**
     * ユーザーIDを格納するメソッド
     * @param id ユーザーID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * パスワードを取得するメソッド
     * @return password パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを格納するメソッド
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ユーザー名を取得するメソッド
     * @return userName ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を格納するメソッド
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * メールアドレスを取得するメソッド
     * @return mailAddress メールアドレス
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * メールアドレスを格納するメソッド
     * @param mailAddress メールアドレス
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 住所を取得するメソッド
     * @return Address 住所
     */
    public String getAddress() {
        return Address;
    }

    /**住所を格納するメソッド
     * @param Address 住所
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 電話番号を取得するメソッド
     * @return cellNumber 電話番号
     */
    public String getCellNumber() {
        return cellNumber;
    }

    /**
     * 電話番号を格納するメソッド
     * @param cellNumber 電話番号
     */
    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
}