/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author guilherme
 */
public class Sudoku {

    static Sudoku programa = new Sudoku();
    Random gerador = new Random();
    protected Quadro quadro;
    protected static List<Quadro> quadros = new ArrayList<>();

    protected static int linha;
    protected static int coluna;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LeituraArquivo.lerArq();
        programa.armazenaValoresQuadros();
        programa.insereNumeros();

        while (programa.analisaMatriz() == false) {
            programa.insereNumeros();
        }
        programa.exibirMatriz();

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
            /*
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
            }*/

        } else if (LeituraArquivo.dimensoes == 15) {
            //quadros = new Quadro(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[0][4], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[1][4], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2], LeituraArquivo.matriz[2][3], LeituraArquivo.matriz[2][4]);
        } else if (LeituraArquivo.dimensoes == 12) {
            //quadros = new Quadro(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2], LeituraArquivo.matriz[2][3]);

        } else {
            System.out.println("Sudokus de dimensões iguais a " + LeituraArquivo.dimensoes + "/" + LeituraArquivo.dimensoes + " ainda não podem ser solcionados");
        }
    }

    public boolean insereNumeros() {

        int numero = geraNumero();
        int contador = 0;

        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
                if ((verificaDisponibilidadeValoresFixos(i, j) == false)) { //Já existe um valor fixo na linha e coluna
                    
                } else if (verificaDisponibilidade(numero, i, j) == false) { //Já existe o valor na linha ou coluna
                    do {
                        numero = geraNumero();
                        
                        contador++;
                    } while ((contador <= LeituraArquivo.dimensoes) && (verificaDisponibilidade(numero, i, j) == false));
                    if (contador > LeituraArquivo.dimensoes) {
                        substituiNumeros(numero);
                    }

                } else if (analisaQuadrantes(numero, i, j) == false) {
                    contador = 0;
                    do {
                        numero = geraNumero();
                        /*
                        if (j == 0) {
                            i--;
                        } else {
                            j--;
                        }
*/
                        contador++;
                    } while ((contador <= LeituraArquivo.dimensoes) && (analisaQuadrantes(numero, i, j) == false));
                    if (contador > LeituraArquivo.dimensoes) {
                        substituiNumeros(numero);
                    }

                } else {
                    LeituraArquivo.matriz[i][j] = numero; //Insere o número na matriz
                }
            }
        }
        return true;
    }

    public void substituiNumeros(int valor) {

        int numero = geraNumero();
        int contador = 0;

        if (verificaDisponibilidade(numero, Sudoku.linha, Sudoku.coluna) == false) { //Já existe o valor na linha ou coluna
            do {
                numero = geraNumero();
                contador++;

                if (contador >= LeituraArquivo.dimensoes) { //Se já tentou todas as opções, retorna à matriz original
                    insereNumeros();
                }
            } while (verificaDisponibilidade(numero, linha, coluna) == false);

        } if (analisaQuadrantes(numero, linha, coluna) == false) {
            contador = 0;
            do {
                numero = geraNumero();
                contador++;

                if (contador >= LeituraArquivo.dimensoes) { //Se já tentou todas as opções, retorna à matriz original
                    insereNumeros();
                }
            } while (analisaQuadrantes(numero, linha, coluna) == false);

        } if((verificaDisponibilidade(numero, linha, coluna) == true)&&(analisaQuadrantes(numero, linha, coluna) == true))
            LeituraArquivo.matriz[linha][coluna] = numero; //Insere o número na matriz
        

    }

    public int geraNumero() {
        int numero;
        numero = gerador.nextInt(LeituraArquivo.dimensoes) + 1; //Gera um número aleatório

        return numero;
    }

    public boolean verificaDisponibilidadeValoresFixos(int linha, int coluna) {

        for (ValoresFixos valor : LeituraArquivo.valores) {
            if (valor.getDisponibilidade(linha, coluna) == false) { //Se já existir um valor fixo na posição
                return false;
            }
        }

        return true;
    }

    public boolean verificaDisponibilidade(int numero, int linha, int coluna) { //Se o 
        for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
            if (LeituraArquivo.matriz[linha][j] == numero) { //Verifica se ele já está na linha
                Sudoku.linha = linha;
                Sudoku.coluna = j;
                return false;
            }
        }

        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            if (LeituraArquivo.matriz[i][coluna] == numero) { //Verifica se ele já está na coluna
                Sudoku.linha = i;
                Sudoku.coluna = coluna;
                return false;
            }
        }

        return true;
    }

    public boolean analisaQuadrantes(int numero, int i, int j) {
        if ((i >= 0 && i <= 2) && (j >= 0 && j <= 2)) { //primeiro quadrante
            if (verificaDisponibilidade(numero, 1) == false) {
                return false;
            }
        } else if ((i >= 0 && i <= 2) && (j >= 3 && j <= 5)) { //segundo quadrante
            if (verificaDisponibilidade(numero, 2) == false) {
                return false;
            }
        } else if ((i >= 0 && i <= 2) && (j >= 6 && j <= 8)) { //terceiro quadrante
            if (verificaDisponibilidade(numero, 3) == false) {
                return false;
            }
        } else if ((i >= 3 && i <= 5) && (j >= 0 && j <= 2)) { //quarto quadrante
            if (verificaDisponibilidade(numero, 4) == false) {
                return false;
            }
        } else if ((i >= 3 && i <= 5) && (j >= 3 && j <= 5)) { //quinto quadrante
            if (verificaDisponibilidade(numero, 5) == false) {
                return false;
            }
        } else if ((i >= 3 && i <= 5) && (j >= 6 && j <= 8)) { //sexto quadrante
            if (verificaDisponibilidade(numero, 6) == false) {
                return false;
            }
        } else if ((i >= 6 && i <= 8) && (j >= 0 && j <= 2)) { //sétimo quadrante
            if (verificaDisponibilidade(numero, 7) == false) {
                return false;
            }
        } else if ((i >= 6 && i <= 8) && (j >= 3 && j <= 5)) { //oitavo quadrante
            if (verificaDisponibilidade(numero, 8) == false) {
                return false;
            }
        } else if ((i >= 6 && i <= 8) && (j >= 6 && j <= 8)) { //nono quadrante
            if (verificaDisponibilidade(numero, 9) == false) {
                return false;
            }
        }
        return true;
    }

    public boolean verificaDisponibilidade(int numero, int quadrante) {

        for (Quadro valor : Sudoku.quadros) {
            if (valor.getDisponibilidade(numero) == false) { //Se já existir o valor no quadro
                return false;
            }
        }

        return true;
    }

    public boolean analisaMatriz() {
        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
                if (LeituraArquivo.matriz[i][j] == 0) {
                    System.out.println("Ainda existe célula não preenchida, como a da linha " + i + " e coluna " + j);
                    return false;
                }
            }
        }
        return true;
    }

    public void exibirMatriz() {
        int contador = 0;
        System.out.println("Sudoku resolvido:\n");
        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
                if ((contador % 9 == 0) && (contador != 3)) {
                    System.out.print("\n" + LeituraArquivo.matriz[i][j] + "\t");
                } else {
                    System.out.print(LeituraArquivo.matriz[i][j] + "\t");
                }
                contador++;
            }

        }
    }

}
