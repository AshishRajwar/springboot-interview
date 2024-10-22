package de.fiserv.ipg.controller;

import de.fiserv.ipg.entity.Transaction;
import de.fiserv.ipg.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		System.out.println("getTransactions");
		return ResponseEntity.ok(transactionService.getAllTransactions());
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Transaction>> getTransactionsById(@PathVariable("id") Long id) {
		System.out.println("getTransactionsById");
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be positive.");
		}
		return ResponseEntity.ok(transactionService.getTransactionsById(id));
	}

	@PostMapping("")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
		System.out.println("addTransactionsById");
		return ResponseEntity.ok(transactionService.addTransaction(transaction));
	}

	// Handle IllegalArgumentException

}
