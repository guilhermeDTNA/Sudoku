/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author guilherme
 */
public class ValoresFixos {

    private int linha;
    private int coluna;
    private int valor;

    public ValoresFixos(int linha, int coluna, int valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean getDisponibilidade(int linha, int coluna) {
        if (this.linha == linha && this.coluna == coluna) {
            return false; //Se já tiver o mesmo valor na linha e coluna
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Linha: " + getLinha() + " Coluna: " + getColuna() + " Valor: " + getValor() + "\n";
    }

}
