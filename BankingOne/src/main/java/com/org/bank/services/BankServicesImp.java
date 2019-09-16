package com.org.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bank.bean.BankAccountPersonDetails;
import com.org.bank.entity.BankAccountPersonDetailsEntity;
import com.org.bank.repo.BankAccountPersonDetailRepo;

@Service
public class BankServicesImp implements BankServices {
	@Autowired
	BankAccountPersonDetailRepo repo;

	public String createUser(final BankAccountPersonDetails bankAccountPersonDetails) {
		String id = repo.save(beanToEntityAsscemblerBankAccountPersonDetails(bankAccountPersonDetails)).getId();
		System.out.println("--->" + id);
		return id;
	}

	private BankAccountPersonDetailsEntity beanToEntityAsscemblerBankAccountPersonDetails(
			final BankAccountPersonDetails bankAccountPersonDetails) {

		return BankAccountPersonDetailsEntity.builder().accountNumber(bankAccountPersonDetails.getAccountNumber())
				.balanceAmount(bankAccountPersonDetails.getBalanceAmount()).fName(bankAccountPersonDetails.getFName())
				.lName(bankAccountPersonDetails.getLName()).mName(bankAccountPersonDetails.getMName())
				.message(bankAccountPersonDetails.getMessage()).build();
	}

	public BankAccountPersonDetails getAccountDetail(final String id) {
		return this.entityToBeanToAsscemblerBankAccountPersonDetails(repo.findById(id));
	}

	private BankAccountPersonDetails entityToBeanToAsscemblerBankAccountPersonDetails(
			final BankAccountPersonDetailsEntity entity) {
		return BankAccountPersonDetails.builder().accountNumber(entity.getAccountNumber())
				.balanceAmount(entity.getBalanceAmount()).fName(entity.getFName()).lName(entity.getLName())
				.mName(entity.getMName()).message(entity.getMessage()).build();
	}
}
