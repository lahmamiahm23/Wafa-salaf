package com.example.wafaapp.services;
import java.util.List;

import com.example.wafaapp.dto.req.AccountReqDto;
import com.example.wafaapp.dto.req.SigninRequest;
import com.example.wafaapp.dto.resp.AccountRespDto;
import com.example.wafaapp.dto.resp.AccountRespDto2;
public interface AccountService {
    String addAccount(AccountReqDto newAccount) ;
/*
    String removeAccount(long id);
*/
    String updateAccount(long id, AccountReqDto account);
/*

    List<AccountRespDto> getAllAccounts();

    List<AccountRespDto> getAllActiveAccountsByBranchId(long branchId);

    List<AccountRespDto> getAllSuspendedAccountsByBranchId(long branchId);

    List<AccountRespDto> getAllCloseAccountsByBranchId(long branchId);

    AccountRespDto2 getAccountById(long id);

    List<AccountRespDto> getAllAccountsByBranchId(long branchId);



    double checkBalance(long accountNumber);

    String updateTransactionAmountLimit(long accountNumber ,double amount);

    List<AccountRespDto> getAllInActiveAccounts(long id);

    String toSuspendAccount(long id);

    String changePassword(long id,SigninRequest account);*/
}
