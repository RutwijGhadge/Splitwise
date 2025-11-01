package com.project.Splitwise.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseClass{
    private double Amount;
    private String Description;//who paid , who had to pay

    @Enumerated(EnumType.STRING)//to store enum values as String & @Enumerated(EnumType.Ordinal)->as Integers
    private Currency currency;

    @OneToMany
    @JoinColumn(name = "splitwise_expense_id") //One to Many (UniDirectional relationship with Expense : UserExpense table -> It will tell JPA to join with expense id column
    private List<UserExpense> userExpenses;
}
//Expense -> Currency -> 1:1
/*
   Expense : UserExpense
      1        M
      1        1

    Group      Expense   (UniDirectional)
      1         M
      1         1
 */