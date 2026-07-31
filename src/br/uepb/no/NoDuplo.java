package br.uepb.no;

public class NoDuplo<T> {

    public T valor;
    public NoDuplo<T> ant;
    public NoDuplo<T> prox;

    public NoDuplo(T valor) {
        this.valor = valor;
        this.ant = null;
        this.prox = null;
    }
}