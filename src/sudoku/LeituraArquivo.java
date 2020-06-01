/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class LeituraArquivo {

    protected static int matriz[][];
    protected static int dimensoes;
    protected static List<ValoresFixos> valores = new ArrayList<>();

    //Lê o arquivo
    public static void lerArq() throws FileNotFoundException, IOException {
        int i = 0;
        int j = 0;
        Scanner ler = new Scanner(System.in);
        //System.out.printf("\nConteúdo do arquivo de texto:\n");
        BufferedReader br = new BufferedReader(new FileReader("arq.txt"));

        String array[] = new String[1]; //Define para a primeira linha

        while (br.ready()) {
            String linha = br.readLine();

            array = linha.split(" ");

            //Se estiver na primeira linha é a dimensão da matriz
            if (i == 0) {
                //linhas = new int[Integer.parseInt(array[0])];
                //colunas = new int[Integer.parseInt(array[0])];
                //quadros = new int[Integer.parseInt(array[0])];
                dimensoes = Integer.parseInt(array[0]);
                matriz = new int[dimensoes][dimensoes];

                array = new String[dimensoes];
                //j = Integer.parseInt(array[0]);

            } else if (i >= 1) {  //Se for maior ou igual a 1 já é a matriz

                for (j = 0; j < dimensoes; j++) {
                    if (Integer.parseInt(array[j]) != 0) { //Se tiver um valor fixo
                        ValoresFixos valor = new ValoresFixos(i - 1, j, Integer.parseInt(array[j]));
                        valores.add(valor);
                        matriz[i - 1][j] = valor.getValor(); //Como começa do 0 o vetor, precisa ser i-1
                    }
                    else{
                        matriz[i - 1][j] = 0;
                    }
                }
            }

            i++;
        }
        /*

        System.out.printf("Dimensão da matriz: linhas:colunas " + dimensoes + ":" + dimensoes+"\n");
        System.out.println("Números fixos: linha:coluna:valor: ");

        for (int k = 0; k < valores.size(); k++) {
            System.out.print(valores.get(k));
        }

        System.out.println("\nMatriz:\n");

        for (int k = 0; k < dimensoes; k++) {
            for (int l = 0; l < dimensoes; l++) {
                System.out.println("Linha " + k + " Coluna " + l + " Valor: " + matriz[k][l]);
            }
        }
         */
        br.close();
    }
}
