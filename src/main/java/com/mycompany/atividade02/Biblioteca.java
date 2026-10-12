package com.mycompany.atividade02;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Leitor> leitores = new ArrayList<Leitor>();
    private ArrayList<Livro> livros = new ArrayList<Livro>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    
    // --- LEITORES ---
    public boolean cadastrarLeitor(Leitor leitor){ 
        if(leitor == null || consultarLeitor(leitor.getCodigo()) != null){ //Objeto nulo ou leitor já existente
            System.out.println("Não foi possível cadastrar o leitor.");
            return false;
        }else{
            leitores.add(leitor);
            System.out.println("Leitor cadastrado.");
            return true;
        }
    }
    
    public Leitor consultarLeitor(int codigo){
        for(Leitor l : leitores){
            if(l.getCodigo() == codigo){
                System.out.println(l.toString());
            }else{
                System.out.println("Registro não encontrado");
            }
        }
        return null;
    }
    
    public void listarLeitores(){
        if(leitores.isEmpty()){
            System.out.println("Nenhum leitor cadastrado");
        }else{
            for(Leitor l : leitores){
                System.out.println(l.toString());
            }
        }  
    }
    
    public boolean removerLeitor(Leitor leitor) {
        if (leitor == null) {
            return false;
        }else{
            for (Emprestimo e : emprestimos) {
                if (e.isAberto() && e.getLeitor().equals(leitor)) {
                    System.out.println("Leitor não removido. Há empréstimo aberto.");
                    return false;
                }
            }
            leitores.remove(leitor);
            System.out.println("Leitor removido.");
            return true;
        }    
    }
    
    
    // --- LIVROS ---
    public boolean cadastrarLivro(Livro livro) {
        if (livro == null || consultarLivro(livro.getCodigo()) != null) {
            System.out.println("Não foi possível cadastrar o livro.");
            return false;
        }else{
            livros.add(livro);
            System.out.println("Livro cadastrado.");
            return true;
        }
    }

    public Livro consultarLivro(int codigo) {
        for (Livro l : livros) {
            if (l.getCodigo() == codigo) {
                return l;
            }
        }
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        }
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    public boolean removerLivro(Livro livro) {
        if (livro == null) {
            return false;
        }

        for (Emprestimo e : emprestimos) {
            if (e.isAberto() && e.contemLivro(livro)) {
                System.out.println("Livro não removido. Vinculado a empréstimo aberto.");
                return false;
            }
        }
        livros.remove(livro);
        System.out.println("Livro removido.");
        return true;
    }

    // --- EMPRÉSTIMOS ---
    public boolean registrarEmprestimo(int codigoEmprestimo, Leitor leitor, ArrayList<Livro> livrosEscolhidos) {
        if (leitor == null || livrosEscolhidos == null || livrosEscolhidos.isEmpty()) {
            System.out.println("Não foi possível registrar o empréstimo.");
            return false;
        }

        // Verifica se o código do empréstimo já existe
        for (Emprestimo e : emprestimos) {
            if (e.getCodigo() == codigoEmprestimo) {
                System.out.println("Código de empréstimo já existente.");
                return false;
            }
        }

        Emprestimo novoEmprestimo = new Emprestimo(codigoEmprestimo, leitor);
        int adicionados = 0;

        for (Livro livro : livrosEscolhidos) {
            if (novoEmprestimo.adicionarLivro(livro)) {
                livro.emprestar(); // RN10
                adicionados++;
            }
        }

        if (adicionados == 0) {
            System.out.println("Não foi possível registrar o empréstimo.");
            return false;
        }

        emprestimos.add(novoEmprestimo);
        System.out.println("Empréstimo registrado.");
        return true;
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }

    public boolean registrarDevolucao(int codigoEmprestimo) {
        for (Emprestimo e : emprestimos) {
            if (e.getCodigo() == codigoEmprestimo) {
                if (!e.isAberto()) {
                    System.out.println("Empréstimo já finalizado anteriormente.");
                    return false;
                }
                e.finalizar();
                System.out.println("Devolução registrada.");
                return true;
            }
        }
        System.out.println("Registro não encontrado.");
        return false;
    }
}

