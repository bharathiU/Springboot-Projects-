package com.bankapp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankapp.model.entities.TransactionLog;
@Service
public interface TransactionLogService {

	List<TransactionLog> getTransactonLog();
	

}
