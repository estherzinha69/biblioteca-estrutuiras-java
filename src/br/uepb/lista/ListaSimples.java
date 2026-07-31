package br.uepb.lista;

import br.uepb.no.No;

public class ListaSimples<T> {

    private No<T> inicio;
    private int tamanho;

    public ListaSimples() {
        inicio = null;
        tamanho = 0;
    }

    // Adicionar no final
    public void add(T valor) {

        No<T> novo = new No<>(valor);

        if (inicio == null) {
            inicio = novo;
        } else {

            No<T> aux = inicio;

            while (aux.prox != null) {
                aux = aux.prox;
            }

            aux.prox = novo;
        }

        tamanho++;
        System.out.println(valor + " adicionado.");
    }

    // Buscar valor
    public boolean search(T valor) {

        No<T> aux = inicio;

        while (aux != null) {

            if (aux.valor.equals(valor)) {
                return true;
            }

            aux = aux.prox;
        }

        return false;
    }

    // Remover valor
    public boolean remove(T valor) {

        if (inicio == null) {
            return false;
        }

        // remover primeiro
        if (inicio.valor.equals(valor)) {
            inicio = inicio.prox;
            tamanho--;
            return true;
        }

        No<T> ant = inicio;
        No<T> atual = inicio.prox;

        while (atual != null) {

            if (atual.valor.equals(valor)) {
                ant.prox = atual.prox;
                tamanho--;
                return true;
            }

            ant = atual;
            atual = atual.prox;
        }

        return false;
    }

    public int size() {
        return tamanho;
    }

    public void print() {

        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        No<T> aux = inicio;

        while (aux != null) {
            System.out.print(aux.valor + " -> ");
            aux = aux.prox;
        }

        System.out.println("null");
    }
}