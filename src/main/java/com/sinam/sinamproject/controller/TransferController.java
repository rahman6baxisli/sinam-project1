package com.sinam.sinamproject.controller;
import com.sinam.sinamproject.entity.Transfer;
import com.sinam.sinamproject.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfer/{senderAccountId}/{receiverAccountId}/{amount}")
    public ResponseEntity<Transfer> transferMoney(@PathVariable Long senderAccountId,
                                                  @PathVariable Long receiverAccountId,
                                                  @PathVariable Double amount) {
        return ResponseEntity.ok(transferService.transferMoney(senderAccountId, receiverAccountId, amount));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transfer>> getUserTransfers(@PathVariable Long userId) {
        return ResponseEntity.ok(transferService.getUserTransfers(userId));
    }
}
