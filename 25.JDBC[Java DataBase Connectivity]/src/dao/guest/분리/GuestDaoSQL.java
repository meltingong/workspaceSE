package dao.guest.분리;

public class GuestDaoSQL {
	
	public static final String GUEST_INSERT = "insert into guest values(guest_guest_no_seq.nextval,?,?,?,?,?,?)";
	public static final String GUEST_UPDATE = "update guest set guest_name = ?, guest_date = ?, guest_email = ?, guest_homepage = ?, guest_title = ?, guest_content = ? where guest_no = ? ";
	public static final String GUEST_DELETE = "delete guest where guest_no = ? ";
	public static final String GUEST_SELECT_BY_NO = "select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content from guest where guest_no = ?";
	public static final String GUEST_SECET_BY_ALL = "select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content from guest";
	
}
