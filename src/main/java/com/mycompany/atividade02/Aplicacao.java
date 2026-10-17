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
        
        while (opcao != 0) {
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
            
            if(!scanner.hasNextInt()){
                System.out.println("Opção inválida.");
                scanner.next();
                continue;
            }
            
            opcao = Integer.parseInt(scanner.nextLine());
            
            switch (opcao) {
                    
                case 1: // Cadastrar leitor
                    System.out.print("Código do leitor: ");
                    int codL = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nomeL = scanner.nextLine();
                    System.out.print("E-mail: ");
                    String emailL = scanner.nextLine();

                    Leitor novoLeitor = new Leitor(codL, nomeL, emailL);
                    biblioteca.cadastrarLeitor(novoLeitor);
                    break;

                case 2: // Consultar leitor
                    System.out.print("Código do leitor a consultar: ");
                    int codConsL = scanner.nextInt();

                    Leitor leitorConsultado = biblioteca.consultarLeitor(codConsL);
                    break;

                case 3: // Listar leitores
                    biblioteca.listarLeitores();
                    break;

                case 4: // Atualizar leitor
                    System.out.print("Código do leitor a atualizar: ");
                    int codAtuLeitor = scanner.nextInt();
                    scanner.nextLine();

                    Leitor leitorAtu = biblioteca.consultarLeitor(codAtuLeitor);

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo e-mail: ");
                    String novoEmail = scanner.nextLine();

                    biblioteca.atualizarLeitor(codAtuLeitor, novoNome, novoEmail);
                    break;

                case 5: // Remover leitor
                    System.out.print("Código do leitor a remover: ");
                    int codRemLeitor = scanner.nextInt();
                    Leitor leitorRemov = biblioteca.consultarLeitor(codRemLeitor);

                    biblioteca.removerLeitor(leitorRemov);
                    break;

                case 6: // Cadastrar livro
                    System.out.print("Código do livro: ");
                    int codLivro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    Livro novoLivro = new Livro(codLivro, titulo, autor);
                    biblioteca.cadastrarLivro(novoLivro);
                    break;

                case 7: // Consultar livro
                    System.out.print("Código do livro a consultar: ");
                    int codConsLiv = scanner.nextInt();

                    Livro livConsultado = biblioteca.consultarLivro(codConsLiv);
                    break;

                case 8: // Listar livros
                    biblioteca.listarLivros();
                    break;

                case 9: // Atualizar livro
                    System.out.print("Código do livro a atualizar: ");
                    int codAtuLivro = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroAtu = biblioteca.consultarLivro(codAtuLivro);

                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Novo autor: ");
                    String novoAutor = scanner.nextLine();

                    biblioteca.atualizarLivro(codAtuLivro, novoTitulo, novoAutor);
                    break;

                case 10: // Remover livro
                    System.out.print("Código do livro a remover: ");
                    int codRemLivro = scanner.nextInt();

                    Livro livroRem = biblioteca.consultarLivro(codRemLivro);
                    biblioteca.removerLivro(livroRem);
                    break;

                case 11: // Registrar empréstimo
                    System.out.print("Código do empréstimo: ");
                    int codEmprest = scanner.nextInt();
                    System.out.print("Código do leitor: ");
                    int codLeitorEmprest = scanner.nextInt();

                    Leitor leitorEmprest = biblioteca.consultarLeitor(codLeitorEmprest);

                    ArrayList<Livro> livrosEmprest = new ArrayList<>();
                    int codLivEmprest = -1;
                    while (true) {
                        System.out.print("Digite o código do livro a ser adicionado ou 0 para encerrar: ");
                        codLivEmprest = scanner.nextInt();

                        if (codLivEmprest == 0) {
                            break;
                        }else{
                            Livro livroEmprest = biblioteca.consultarLivro(codLivEmprest);

                            if (livroEmprest != null) {
                                livrosEmprest.add(livroEmprest);
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                        }    
                    }

                    biblioteca.registrarEmprestimo(codEmprest, leitorEmprest, livrosEmprest);
                    break;

                case 12: // Listar empréstimos
                    biblioteca.listarEmprestimos();
                    break;

                case 13: // Registrar devolução
                    System.out.print("Código do empréstimo para devolução: ");
                    int codEmprestDevol = scanner.nextInt();

                    biblioteca.registrarDevolucao(codEmprestDevol);
                    break;

                case 0:
                    System.out.println("Aplicação encerrada.");
                    break;
            
                default:
                    System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }  
}
