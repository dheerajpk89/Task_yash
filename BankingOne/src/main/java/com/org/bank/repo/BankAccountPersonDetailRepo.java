package com.org.bank.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.org.bank.entity.BankAccountPersonDetailsEntity;

public interface  BankAccountPersonDetailRepo extends MongoRepository<BankAccountPersonDetailsEntity, String>  {
	
	public BankAccountPersonDetailsEntity findById(final String id);

}
