package com.pairlearning.expencetrackerapi.services;

import com.pairlearning.expencetrackerapi.entities.Category;
import com.pairlearning.expencetrackerapi.entities.Transaction;
import com.pairlearning.expencetrackerapi.exceptions.ETBadRequestException;
import com.pairlearning.expencetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface TransactionService {

    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);

    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws ETBadRequestException;

    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws ETBadRequestException;

    void removeTransaction(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
