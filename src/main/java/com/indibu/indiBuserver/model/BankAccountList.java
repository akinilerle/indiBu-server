package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.BankAccount;

import java.util.List;

public class BankAccountList {

    private List<BankAccount> bankAccountList;

    public BankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public BankAccountList() {
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }
}
