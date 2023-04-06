package com.ramalho.busca_largura_profundidade;

public class No {
    public No pai;
    int valor;
    No esquerda = null;
    No direita = null;

    public No(int valor){
        this.valor = valor;
    }
    public No (int valor, No esquerda, No direita){
        this.valor = valor;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public int getValor(int valor){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public No getEsquerda(){
        return esquerda;
    }

    public void setEsquerda(No esquerda){
        this.esquerda = esquerda;
    }

    public No getDireita(){
        return direita;
    }

    public void setDireita(No direita){
        this.direita = direita;
    }

}
