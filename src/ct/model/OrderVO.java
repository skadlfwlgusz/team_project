package ct.model;

import java.sql.Timestamp;

public class OrderVO {
	private int or_id;//(주문고유번호)<<pk>>
private int me_id;//(매뉴고유번호) <<fk>>
private int id;// (고개id)<<fk>>
private String st_name;//(매장명) <<fk>>
private int or_sumprice;
private int or_quntity;//(주문량)
private String or_situation;//(주문상태)
private int or_temper;
private int or_cup;
private int or_shot;
private int or_whip;
private int or_syrup;
private Timestamp or_createdAt;//(주문시간)
}
