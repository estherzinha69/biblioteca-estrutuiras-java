package br.uepb.lista;

import br.uepb.no.NoDuplo;

public class ListaDupla<T> {

    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;
    private int tamanho;

    public ListaDupla() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    // Adicionar no final
    public void addLast(T valor) {

        NoDuplo<T> novo = new NoDuplo<>(valor);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }

        tamanho++;
        System.out.println(valor + " adicionado no final.");
    }

    // Adicionar no início
    public void addFirst(T valor) {

        NoDuplo<T> novo = new NoDuplo<>(valor);

        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }

        tamanho++;
        System.out.println(valor + " adicionado no início.");
    }

    // Remover do início
    public T removeFirst() {

        if (inicio == null) {
            return null;
        }

        T valor = inicio.valor;

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.prox;
            inicio.ant = null;
        }

        tamanho--;
        return valor;
    }

    // Remover do final
    public T removeLast() {

        if (fim == null) {
            return null;
        }

        T valor = fim.valor;

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.ant;
            fim.prox = null;
        }

        tamanho--;
        return valor;
    }

    public int size() {
        return tamanho;
    }

    // Imprimir do início para o fim
    public void printForward() {

        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        NoDuplo<T> aux = inicio;

        while (aux != null) {
            System.out.print(aux.valor + " <-> ");
            aux = aux.prox;
        }

        System.out.println("null");
    }

    // Imprimir do fim para o início
    public void printBackward() {

        if (fim == null) {
            System.out.println("Lista vazia!");
            return;
        }

        NoDuplo<T> aux = fim;

        while (aux != null) {
            System.out.print(aux.valor + " <-> ");
            aux = aux.ant;
        }

        System.out.println("null");
    }
}