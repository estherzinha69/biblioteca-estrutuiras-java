package br.uepb.arvore;

public class AVL<T extends Comparable<T>> {

    private class No {
        T valor;
        No esq, dir;
        int altura;

        No(T valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    private No raiz;
    private int tamanho = 0;

    // ================= ALTURA =================

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    // ================= BALANCEAMENTO =================

    private int balanceamento(No no) {
        return (no == null) ? 0 : altura(no.esq) - altura(no.dir);
    }

    // ================= ROTAÇÃO DIREITA =================

    private No rotacaoDireita(No y) {

        No x = y.esq;
        No t2 = x.dir;

        x.dir = y;
        y.esq = t2;

        y.altura = Math.max(altura(y.esq), altura(y.dir)) + 1;
        x.altura = Math.max(altura(x.esq), altura(x.dir)) + 1;

        return x;
    }

    // ================= ROTAÇÃO ESQUERDA =================

    private No rotacaoEsquerda(No x) {

        No y = x.dir;
        No t2 = y.esq;

        y.esq = x;
        x.dir = t2;

        x.altura = Math.max(altura(x.esq), altura(x.dir)) + 1;
        y.altura = Math.max(altura(y.esq), altura(y.dir)) + 1;

        return y;
    }

    // ================= INSERIR =================

    public void insert(T valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, T valor) {

        if (no == null) {
            tamanho++;
            return new No(valor);
        }

        if (valor.compareTo(no.valor) < 0) {
            no.esq = inserir(no.esq, valor);

        } else if (valor.compareTo(no.valor) > 0) {
            no.dir = inserir(no.dir, valor);

        } else {
            return no; // não permite duplicados
        }

        // Atualiza altura
        no.altura = 1 + Math.max(altura(no.esq), altura(no.dir));

        int balance = balanceamento(no);

        // Caso esquerda-esquerda
        if (balance > 1 && valor.compareTo(no.esq.valor) < 0) {
            return rotacaoDireita(no);
        }

        // Caso direita-direita
        if (balance < -1 && valor.compareTo(no.dir.valor) > 0) {
            return rotacaoEsquerda(no);
        }

        // Caso esquerda-direita
        if (balance > 1 && valor.compareTo(no.esq.valor) > 0) {
            no.esq = rotacaoEsquerda(no.esq);
            return rotacaoDireita(no);
        }

        // Caso direita-esquerda
        if (balance < -1 && valor.compareTo(no.dir.valor) < 0) {
            no.dir = rotacaoDireita(no.dir);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // ================= BUSCAR =================

    public boolean search(T valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No no, T valor) {

        if (no == null) return false;

        int cmp = valor.compareTo(no.valor);

        if (cmp == 0) return true;

        if (cmp < 0) {
            return buscar(no.esq, valor);
        }

        return buscar(no.dir, valor);
    }

    // ================= EM ORDEM =================

    public void inOrder() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(No no) {

        if (no != null) {
            emOrdem(no.esq);
            System.out.print(no.valor + " ");
            emOrdem(no.dir);
        }
    }

    // ================= ALTURA DA ÁRVORE =================

    public int height() {
        return altura(raiz);
    }

    // ================= TAMANHO =================

    public int size() {
        return tamanho;
    }
}