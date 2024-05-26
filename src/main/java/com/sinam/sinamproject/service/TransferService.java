package com.sinam.sinamproject.service;
import com.sinam.sinamproject.entity.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {
    Transfer transferMoney(Long senderAccountId, Long receiverAccountId, Double amount);
    List<Transfer> getUserTransfers(Long userId);
}

