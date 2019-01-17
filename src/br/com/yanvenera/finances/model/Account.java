package br.com.yanvenera.finances.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String holder;
    private String account;
    private String bank;
    private String branch;

    @OneToMany(mappedBy = "account")
    private List<Transation> transationList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Transation> getTransationList() {
        return transationList;
    }

    public void setTransationList(List<Transation> transationList) {
        this.transationList = transationList;
    }
}
