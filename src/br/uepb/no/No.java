package br.uepb.no;

public class No<T> {

    public T valor;
    public No<T> prox;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }
}
