package com.mycompany.atividade02;

public class Leitor {
    private int codigo;
    private String nome;
    private String email;
    
    public Leitor(int codigo, String nome, String email){ 
        if (codigo > 0 && !nome.isBlank() && !nome.isEmpty() && !email.isBlank() && !email.isEmpty()){
            this.codigo = codigo;
            this.nome = nome;
            this.email = email;
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean atualizarDados(String nome, String email){ 
        if(nome != null && !nome.isBlank() && email != null && !email.isBlank()){
            this.nome = nome;
            this.email = email;
            return true;
        }
        return false;    
    }

    public String toString(){
        return codigo + " - " + nome + "(" + email + ")";
    }
}
