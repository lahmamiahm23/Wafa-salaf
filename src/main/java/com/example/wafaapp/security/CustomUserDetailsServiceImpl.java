package com.example.wafaapp.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.wafaapp.custom.exception.BranchNotFoundException;
import com.example.wafaapp.repositories.AccountDao;
import com.example.wafaapp.entities.Account;

import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
@Service
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    // dep user dao
    @Autowired
    private AccountDao accountDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws BranchNotFoundException {
        // invoke dao's method to get uer details form DB
        System.out.println("in loadUserByUsername of CustomDetailsServiceImpl");
        Account user = accountDao.findByEmail(email)
                .orElseThrow(() ->
                        new BranchNotFoundException("Invalid Email !!!!!"));
        //=> user email exists
        return new CustomUserDetails(user);
    }
}
