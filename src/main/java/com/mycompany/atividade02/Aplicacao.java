package com.mycompany.atividade02;
import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao = -1;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1 - Cadastrar leitor");
            System.out.println("2 - Consultar leitor");
            System.out.println("3 - Listar leitores");
            System.out.println("4 - Atualizar leitor");
            System.out.println("5 - Remover leitor");
            System.out.println("6 - Cadastrar livro");
            System.out.println("7 - Consultar livro");
            System.out.println("8 - Listar livros");
            System.out.println("9 - Atualizar livro");
            System.out.println("10 - Remover livro");
            System.out.println("11 - Registrar empréstimo");
            System.out.println("12 - Listar empréstimos");
            System.out.println("13 - Registrar devolução");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: // Cadastrar leitor
                        Leitor lt1 = new Leitor(10, "Ana", "ana@email.com");
                        biblioteca.cadastrarLeitor(lt1);
                        
                        Leitor lt2 = new Leitor(10, "Pedro", "pedro@email.com");
                        biblioteca.cadastrarLeitor(lt2);
                        break;
                        
                    case 2: // Consultar leitor
                        
                        break;
                        
                    case 3: // Listar leitores
                        biblioteca.listarLeitores();
                        break;

                    case 4: // Atualizar leitor
                        
                        break;

                    case 5: // Remover leitor
                        
                        break;

                    case 6: // Cadastrar livro
                        
                        break;

                    case 7: // Consultar livro
                        
                        break;

                    case 8: // Listar livros
                        biblioteca.listarLivros();
                        break;

                    case 9: // Atualizar livro
                        
                        break;

                    case 10: // Remover livro
                        
                        break;

                    case 11: // Registrar empréstimo
                        
                        break;

                    case 12: // Listar empréstimos
                        biblioteca.listarEmprestimos();
                        break;

                    case 13: // Registrar devolução
                        
                        break;
    
                    case 0:
                        System.out.println("Aplicação encerrada.");
                        break;
                        
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        } while (opcao != 0);
        scanner.close();
    }  
}
