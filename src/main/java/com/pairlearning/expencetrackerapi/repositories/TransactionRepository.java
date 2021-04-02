package com.pairlearning.expencetrackerapi.repositories;

import com.pairlearning.expencetrackerapi.entities.Transaction;
import com.pairlearning.expencetrackerapi.exceptions.ETBadRequestException;
import com.pairlearning.expencetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findAll(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

    Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws ETBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws ETBadRequestException;

    void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
