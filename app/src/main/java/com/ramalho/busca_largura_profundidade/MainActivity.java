package com.ramalho.busca_largura_profundidade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText raiz = findViewById(R.id.EditTextRaiz);
        final EditText alvo = findViewById(R.id.EditTextAlvo);
        final TextView resultado = findViewById(R.id.resultado);
        Button calcular = findViewById(R.id.buttonCalcular);
        Button limpar = findViewById(R.id.buttonLimpar);

        //Criando os nós
        No no32 = new No(32);
        No no31 = new No(31);
        No no30 = new No(30, no31, no32);
        No no29 = new No(29);
        No no28 = new No(28, no29, no30);
        No no27 = new No(27);
        No no26 = new No(26);
        No no25 = new No(25);
        No no24 = new No(24);
        No no23 = new No(23);
        No no22 = new No(22);
        No no21 = new No(21);
        No no20 = new No(20);
        No no19 = new No(19);
        No no18 = new No(18);
        No no17 = new No(17);
        No no16 = new No(16);
        No no15 = new No(15);
        No no14 = new No(14);
        No no13 = new No(13, no27, no28);
        No no12 = new No(12, no25, no26);
        No no11 = new No(11, no23, no24);
        No no10 = new No(10, no21, no22);
        No no9 = new No(9, no19, no20);
        No no8 = new No(8, no17, no18);
        No no7 = new No(7, no15, no16);
        No no6 = new No(6, no13, no14);
        No no5 = new No(5, no11, no12);
        No no4 = new No(4, no9, no10);
        No no3 = new No(3, no7, no8);
        No no2 = new No(2, no5, no6);
        No no1 = new No(1, no3, no4);
        No no0 = new No(0, no1, no2);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int raizValor = Integer.parseInt(raiz.getText().toString());
                int alvoValor = Integer.parseInt(alvo.getText().toString());

                Stack<No> caminho = BuscaProfundidade(no0, alvoValor);

                if (caminho != null) {
                    resultado.setText("");
                    while (!caminho.empty()) {
                        No no = caminho.pop();
                        resultado.append(String.valueOf(no.valor));
                        if (!caminho.empty()) {
                            resultado.append(" -> ");
                        }
                    }
                } else {
                    resultado.setText("O vértice " + alvoValor + " não foi encontrado na árvore.");
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(alvo.getWindowToken(), 0);
            }
        });


        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
                raiz.setText("");
                alvo.setText("");
            }
        });
    }


    public static Stack<No> BuscaProfundidade(No no, int buscado) {
        if (no == null) {
            return null;
        }

        if (no.valor == buscado) {
            Stack<No> caminho = new Stack<>();
            caminho.push(no);
            return caminho;
        } else {
            Stack<No> caminho = null;
            Stack<No> caminhoEsquerda = BuscaProfundidade(no.esquerda, buscado);
            if (caminhoEsquerda != null) {
                caminho = caminhoEsquerda;
                caminho.push(no);
            }

            if (caminho == null) {
                Stack<No> caminhoDireita = BuscaProfundidade(no.direita, buscado);
                if (caminhoDireita != null) {
                    caminho = caminhoDireita;
                    caminho.push(no);
                }
            }

            return caminho;
        }
    }
}
