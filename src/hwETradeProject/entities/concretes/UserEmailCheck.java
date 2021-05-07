package hwETradeProject.entities.concretes;

import hwETradeProject.entities.abstracts.Entity;

public class UserEmailCheck implements Entity {
	
	private String emailCheckYesOrNo;
	
	public UserEmailCheck() {
		
	}
	
	public UserEmailCheck(String emailCheckYesOrNo) {
		super();
		this.emailCheckYesOrNo = emailCheckYesOrNo;
	}
	
	

	public String getEmailCheckYesOrNo() {
		return emailCheckYesOrNo;
	}

	public void setEmailCheckYesOrNo(String emailCheckYesOrNo) {
		this.emailCheckYesOrNo = emailCheckYesOrNo;
	}

	
	
	
}
