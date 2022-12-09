/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.sql.Date;

/**
 *
 * @author leand
 */
public class Partidas {
    private int id;
    private int timeId1;
    private int timeId2;
    private int placarTime1;
    private int placarTime2;
    private Date dataPartida;
    private String local;

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

    public int getPlacarTime1() {
        return placarTime1;
    }

    public void setPlacarTime1(int placarTime1) {
        this.placarTime1 = placarTime1;
    }

    public int getPlacarTime2() {
        return placarTime2;
    }

    public void setPlacarTime2(int placarTime2) {
        this.placarTime2 = placarTime2;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Partidas(int timeId1, int timeId2, int placarTime1, int placarTime2, Date dataPartida, String local) {
        this.timeId1 = timeId1;
        this.timeId2 = timeId2;
        this.placarTime1 = placarTime1;
        this.placarTime2 = placarTime2;
        this.dataPartida = dataPartida;
        this.local = local;
    }
    
    
}
