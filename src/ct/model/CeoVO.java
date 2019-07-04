package ct.model;

import java.sql.Timestamp;
import java.util.Date;

public class CeoVO {
private int ceo_id;// <<pk>>
private String ceo_email;// <<uq>>
private String ceo_password;
private Date ceo_birth;
private String ceo_phone;
private String ceo_license;
private Timestamp ceo_createdAt;
private Timestamp ceo_updatedAt;

}
