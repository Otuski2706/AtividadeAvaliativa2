package com.example.br.edu.ifsp.dmo5.superbancoimobiliariodmo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.br.edu.ifsp.dmo5.superbancoimobiliariodmo.R;
import com.example.br.edu.ifsp.dmo5.superbancoimobiliariodmo.model.StarBank;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textview_output;

    private TextView textview_output2;
    private EditText payerEditText;
    private EditText receiverEditText;
    private EditText valueEditText;
    private Button transferButton;
    private Button payButton;
    private Button receiveButton;
    private Button roundButton;
    StarBank sb = new StarBank();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        textview_output = findViewById(R.id.textview_output);
        textview_output2 = findViewById(R.id.textview_output2);
        payerEditText = findViewById(R.id.edittext_payer);
        receiverEditText = findViewById(R.id.edittext_receiver);
        valueEditText = findViewById(R.id.edittext_qtd);
        transferButton = findViewById(R.id.transfer);
        payButton = findViewById(R.id.pay);
        receiveButton = findViewById(R.id.receive);
        roundButton = findViewById(R.id.round);

        transferButton.setOnClickListener(this);
        receiveButton.setOnClickListener(this);
        payButton.setOnClickListener(this);
        roundButton.setOnClickListener(this);

        sb.startGame();
    }

    @Override
    public void onClick(View v) {
        if(v == transferButton){
            int rec = getInt(receiverEditText);
            int pay = getInt(payerEditText);
            double val = getDouble(valueEditText);
            sb.transfer(pay, rec, val);
            double saldoDevedor = sb.seeBalance(pay);
            double saldoRecebedor = sb.seeBalance(rec);

            textview_output.setText(String.format("%.2f", saldoDevedor));
            textview_output2.setText(String.format("%.2f", saldoRecebedor));
        }
        if(v == payButton){
            int pay = getInt(payerEditText);
            double val = getDouble(valueEditText);

            sb.pay(pay, val);
            double saldoDevedor = sb.seeBalance(pay);

            textview_output.setText(String.format("%.2f", saldoDevedor));
        }
        if(v == receiveButton){
            int rec = getInt(receiverEditText);
            double val = getDouble(valueEditText);

            sb.receive(rec, val);
            double saldoRecebedor = sb.seeBalance(rec);

            textview_output2.setText(String.format("%.2f", saldoRecebedor));
        }
        if(v == roundButton){
            int rec = getInt(receiverEditText);
            double val = 1000;

            sb.roundCompleted(rec, val);

            double saldoRecebedor = sb.seeBalance(rec);

            textview_output2.setText(String.format("%.2f", saldoRecebedor));
        }
    }

    private double getDouble(EditText edit){
        double value;
        try{
            value = Double.valueOf(edit.getText().toString());
        }catch (NumberFormatException nfe){
            Toast.makeText(this, R.string.number_error_message, Toast.LENGTH_SHORT).show();
            value = 0;
        }
        return value;
    }

    private int getInt(EditText edit){
        int value;
        try{
            value = Integer.valueOf(edit.getText().toString());
        }catch (NumberFormatException nfe){
            Toast.makeText(this, R.string.number_error_message, Toast.LENGTH_SHORT).show();
            value = 7;
        }
        return value;
    }
}
