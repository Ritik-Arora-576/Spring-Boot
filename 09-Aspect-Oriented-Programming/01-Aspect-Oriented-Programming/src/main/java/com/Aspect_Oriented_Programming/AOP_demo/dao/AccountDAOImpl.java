package com.Aspect_Oriented_Programming.AOP_demo.dao;

import com.Aspect_Oriented_Programming.AOP_demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account){
        System.out.println(getClass() + ": Saving the account.");
    }
}
