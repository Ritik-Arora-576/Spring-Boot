package com.Aspect_Oriented_Programming.AOP_demo.dao;

import com.Aspect_Oriented_Programming.AOP_demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account){
        System.out.println(getClass() + ": Saving the account.");
    }

    @Override
    public List<Account> findAccounts(){
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Ritik", "Gold"));
        accounts.add(new Account("Yash", "Silver"));
        accounts.add(new Account("Mansi", "Bronze"));

        return accounts;
    }

    public String getName() {
        System.out.println(getClass()+" getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
