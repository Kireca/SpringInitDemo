package com.example.springinitdemo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(unique = true)
    private String username;

    @Column
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;


    public User() {
        setAccounts(new ArrayList<>());
    }

    public List<Long> getAccountIds() {
        return this.accounts.stream()
                .map(Account::getId)
                .collect(Collectors.toList());
    }


    public void addAccount(Account account) {

    }

    public void removeAccount(Account account) {

    }


    public User(String username, int age, Account account) {
        setAccounts(new ArrayList<>());
        setUsername(username);
        setAge(age);
        getAccounts().add(account);
    }
}
