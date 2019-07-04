package ct.model;

import java.sql.Timestamp;
import java.util.Date;

public class MemberVO {
	private int id;// <<pk>>
	private String email_id;// <<uq>>
	private String password;
	private Date birth;
	private String phone;
	private int point;
	private String following;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	
	
}
