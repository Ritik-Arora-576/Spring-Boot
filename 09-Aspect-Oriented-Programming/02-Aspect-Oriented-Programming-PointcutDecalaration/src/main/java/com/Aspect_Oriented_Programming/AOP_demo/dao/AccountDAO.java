package com.Aspect_Oriented_Programming.AOP_demo.dao;

import com.Aspect_Oriented_Programming.AOP_demo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account);
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
}
