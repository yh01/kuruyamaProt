package dao;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import dto.AdminGoInquiryDTO;

/**
 * お問い合わせ情報をDBから取得する為のDAOクラス
 * @author TAKESHI BANSHOU
 * @version 1.0
 * @since 1.0
 */
public class AdminGoInquiryDAO {

	/**
	 * mongoDBのデータベースに接続
	 */
	DB db = null;

	/**
	 * mongoDBに接続
	 */
	MongoClient mongo = null;

	/**
	 * コレクションに接続
	 */
	DBCollection colls;

	/**
	 * 指定されたドキュメントを取得
	 */
	DBCursor cursor;

	/**
	 * お問い合わせ情報を格納するリスト
	 */
	ArrayList<AdminGoInquiryDTO> list = new ArrayList<AdminGoInquiryDTO>();

    /**
     * ramenデータベースのformテーブルからお問い合わせ情報を取得する為のメソッド
     * @return list お問い合わせ情報を返します。
     * @throws UnknownHostException
     */
    public ArrayList<AdminGoInquiryDTO> select() throws UnknownHostException{
        mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("ramen");
        colls = db.getCollection("form");
        cursor = colls.find();
        try {
            while(cursor.hasNext()) {
                AdminGoInquiryDTO dto = new AdminGoInquiryDTO();
                DBObject dbs = cursor.next();
                dto.setFormId((String)dbs.get("form_id"));
                dto.setFormName((String)dbs.get("form_name"));
                dto.setFormAddress((String)dbs.get("form_address"));
                dto.setFormContents((String)dbs.get("form_contents"));
                dto.setFormResistration((String)dbs.get("form_resistration"));
                list.add(dto);
            }
        } finally {
            cursor.close();
        }
        return list;
    }
}