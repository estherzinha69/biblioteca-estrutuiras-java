package br.uepb.Fila;

public class Fila<T> {

    private T[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == elementos.length;
    }

    public void enqueue(T valor) {
        if (isFull()) {
            System.out.println("Fila cheia!");
            return;
        }

        fim = (fim + 1) % elementos.length;
        elementos[fim] = valor;
        tamanho++;

        System.out.println(valor + " entrou na fila.");
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return null;
        }

        T valor = elementos[inicio];
        inicio = (inicio + 1) % elementos.length;
        tamanho--;

        return valor;
    }

    public T head() {
        if (isEmpty()) {
            return null;
        }

        return elementos[inicio];
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }

        System.out.println("Conteúdo da fila:");

        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % elementos.length;
            System.out.println(elementos[pos]);
        }
    }
}