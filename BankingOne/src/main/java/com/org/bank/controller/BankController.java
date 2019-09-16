package com.org.bank.controller;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.bank.bean.BankAccountPersonDetails;
import com.org.bank.services.BankServices;

@RestController
public class BankController {
	@Autowired
	BankServices bankServices;

	@RequestMapping(value = "/getBankDetails/{id}", method = RequestMethod.GET)
	private BankAccountPersonDetails getBankDetails(@PathVariable final String id) {
		if (id.equals("ICIC202920")) {
			return insilasePerson();
		} else {
			return BankAccountPersonDetails.builder().message("Error : account does not exist").build();
		}
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	private String createAccount(@RequestBody final BankAccountPersonDetails bankAccountPersonDetails) {
		String id = bankServices.createUser(bankAccountPersonDetails);
		System.out.println("-->" + id);
		return id;
	}
	@RequestMapping(value = "/getAccountDetail/{id}", method = RequestMethod.GET)
	private BankAccountPersonDetails getAccountDetail(@PathVariable final String id) {
		BankAccountPersonDetails bdetail= bankServices.getAccountDetail(id);
		System.out.println("-->" + id);
		return bdetail;
	}

	@RequestMapping(value = "/updateBankDetails", method = RequestMethod.PATCH)
	private BankAccountPersonDetails updateBankDetails(
			@RequestBody final BankAccountPersonDetails bankAccountPersonDetails) throws Exception {

		if (bankAccountPersonDetails.getAccountNumber().equals("ICIC202920")) {

			BankAccountPersonDetails bankAccountPersonDetailsOld = insilasePerson();
			if (bankAccountPersonDetailsOld.getBalanceAmount() > bankAccountPersonDetails.getBalanceAmount()) {
				bankAccountPersonDetails.setBalanceAmount(
						bankAccountPersonDetailsOld.getBalanceAmount() - bankAccountPersonDetails.getBalanceAmount());
				bankAccountPersonDetails.setMessage("Details Update Successfully..!");
				return bankAccountPersonDetails;
			} else {
				return BankAccountPersonDetails.builder().message("Error : Insufficient balance Amount..!").build();
			}
		} else {
			return BankAccountPersonDetails.builder().message("Error : account does not exist").build();
		}
	}

	private static BankAccountPersonDetails insilasePerson() {
		return BankAccountPersonDetails.builder()
				.accountNumber("ICIC202920")
				.balanceAmount(10000)
				.fName("Boby")
				.lName("S")
				.mName("das")
				.message("Account found .!").build();
	}
}
