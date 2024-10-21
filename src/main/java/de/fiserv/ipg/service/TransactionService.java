package de.fiserv.ipg.service;

import de.fiserv.ipg.entity.Transaction;
import de.fiserv.ipg.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

	private final TransactionRepository transactionRepository;

	@Autowired
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

}
