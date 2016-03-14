package dto;

/**
 * お問い合わせ情報を格納するDTOクラス
 * @author TAKESHI BANSHOU
 * @version 1.0
 * @since 1.0
 */
public class AdminGoInquiryDTO {

    /**
     * 問い合わせID
     */
    private String formId;

    /**
     * 名前
     */
    private String formName;

    /**
     * メールアドレス
     */
    private String formAddress;

    /**
     * 書き込み内容
     */
    private String formContents;

    /**
     * 問い合わせ日
     */
    private String formResistration;

    /**
     * 問い合わせIDを取得するメソッド
     * @return formId 問い合わせID
     */
    public String getFormId() {
        return formId;
    }

    /**
     * 問い合わせIDを格納するメソッド
     * @param formId 問い合わせID
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * 名前を取得するメソッド
     * @return formName 名前
     */
    public String getFormName() {
        return formName;
    }

    /**
     * 名前を格納するメソッド
     * @param formName 名前
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }

    /**
     * メールアドレスを取得するメソッド
     * @return formAddress メールアドレス
     */
    public String getFormAddress() {
        return formAddress;
    }

    /**
     * メールアドレスを格納するメソッド
     * @param formAddress メールアドレス
     */
    public void setFormAddress(String formAddress) {
        this.formAddress = formAddress;
    }

    /**
     * 書き込み内容を取得するメソッド
     * @return formContents 書き込み内容
     */
    public String getFormContents() {
        return formContents;
    }

    /**
     * 書き込み内容を格納するメソッド
     * @param formContents 書き込み内容
     */
    public void setFormContents(String formContents) {
        this.formContents = formContents;
    }

    /**
     * 問い合わせ日を取得するメソッド
     * @return formResistration 問い合わせ日
     */
    public String getFormResistration() {
        return formResistration;
    }

    /**
     * 問い合わせ日を格納するメソッド
     * @param formResistration 問い合わせ日
     */
    public void setFormResistration(String formResistration) {
        this.formResistration = formResistration;
    }
}