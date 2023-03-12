package com.example.br.edu.ifsp.dmo5.superbancoimobiliariodmo;

import java.util.ArrayList;
import java.util.List;


public class StarBank {

    List<CreditCard> jogadores = new ArrayList();
    private static StarBank instance = null;

    public StarBank(){ }

    public static StarBank getInstance(){
        if(instance == null){
            instance = new StarBank();
        }
        return instance;
    }

    public void startGame(){
        int i;
        for(i=0; i<6; i++){
            jogadores.add(new CreditCard(i));
        }
    }
    public void roundCompleted(int card, double value) {
        jogadores.get(card).creditValue(value);
    }

    public boolean transfer(int payer, int receiver, double value) {

        boolean estado;

        estado = jogadores.get(payer).debitoValue(value);

        if(estado == true){
            jogadores.get(receiver).creditValue(value);
            return true;
        }else{
            return false;
        }
    }

    public void receive(int card, double value){

        jogadores.get(card).creditValue(value);
    }

    public boolean pay(int card, double value) {

        boolean estado;

        estado = jogadores.get(card).debitoValue(value);

        if(estado == true){
            return true;
        }else{
            return false;
        }
    }

    public double seeBalance(int i){
        double j;

        return  j = jogadores.get(i).getBalance();
    }
}

