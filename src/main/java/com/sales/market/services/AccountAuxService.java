package com.sales.market.services;

import com.sales.market.model.AccountAux;
import com.sales.market.repository.AccountAuxWithDelayRepositoryImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountAuxService {
    private final AccountAuxWithDelayRepositoryImpl repository;

    public AccountAuxService(AccountAuxWithDelayRepositoryImpl repository) {
        this.repository = repository;
    }

    public AccountAux getById(Long id) {
        return repository.getById(id);
    }

    public AccountAux debit(Long accountAuxId, BigDecimal debitAmount) {
        AccountAux accountAux = repository.getByIdWithDelay(accountAuxId, 10L);
        if (accountAux.getBalance().compareTo(debitAmount) >= 0) {
            accountAux.setTotalDebit(accountAux.getTotalDebit().add(debitAmount));
            accountAux.setBalance(accountAux.getBalance().subtract(debitAmount));
        }
        return repository.save(accountAux);
    }

    public AccountAux save(AccountAux accountAux) {
        return repository.save(accountAux);
    }
}
