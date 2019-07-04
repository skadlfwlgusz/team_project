package ct.model;

import java.sql.Timestamp;

public class ReviewVO {
private int rv_id;//(매장에 달리는 리뷰고유번호) <<pk>>
private int id;//(고개id) <<fk>>
private int st_id;//(매장일련번호)<<fk>>
private String rv_content;
private int rv_star;//(별점)
private Timestamp rv_createdAt;
}
