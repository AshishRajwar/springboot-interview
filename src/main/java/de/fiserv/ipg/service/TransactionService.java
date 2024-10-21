package de.fiserv.ipg.service;

import de.fiserv.ipg.entity.Transaction;
import de.fiserv.ipg.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	public Optional<Transaction> getTransactionsById(Long id) {
		return transactionRepository.findById(id);
	}

	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
