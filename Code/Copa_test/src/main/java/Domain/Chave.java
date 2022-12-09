/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author leand
 */
public class Chave {
    private int id;
    private int timeId1;
    private int timeId2;
    private int timeId3;
    private int timeId4;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeId1() {
        return timeId1;
    }

    public void setTimeId1(int timeId1) {
        this.timeId1 = timeId1;
    }

    public int getTimeId2() {
        return timeId2;
    }

    public void setTimeId2(int timeId2) {
        this.timeId2 = timeId2;
    }

    public int getTimeId3() {
        return timeId3;
    }

    public void setTimeId3(int timeId3) {
        this.timeId3 = timeId3;
    }

    public int getTimeId4() {
        return timeId4;
    }

    public void setTimeId4(int timeId4) {
        this.timeId4 = timeId4;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Chave(int timeId1, int timeId2, int timeId3, int timeId4, String nome) {
        this.timeId1 = timeId1;
        this.timeId2 = timeId2;
        this.timeId3 = timeId3;
        this.timeId4 = timeId4;
        this.nome = nome;
    }

    public Chave(String nome) {
        this.nome = nome;
    }
    
    
}
