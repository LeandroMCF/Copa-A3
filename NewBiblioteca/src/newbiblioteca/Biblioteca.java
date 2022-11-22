/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package newbiblioteca;

/**
 *
 * @author leand
 */

import java.util.Scanner;

public class Biblioteca {
    private int numeroLivros;
    private Livro[] livros;
   
    Biblioteca(int numeroLivros){
        this.numeroLivros = numeroLivros;
        this.livros = new Livro[numeroLivros];
    }
    public void adicionarTodosLivros(){
        Scanner meuObjeto = new Scanner(System.in);
        String nome, autor;
        int ano;
            
        for(int i=0;i<this.numeroLivros;i++){
            System.out.println("Digite o nome do Livro(" 
                    + (i+1) + ")");
            nome = meuObjeto.nextLine();
            System.out.println("Adicionei o nome do Livro");
            System.out.println("Digite o nome do autor do Livro("
            + (i+1) + ")");
            autor = meuObjeto.nextLine();
            System.out.println("Digite o ano do Livro("
            + (i+1)+ ")");
            ano = meuObjeto.nextInt();
            meuObjeto.nextLine();
            livros[i] = new Livro(nome,autor,ano);           
        }        
    }
    
    public void mostrarTodosLivros(){
        for(int i=0;i<this.numeroLivros;i++){
            System.out.println("O nome do Livro(" +
             (i+1) + ") eh: " + livros[i].getNome() +
             " o seu autor eh: " + livros[i].getAutor() +
             " foi publicado em: " + livros[i].getAno());
        }
    }
}
