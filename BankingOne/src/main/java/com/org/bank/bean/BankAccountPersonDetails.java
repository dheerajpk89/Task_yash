package com.org.bank.bean;

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
public class BankAccountPersonDetails {

	private String fName;
	private String lName;
	private String mName;
	private String accountNumber;
	private Integer balanceAmount;
	private String  message;
}
