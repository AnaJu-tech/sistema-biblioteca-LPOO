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
        if (livro == null){
            return false;
        }
        for (ItemEmprestimo item : itens) {
            if (item.getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarLivro(Livro livro) {
        if(livro != null && livro.isDisponivel()){
            if (contemLivro(livro)) {
                return false;
            }
            livro.emprestar();
            ItemEmprestimo item = new ItemEmprestimo(livro);
            itens.add(item);
            return true;
        }
        return false;
    }

    public void finalizar() {
        for (ItemEmprestimo item : itens) {
            if(!item.isDevolvido()){
                item.registrarDevolucao();    
            }    
        }
        this.aberto = false;
    }

    public String toString(){
        String livros = "";
        String situacao = "";
        
        if(this.aberto == true){
            situacao = "aberto";
        }else{
            situacao = "fechado";
        }
        
        for (int i = 0; i < itens.size(); i++){
            livros += itens.get(i).getLivro().getTitulo();
            if(i < itens.size() - 1){
                livros += ", ";
            }
        }
        return this.leitor + " - " + this.dataEmprestimo + " - " + 
                situacao + " - " + livros;
    }
}
