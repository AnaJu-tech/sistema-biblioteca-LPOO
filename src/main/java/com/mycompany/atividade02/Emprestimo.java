package com.mycompany.atividade02;
import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {
    private int codigo;
    private LocalDate dataEmprestimo;
    private boolean aberto;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens = new ArrayList<ItemEmprestimo>();

    public Emprestimo(int codigo, Leitor leitor) {
        this.codigo = codigo;
        this.dataEmprestimo = LocalDate.now();
        this.aberto = true;
        this.leitor = leitor;
        this.itens = itens;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isAberto() {
        return aberto;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public ArrayList<ItemEmprestimo> getItens() {
        return itens;
    }
    
    public boolean contemLivro(Livro livro) {
        for (ItemEmprestimo item : itens) {
            if (item.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarLivro(Livro livro) {
        if (livro == null || !livro.isDisponivel()) {
            return false;
        }
        if (contemLivro(livro)) {
            return false;
        }

        ItemEmprestimo item = new ItemEmprestimo(livro);
        itens.add(item);
        return true;
    }

    public void finalizar() {
        this.aberto = false;
        for (ItemEmprestimo item : itens) {
            item.registrarDevolucao();
            item.getLivro().devolver();
        }
    }

}
