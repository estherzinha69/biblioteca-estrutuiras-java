package br.uepb.arvore;

public class BST<T extends Comparable<T>> {

    private static class No<T> {
        T valor;
        No<T> esq, dir;

        No(T valor) {
            this.valor = valor;
        }
    }

    private No<T> raiz;
    private int tamanho = 0;

    public void insert(T valor) {
        raiz = inserir(raiz, valor);
    }

    private No<T> inserir(No<T> no, T valor) {
        if (no == null) {
            tamanho++;
            return new No<>(valor);
        }

        if (valor.compareTo(no.valor) < 0) {
            no.esq = inserir(no.esq, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.dir = inserir(no.dir, valor);
        }

        return no;
    }

    public boolean search(T valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No<T> no, T valor) {
        if (no == null) return false;

        if (valor.compareTo(no.valor) == 0) return true;

        if (valor.compareTo(no.valor) < 0) {
            return buscar(no.esq, valor);
        }

        return buscar(no.dir, valor);
    }

    public void inOrder() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No<T> no) {
        if (no != null) {
            emOrdem(no.esq);
            System.out.print(no.valor + " ");
            emOrdem(no.dir);
        }
    }

    public void preOrder() {
        pre(raiz);
        System.out.println();
    }

    private void pre(No<T> no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            pre(no.esq);
            pre(no.dir);
        }
    }

    public void postOrder() {
        pos(raiz);
        System.out.println();
    }

    private void pos(No<T> no) {
        if (no != null) {
            pos(no.esq);
            pos(no.dir);
            System.out.print(no.valor + " ");
        }
    }

    public int height() {
        return altura(raiz);
    }

    private int altura(No<T> no) {
        if (no == null) return -1;

        return 1 + Math.max(altura(no.esq), altura(no.dir));
    }

    public int size() {
        return tamanho;
    }
}