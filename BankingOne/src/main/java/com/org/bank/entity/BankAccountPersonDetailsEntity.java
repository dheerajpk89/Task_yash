package com.org.bank.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "BankAccountPersonDetails")
public class BankAccountPersonDetailsEntity {

	@Id
    public String id;
	
	@Field(value = "f_name")
	private String fName;
	
	@Field(value = "l_name")
	private String lName;
	
	@Field(value = "m_name")
	private String mName;
	
	@Field(value = "account_number")
	private String accountNumber;
	
	@Field(value = "balance_amount")
	private Integer balanceAmount;
	
	@Field(value = "message")
	private String  message;
}
