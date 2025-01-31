package it.paolone.ecommerce.services;

import it.paolone.ecommerce.dto.TransactionDTO;
import it.paolone.ecommerce.entities.Transaction;
import it.paolone.ecommerce.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    public Transaction getTransactionById(Long id) {
        Optional<Transaction> fetchedTransaction = transactionRepository.findById(id);
        return fetchedTransaction.orElse(null);
    }

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction data) {
        return transactionRepository.save(data);
    }

    public TransactionDTO convertToTransactionDTO(Transaction data) {
        return modelMapper.map(data, TransactionDTO.class);
    }

    public Transaction convertToTransaction(TransactionDTO data) {
        return modelMapper.map(data, Transaction.class);
    }
}
