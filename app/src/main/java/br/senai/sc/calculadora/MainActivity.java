package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String primeiroNumero = "";
    private String segundoNumero = "";
    private String operacao = "";
    private float resultado = 0;
    private float numero1 = 0;
    private float numero2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculadora do Rods");
        display = findViewById(R.id.tv_display);
    }

    public void onClickBotao1(View v) {
        verificarNumeroDigitado("1");
        atualizarDisplay("1");
    }
    public void onClickBotao2(View v) {
        verificarNumeroDigitado("2");
        atualizarDisplay("2");
    }
    public void onClickBotao3(View v) {
        verificarNumeroDigitado("3");
        atualizarDisplay("3");
    }
    public void onClickBotao4(View v) {
        verificarNumeroDigitado("4");
        atualizarDisplay("4");
    }
    public void onClickBotao5(View v) {
        verificarNumeroDigitado("5");
        atualizarDisplay("5");
    }
    public void onClickBotao6(View v) {
        verificarNumeroDigitado("6");
        atualizarDisplay("6");
    }
    public void onClickBotao7(View v) {
        verificarNumeroDigitado("7");
        atualizarDisplay("7");
    }
    public void onClickBotao8(View v) {
        verificarNumeroDigitado("8");
        atualizarDisplay("8");
    }
    public void onClickBotao9(View v) {
        verificarNumeroDigitado("9");
        atualizarDisplay("9");
    }
    public void onClickBotao0(View v) {
        verificarNumeroDigitado("0");
        atualizarDisplay("0");
    }
    public void onClickAdicao(View v) {
        verificarOperacao("+");
    }
    public void onClickSubtracao(View v) {
        verificarOperacao("-");
    }
    public void onClickMultiplicacao(View v) {
        verificarOperacao("*");
    }
    public void onClickDivisao(View v) {
        verificarOperacao("/");
    }
    public void onClickIgual(View v) {
        if (!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()) {
            float numero1 = Integer.parseInt(primeiroNumero);
            float numero2 = Integer.parseInt(segundoNumero);
            if (operacao.equals("+")) {
                float resultado = numero1 + numero2;
                display.setText(String.valueOf(resultado));
            }
            if (operacao.equals("-")) {
                float resultado = numero1 - numero2;
                display.setText(String.valueOf(resultado));
            }
            if (operacao.equals("*")) {
                float resultado = numero1 * numero2;
                display.setText(String.valueOf(resultado));
            }
            if (operacao.equals("/")) {
                if (numero2 != 0) {
                    float resultado = numero1 / numero2;
                    display.setText(String.valueOf(resultado));
                } else {
                    Toast.makeText(MainActivity.this, "Não é possível dividir por 0", Toast.LENGTH_LONG).show();
                }

            }
        } else {
                Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickLimpar(View v) {
        operacao = "";
        primeiroNumero = "";
        segundoNumero = "";
        numero1 = 0;
        numero2 = 0;
        resultado = 0;
        display.setText("");
    }
    private void atualizarDisplay(String texto) {
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }
    private void verificarNumeroDigitado(String texto) {
        if (operacao.isEmpty()) {
            primeiroNumero = primeiroNumero + texto;
        } else {
            segundoNumero = segundoNumero + texto;
        }
    }
    private void verificarOperacao(String texto) {
        if (!primeiroNumero.isEmpty()) {
            operacao = texto;
            atualizarDisplay(texto);
        } else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }
}