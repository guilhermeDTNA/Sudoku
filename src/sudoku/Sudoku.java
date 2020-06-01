/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilherme
 */
public class Sudoku {

    static Sudoku programa = new Sudoku();

    protected static int linhas[];
    protected static int colunas[];
    protected Quadro quadro;
    protected static List<Quadro> quadros = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LeituraArquivo.lerArq();
        programa.armazenaValoresQuadros();
    }

    public void armazenaValoresQuadros() {
        int contadorValor = 0;
        int contadorQuadro = 0;

        if (LeituraArquivo.dimensoes == 9) {

            for (int i = 0; i < 9; i++) {
                if (i == 0) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2]);
                }

                if (i == 1) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[0][4], LeituraArquivo.matriz[0][5], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[1][4], LeituraArquivo.matriz[1][5], LeituraArquivo.matriz[2][3], LeituraArquivo.matriz[2][4], LeituraArquivo.matriz[2][5]);
                }

                if (i == 2) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[0][6], LeituraArquivo.matriz[0][7], LeituraArquivo.matriz[0][8], LeituraArquivo.matriz[1][6], LeituraArquivo.matriz[1][7], LeituraArquivo.matriz[1][8], LeituraArquivo.matriz[2][6], LeituraArquivo.matriz[2][7], LeituraArquivo.matriz[2][8]);
                }

                if (i == 3) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[3][0], LeituraArquivo.matriz[3][1], LeituraArquivo.matriz[3][2], LeituraArquivo.matriz[4][0], LeituraArquivo.matriz[4][1], LeituraArquivo.matriz[4][2], LeituraArquivo.matriz[5][0], LeituraArquivo.matriz[5][1], LeituraArquivo.matriz[5][2]);
                }

                if (i == 4) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[3][3], LeituraArquivo.matriz[3][4], LeituraArquivo.matriz[3][5], LeituraArquivo.matriz[4][3], LeituraArquivo.matriz[4][4], LeituraArquivo.matriz[4][5], LeituraArquivo.matriz[5][3], LeituraArquivo.matriz[5][4], LeituraArquivo.matriz[5][5]);
                }

                if (i == 5) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[3][6], LeituraArquivo.matriz[3][7], LeituraArquivo.matriz[3][8], LeituraArquivo.matriz[4][6], LeituraArquivo.matriz[4][7], LeituraArquivo.matriz[4][8], LeituraArquivo.matriz[5][6], LeituraArquivo.matriz[5][7], LeituraArquivo.matriz[5][8]);
                }

                if (i == 6) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[6][0], LeituraArquivo.matriz[6][1], LeituraArquivo.matriz[6][2], LeituraArquivo.matriz[7][0], LeituraArquivo.matriz[7][1], LeituraArquivo.matriz[7][2], LeituraArquivo.matriz[8][0], LeituraArquivo.matriz[8][1], LeituraArquivo.matriz[8][2]);
                }

                if (i == 7) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[6][3], LeituraArquivo.matriz[6][4], LeituraArquivo.matriz[6][5], LeituraArquivo.matriz[7][3], LeituraArquivo.matriz[7][4], LeituraArquivo.matriz[7][5], LeituraArquivo.matriz[8][3], LeituraArquivo.matriz[8][4], LeituraArquivo.matriz[8][5]);
                }

                if (i == 8) {
                    quadro = new Quadro();
                    quadro.inserir9(LeituraArquivo.matriz[6][6], LeituraArquivo.matriz[6][7], LeituraArquivo.matriz[6][8], LeituraArquivo.matriz[7][6], LeituraArquivo.matriz[7][7], LeituraArquivo.matriz[7][8], LeituraArquivo.matriz[8][6], LeituraArquivo.matriz[8][7], LeituraArquivo.matriz[8][8]);
                }

                quadros.add(quadro);

            }
            int indiceQuadrante = contadorQuadro + 1;

            while (contadorQuadro < 9) {
                System.out.println(indiceQuadrante + "º quadrante:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(quadros.get(contadorQuadro).getNumeros(contadorValor));
                        contadorValor++;
                    }
                    System.out.println("");
                }
                contadorValor = 0;
                contadorQuadro++;
                indiceQuadrante++;
            }

        } else if (LeituraArquivo.dimensoes == 15) {
            //quadros = new Quadro(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[0][4], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[1][4], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2], LeituraArquivo.matriz[2][3], LeituraArquivo.matriz[2][4]);
        } else if (LeituraArquivo.dimensoes == 12) {
            //quadros = new Quadro(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2], LeituraArquivo.matriz[2][3]);

        } else {
            System.out.println("Sudokus de dimensões iguais a " + LeituraArquivo.dimensoes + "/" + LeituraArquivo.dimensoes + " ainda não podem ser solcionados");
        }
    }
    
    public void insereNumeros(){
        
    }
    
    

}
