package ct.model;

import java.sql.Timestamp;

public class CommunityVO {
private int com_id;//(게시물일련번호) <<pk>>
private int st_id;//(매장일련번호) <<fk>>
private int id;//(고객id) <<fk>>
private String com_img; 
private String com_content;
private String com_tag;
private Timestamp com_createdAt;
}
