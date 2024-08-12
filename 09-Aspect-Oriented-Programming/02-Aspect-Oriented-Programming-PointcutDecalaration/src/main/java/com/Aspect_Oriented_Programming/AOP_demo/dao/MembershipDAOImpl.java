package com.Aspect_Oriented_Programming.AOP_demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount(){
        System.out.println(getClass() + ": Saving the account.");
    }

    @Override
    public boolean addSillyMember(){
        System.out.println(getClass() + ": getting a silly member.");
        return true;
    }
}
