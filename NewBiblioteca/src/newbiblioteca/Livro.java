/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newbiblioteca;

/**
 *
 * @author leand
 */
public class Livro {
    private String nome,autor;
    private int ano;
    
    Livro(String nome,String autor, int ano){
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;    
    }
    
    Livro(){
    
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public String getNome(){
        return this.nome;
    }
    public String getAutor(){
        return this.autor;
    }
    public int getAno(){
        return this.ano;
    }
}
