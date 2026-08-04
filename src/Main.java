package br.uepb.app;

import br.uepb.pilha.Pilha;
import br.uepb.Fila.Fila;
import br.uepb.lista.ListaSimples;
import br.uepb.lista.ListaDupla;
import br.uepb.arvore.BST;
import br.uepb.arvore.AVL;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n==============================");
            System.out.println("Biblioteca de Estruturas");
            System.out.println("==============================");
            System.out.println("1 - Pilha");
            System.out.println("2 - Fila");
            System.out.println("3 - Lista Simples");
            System.out.println("4 - Lista Dupla");
            System.out.println("5 - BST");
            System.out.println("6 - AVL");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    menuPilha(sc);
                    break;

                case 2:
                    menuFila(sc);
                    break;

                case 3:
                    menuListaSimples(sc);
                    break;

                case 4:
                    menuListaDupla(sc);
                    break;

                case 5:
                    menuBST(sc);
                    break;

                case 6:
                    menuAVL(sc);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (op != 0);

        sc.close();
    }

    // ================= PILHA =================

    public static void menuPilha(Scanner sc) {

        Pilha<Integer> pilha = new Pilha<>(5);
        int op;

        do {
            System.out.println("\n--- MENU PILHA ---");
            System.out.println("1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Top");
            System.out.println("4 - Imprimir");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Valor: ");
                    pilha.push(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Removido: " + pilha.pop());
                    break;

                case 3:
                    System.out.println("Topo: " + pilha.top());
                    break;

                case 4:
                    pilha.print();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
            }

        } while (op != 0);
    }

    // ================= FILA =================

    public static void menuFila(Scanner sc) {

        Fila<Integer> fila = new Fila<>(5);
        int op;

        do {
            System.out.println("\n--- MENU FILA ---");
            System.out.println("1 - Enqueue");
            System.out.println("2 - Dequeue");
            System.out.println("3 - Head");
            System.out.println("4 - Imprimir");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Valor: ");
                    fila.enqueue(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Removido: " + fila.dequeue());
                    break;

                case 3:
                    System.out.println("Primeiro: " + fila.head());
                    break;

                case 4:
                    fila.print();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
            }

        } while (op != 0);
    }

    // ================= LISTA SIMPLES =================

    public static void menuListaSimples(Scanner sc) {

        ListaSimples<Integer> lista = new ListaSimples<>();
        int op;

        do {
            System.out.println("\n--- MENU LISTA SIMPLES ---");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Buscar");
            System.out.println("4 - Tamanho");
            System.out.println("5 - Imprimir");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Valor: ");
                    lista.add(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Valor: ");
                    System.out.println(lista.remove(sc.nextInt()) ? "Removido!" : "Não encontrado!");
                    break;

                case 3:
                    System.out.print("Valor: ");
                    System.out.println(lista.search(sc.nextInt()) ? "Encontrado!" : "Não encontrado!");
                    break;

                case 4:
                    System.out.println("Tamanho: " + lista.size());
                    break;

                case 5:
                    lista.print();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
            }

        } while (op != 0);
    }

    // ================= LISTA DUPLA =================

    public static void menuListaDupla(Scanner sc) {

        ListaDupla<Integer> lista = new ListaDupla<>();
        int op;

        do {
            System.out.println("\n--- MENU LISTA DUPLA ---");
            System.out.println("1 - Add First");
            System.out.println("2 - Add Last");
            System.out.println("3 - Remove First");
            System.out.println("4 - Remove Last");
            System.out.println("5 - Imprimir Forward");
            System.out.println("6 - Imprimir Backward");
            System.out.println("7 - Tamanho");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Valor: ");
                    lista.addFirst(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Valor: ");
                    lista.addLast(sc.nextInt());
                    break;

                case 3:
                    System.out.println("Removido: " + lista.removeFirst());
                    break;

                case 4:
                    System.out.println("Removido: " + lista.removeLast());
                    break;

                case 5:
                    lista.printForward();
                    break;

                case 6:
                    lista.printBackward();
                    break;

                case 7:
                    System.out.println("Tamanho: " + lista.size());
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
            }

        } while (op != 0);
    }

    // ================= BST =================

    public static void menuBST(Scanner sc) {

        BST<Integer> bst = new BST<>();
        int op;

        do {
            System.out.println("\n--- MENU BST ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Em Ordem");
            System.out.println("4 - Pré Ordem");
            System.out.println("5 - Pós Ordem");
            System.out.println("6 - Altura");
            System.out.println("7 - Tamanho");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Valor: ");
                    bst.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Valor: ");
                    System.out.println(bst.search(sc.nextInt()) ? "Encontrado!" : "Não encontrado!");
                    break;

                case 3:
                    bst.inOrder();
                    break;

                case 4:
                    bst.preOrder();
                    break;

                case 5:
                    bst.postOrder();
                    break;

                case 6:
                    System.out.println("Altura: " + bst.height());
                    break;

                case 7:
                    System.out.println("Tamanho: " + bst.size());
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
            }

        } while (op != 0);
    }

    // ================= AVL =================

    public static void menuAVL(Scanner sc) {

        AVL<Integer> avl = new AVL<>();
        int op;

        do {
            System.out.println("\n--- MENU AVL ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Em Ordem");
            System.out.println("4 - Altura");
            System.out.println("5 - Tamanho");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Valor: ");
                    avl.insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Valor: ");
                    System.out.println(avl.search(sc.nextInt()) ? "Encontrado!" : "Não encontrado!");
                    break;

                case 3:
                    avl.inOrder();
                    break;

                case 4:
                    System.out.println("Altura: " + avl.height());
                    break;

                case 5:
                    System.out.println("Tamanho: " + avl.size());
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
            }

        } while (op != 0);
    }
}