package com.tarcisio.ruconnected.Model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private String data;
    private String prato1;
    private String prato2;
    private String prato3;
    private String prato4;
    private String prato5;
    private String prato6;
    private String prato7;
    private int tipo;


    public Cardapio(){

    }

    public Cardapio(String data, String prato1, String prato2, String prato3, String prato4, String prato5, String prato6, String prato7, int tipo) {
        this.data = data;
        this.prato1 = prato1;
        this.prato2 = prato2;
        this.prato3 = prato3;
        this.prato4 = prato4;
        this.prato5 = prato5;
        this.prato6 = prato6;
        this.prato7 = prato7;
        this.tipo = tipo;
    }

    public String getPrato1() {
        return prato1;
    }

    public void setPrato1(String prato1) {
        this.prato1 = prato1;
    }

    public String getPrato2() {
        return prato2;
    }

    public void setPrato2(String prato2) {
        this.prato2 = prato2;
    }

    public String getPrato3() {
        return prato3;
    }

    public void setPrato3(String prato3) {
        this.prato3 = prato3;
    }

    public String getPrato4() {
        return prato4;
    }

    public void setPrato4(String prato4) {
        this.prato4 = prato4;
    }

    public String getPrato5() {
        return prato5;
    }

    public void setPrato5(String prato5) {
        this.prato5 = prato5;
    }

    public String getPrato6() {
        return prato6;
    }

    public void setPrato6(String prato6) {
        this.prato6 = prato6;
    }

    public String getPrato7() {
        return prato7;
    }

    public void setPrato7(String prato7) {
        this.prato7 = prato7;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
