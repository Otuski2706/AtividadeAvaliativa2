package com.example.br.edu.ifsp.dmo5.superbancoimobiliariodmo.model;

public class CreditCard {

    private int id;
    private double balance;

    public CreditCard(int id){
        this.id = id;
        this.balance = 15000;
    }

    public void creditValue(double value) {

        this.balance = this.balance + value;
    }

    public boolean debitoValue(double value) {

        if(this.balance >= value){
            this.balance = this.balance - value;
            return true;
        }else{
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

