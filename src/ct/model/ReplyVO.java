package ct.model;

import java.sql.Timestamp;

public class ReplyVO {
private int rp_id;//(댓글일련번호) <<pk>>
private int id;//(고객id) <<fk>>
private int com_id;//(게시물일련번호) <<fk>>
private String rp_content;
private int rp_depth;
private int rp_sort;
private Timestamp rp_createdAt;
}
