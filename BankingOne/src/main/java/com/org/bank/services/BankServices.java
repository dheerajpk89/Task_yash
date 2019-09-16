package com.org.bank.services;

import com.org.bank.bean.BankAccountPersonDetails;

public interface BankServices {
	
	public String createUser(final BankAccountPersonDetails bankAccountPersonDetails);
	
	public BankAccountPersonDetails getAccountDetail(final String id);

}
