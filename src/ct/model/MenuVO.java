package ct.model;

import java.sql.Timestamp;

public class MenuVO {
private int me_id;//(메뉴고유번호) <<pk>>
private int st_id; //(매장고유번호) <<fk>>
private String me_name;
private int me_price;
private String me_img;//(메뉴사진)
private int me_temper;
private int me_shot;
private int me_whip;
private int me_syrup;
private Timestamp me_createAt;

}
