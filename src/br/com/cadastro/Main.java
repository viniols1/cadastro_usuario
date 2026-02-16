package br.com.cadastro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        imprimirCabecalho();

        String nome = lerNome(scanner);
        int idade = lerIdade(scanner);

        Usuario usuario = new Usuario(nome, idade);

        imprimirResumo(usuario);

        scanner.close();
    }

    private static void imprimirCabecalho() {
        System.out.println("=================================");
        System.out.println("     SISTEMA DE CADASTRO JAVA     ");
        System.out.println("=================================");
    }

    private static String lerNome(Scanner scanner) {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    private static int lerIdade(Scanner scanner) {
        int idade = -1;

        while (idade < 0) {
            System.out.print("Idade: ");

            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                if (idade < 0) {
                    System.out.println("Idade não pode ser negativa.");
                }
            } else {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.next();
            }
        }

        return idade;
    }

    private static void imprimirResumo(Usuario usuario) {
        System.out.println("---------------------------------");
        System.out.println("Resumo do cadastro:");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Idade: " + usuario.getIdade());

        if (usuario.isMaiorDeIdade()) {
            System.out.println("Status: Maior de idade");
        } else {
            System.out.println("Status: Menor de idade");
        }
    }
}
