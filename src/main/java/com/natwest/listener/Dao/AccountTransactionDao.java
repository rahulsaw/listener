package com.natwest.listener.Dao;

import com.natwest.listener.entity.AccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
created by Rahul sawaria on 03/04/22
*/
@Repository
public interface AccountTransactionDao extends JpaRepository<AccountTransactionEntity, Integer> {
}
