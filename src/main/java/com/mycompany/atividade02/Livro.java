package com.mycompany.atividade02;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true; //Livro sempre nasce disponível
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void atualizarDados(String titulo, String autor){ 
        if(titulo != null && !titulo.isBlank()){
            this.titulo = titulo;
        }
        if(autor != null && !autor.isBlank()){
            this.autor = autor;
        }    
    }

    public void emprestar(){ 
        this.disponivel = false; //Ao emprestar, o livro torna-se indisponível
    }

    public void devolver(){ 
        this.disponivel = true; //Ao devolver,o livro torna-se disponível
    }

    public String toString(){
        String status;
        if (disponivel == true) {
            status = "Disponível";
        } else {
            status = "Indisponível";
        }
        return codigo + " - " + titulo + "(" + autor + ") - " + status;
    }
    
}
