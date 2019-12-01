package com.tarcisio.ruconnected.Model;

public class Cardapio {

    private Comida comida[];
    private String data;


    public Cardapio(String data){
        this.comida = new Comida[16];
        this.data = data;
    }


    public void addComida(Comida comida, int posicao){
        this.comida[posicao] = comida;
    }

    public Comida[] getComida() {
        return comida;
    }

    public void setComida(Comida[] comida) {
        this.comida = comida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
