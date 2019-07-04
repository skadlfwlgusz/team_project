package ct.model;

import java.sql.Timestamp;

public class ActivityVO {
private int ac_id;//(액티비티일련번호) <<pk>>
private int com_id;//(게시물일련번호) <<fk>>
private int rp_id; //(댓글일련번호) <<fk>>
private String ac_subject;//(주체)
private Timestamp ac_object;//(객체)
//	-ac-createdAt
}
