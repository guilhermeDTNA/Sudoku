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
public class Quadro {

    private int numeros[];

    //Para 9 valores por quadro
    public void inserir9(int n0, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {

        this.numeros = new int[9];

        setNumeros(0, n0);
        setNumeros(1, n1);
        setNumeros(2, n2);
        setNumeros(3, n3);
        setNumeros(4, n4);
        setNumeros(5, n5);
        setNumeros(6, n6);
        setNumeros(7, n7);
        setNumeros(8, n8);
    }

    //Para 15 valores por quadro
    public void inserir15(int n0, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14) {

        setNumeros(0, n0);
        setNumeros(1, n1);
        setNumeros(2, n2);
        setNumeros(3, n3);
        setNumeros(4, n4);
        setNumeros(5, n5);
        setNumeros(6, n6);
        setNumeros(7, n7);
        setNumeros(8, n8);
        setNumeros(9, n9);
        setNumeros(10, n10);
        setNumeros(11, n11);
        setNumeros(12, n12);
        setNumeros(13, n13);
        setNumeros(14, n14);
    }

    //Para 12 valores por quadro
    public void inserir12(int n0, int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11) {

        setNumeros(0, n0);
        setNumeros(1, n1);
        setNumeros(2, n2);
        setNumeros(3, n3);
        setNumeros(4, n4);
        setNumeros(5, n5);
        setNumeros(6, n6);
        setNumeros(7, n7);
        setNumeros(8, n8);
        setNumeros(9, n9);
        setNumeros(10, n10);
        setNumeros(11, n11);
    }

    public int getNumeros(int posicao) {
        return numeros[posicao];
    }

    public void getNumeros() {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }

    public void setNumeros(int posicao, int valor) {
        this.numeros[posicao] = valor;
    }

    public boolean getDisponibilidade(int valor) {
        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            if (this.numeros[i] == valor) {
                return false; //Se já tiver o mesmo valor no mesmo quadro
            }

        }
        return true;
    }

}
