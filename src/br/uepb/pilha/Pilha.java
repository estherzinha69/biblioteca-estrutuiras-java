package br.uepb.pilha;

public class Pilha<T> {

    private T[] elementos;
    private int topo;

    @SuppressWarnings("unchecked")
    public Pilha(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }

    public void push(T valor) {
        if (isFull()) {
            System.out.println("Pilha cheia!");
            return;
        }
        elementos[++topo] = valor;
        System.out.println(valor + " empilhado.");
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return elementos[topo--];
    }

    public T top() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return elementos[topo];
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return;
        }

        System.out.println("Conteúdo da pilha:");
        for (int i = topo; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
    }
}