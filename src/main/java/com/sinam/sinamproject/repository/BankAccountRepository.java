package com.sinam.sinamproject.repository;

import com.sinam.sinamproject.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByUserId(Long userId);
    List<BankAccount> findByStatusAndUserId(String status, Long userId);
}
