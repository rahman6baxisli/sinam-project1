package com.sinam.sinamproject.repository;

import com.sinam.sinamproject.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findBySenderAccountId(Long senderAccountId);
    List<Transfer> findByReceiverAccountId(Long receiverAccountId);
}
