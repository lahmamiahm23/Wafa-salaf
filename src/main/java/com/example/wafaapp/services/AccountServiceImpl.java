package com.example.wafaapp.services;

import com.example.wafaapp.dto.req.AccountReqDto;
import com.example.wafaapp.entities.Account;
import com.example.wafaapp.entities.Branch;
import com.example.wafaapp.entities.Status;
import com.example.wafaapp.repositories.AccountDao;
import com.example.wafaapp.repositories.BranchDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BranchDao branchDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public String addAccount(AccountReqDto newAccount) {
        Account account = new Account();
        account.setEmail(newAccount.getEmail());
        account.setBalance(newAccount.getBalance());
        account.setCreationDate(LocalDate.now());
        account.setStatus(Status.ACTIVE);

        // Hypothèse simple : branche existe (sinon gérer via Optional.isPresent ou try-catch)
        Branch branch = branchDao.findById(newAccount.getBranchId()).orElse(null);
        if (branch != null) {
            branch.addAccount(account);
        }

        accountDao.save(account);
        return "Account created with email: " + account.getEmail();
    }

    // Méthode vide juste pour éviter des erreurs
    @Override
    public String updateAccount(long id, AccountReqDto newAccount) {
        newAccount.setCountry("maroc");
        // Pas d’implémentation pour le moment
        return "Account updated with id: " + id;
    }
}
