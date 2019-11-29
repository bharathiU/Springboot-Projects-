package com.bankapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.TransactionLog;

@Repository
public interface TransactionalLogRepository extends JpaRepository<TransactionLog, Long>{

}
