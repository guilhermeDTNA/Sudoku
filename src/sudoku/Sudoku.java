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

    //Após modificações
    private static int numeros[] = new int[9]; //contém todos os valores de 1 a 9
    private static int number; //valor da posição atual do vetor
    private static int contadorPosicao = 0; //verifica quantos números já foram gerados por posição da matriz
    private int contadorSequencia = 0;

    private static List<Integer> numerosGerados = new ArrayList<>(); //armazena quais números já foram gerados
    private static List<Integer> numerosAusentes = new ArrayList<>(); //armazena quais números estão faltando na linha

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        LeituraArquivo.lerArq();
        programa.armazenaValoresQuadros();
        geraNumerosEstaticos();

        do {

            programa.insereNumeros();

            programa.contadorSequencia++;
        } while (programa.analisaMatriz() == false);

        programa.exibirMatriz();

    }

    public static void geraNumerosEstaticos() {
        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            numeros[i] = i + 1;
        }
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

        } else if (LeituraArquivo.dimensoes == 15) {
            //quadros = new Quadro(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[0][4], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[1][4], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2], LeituraArquivo.matriz[2][3], LeituraArquivo.matriz[2][4]);
        } else if (LeituraArquivo.dimensoes == 12) {
            //quadros = new Quadro(LeituraArquivo.matriz[0][0], LeituraArquivo.matriz[0][1], LeituraArquivo.matriz[0][2], LeituraArquivo.matriz[0][3], LeituraArquivo.matriz[1][0], LeituraArquivo.matriz[1][1], LeituraArquivo.matriz[1][2], LeituraArquivo.matriz[1][3], LeituraArquivo.matriz[2][0], LeituraArquivo.matriz[2][1], LeituraArquivo.matriz[2][2], LeituraArquivo.matriz[2][3]);

        } else {
            System.out.println("Sudokus de dimensões iguais a " + LeituraArquivo.dimensoes + "/" + LeituraArquivo.dimensoes + " ainda não podem ser solcionados");
        }
    }

    public void atribuiValores() {
        List<Integer> numerosPresentes = new ArrayList<>(); //armazena quais números estão faltando na linha

        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
                if (LeituraArquivo.matriz[i][j] == 0) {
                    numerosPresentes = insereValoresPresentes(i, numerosPresentes);
                    insereValoresAusentes(i, j, numerosPresentes);
                    atribuiValores(i, j, LeituraArquivo.matriz[i][j]);
                }
            }
        }
    }

    public List<Integer> insereValoresPresentes(int linha, List<Integer> numeros) {
        for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
            if (LeituraArquivo.matriz[linha][j] != 0) {
                numeros.add(LeituraArquivo.matriz[linha][j]);
            }
        }

        return numeros;
    }

    public void insereValoresAusentes(int linha, int coluna, List<Integer> numeros) {
        int contadorNumerosDiferentes = 0;

        for (int i = 0; i < this.numeros.length; i++) {
            for (int valor : numeros) {
                if (this.numeros[i] != numeros.get(i)) {
                    contadorNumerosDiferentes++;
                    if (contadorNumerosDiferentes == numeros.size()) {
                        numerosAusentes.add(numeros.get(i));
                    } else {
                        valor++;
                    }
                }
            }
        }
    }

    public void atribuiValores(int linha, int coluna, int valor) {
        //Atribui os um número ausente na célula e verifica onde ele já está, setando-o pra zero
        int posicao[] = new int[2];

        if (verificaDisponibilidadeValoresFixos(linha, coluna) == false) {
            return;
        } else {

            if (verificaDisponibilidadeValoresFixos(linha, coluna) == false) {
                return;
            } else {
                posicao[0] = retornaPosicoesLinha(valor, linha)[0];
                posicao[1] = retornaPosicoesLinha(valor, linha)[1];

                if (posicao[0] != -1) {
                    LeituraArquivo.matriz[posicao[0]][posicao[1]] = 0;

                    return;
                } else {
                    posicao[0] = retornaPosicoesColuna(valor, coluna)[0];
                    posicao[1] = retornaPosicoesColuna(valor, coluna)[1];

                    if (posicao[0] != -1) {
                        LeituraArquivo.matriz[posicao[0]][posicao[1]] = 0;
                        return;
                    }
                }

                int quadrante = retornaQuadrante(linha, coluna);

                if (verificaDisponibilidade(valor, quadrante) == false) {
                    LeituraArquivo.matriz[linha][coluna] = 0;
                    return;
                }

            }

        }

        //if(retornaPosicoesLinha(number, linha))
        retornaPosicoesColuna(number, coluna);
    }

    public boolean insereNumerosPosicaoDeterminada(int numero, int linha, int coluna) {

        //int numero = geraNumero();
        if (numero == 0) {
            numero = geraNumero();
        }

        if (coluna < LeituraArquivo.dimensoes) {
            for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
                for (int j = coluna; j < LeituraArquivo.dimensoes; j++) {
                    if (verificaZeros(i, j)) {
                        j = LeituraArquivo.dimensoes;
                    } else if ((verificaDisponibilidadeValoresFixos(i, j) == false)) { //Já existe um valor fixo na linha e coluna
                        j = LeituraArquivo.dimensoes;
                    } else if (verificaLinha(numero, i) == false) { //Já existe o valor na linha
                        //Sudoku.contadorPosicao++;
                        Sudoku.numerosGerados.add(numero);
                        verificaNumeros(numero, i, j);
                    } else if (verificaColuna(numero, j) == false) { //Já existe o valor na coluna
                        //Sudoku.contadorPosicao++;
                        Sudoku.numerosGerados.add(numero);
                        verificaNumeros(numero, i, j);
                    } else if (analisaQuadrantes(numero, i, j) == false) { //Já existe o valor no quadrante
                        //Sudoku.contadorPosicao++;
                        Sudoku.numerosGerados.add(numero);
                        verificaNumeros(numero, i, j);
                    } else {
                        LeituraArquivo.matriz[i][j] = numero;
                        Sudoku.contadorPosicao = 0;
                        limparNumerosGerados();
                        j = LeituraArquivo.dimensoes;
                    }

                }
            }
        } else {
            for (int i = linha + 1; i < LeituraArquivo.dimensoes; i++) {
                for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
                    if (verificaZeros(i, j)) {
                        j = LeituraArquivo.dimensoes;
                    } else if ((verificaDisponibilidadeValoresFixos(i, j) == false)) { //Já existe um valor fixo na linha e coluna
                        j = LeituraArquivo.dimensoes;
                    } else if (verificaLinha(numero, i) == false) { //Já existe o valor na linha
                        //Sudoku.contadorPosicao++;
                        Sudoku.numerosGerados.add(numero);
                        verificaNumeros(numero, i, j);
                    } else if (verificaColuna(numero, j) == false) { //Já existe o valor na coluna
                        //Sudoku.contadorPosicao++;
                        Sudoku.numerosGerados.add(numero);
                        verificaNumeros(numero, i, j);
                    } else if (analisaQuadrantes(numero, i, j) == false) { //Já existe o valor no quadrante
                        //Sudoku.contadorPosicao++;
                        Sudoku.numerosGerados.add(numero);
                        verificaNumeros(numero, i, j);
                    } else {
                        LeituraArquivo.matriz[i][j] = numero;
                        Sudoku.contadorPosicao = 0;
                        limparNumerosGerados();
                        j = LeituraArquivo.dimensoes;
                    }

                }
            }
        }
        return true;
    }

    public boolean insereNumeros() {

        int numero = geraNumero();

        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
                if (verificaZeros(i, j)) {
                    j = LeituraArquivo.dimensoes;
                } else if ((verificaDisponibilidadeValoresFixos(i, j) == false)) { //Já existe um valor fixo na linha e coluna
                    j = LeituraArquivo.dimensoes;
                } else if (verificaLinha(numero, i) == false) { //Já existe o valor na linha
                    //Sudoku.contadorPosicao++;
                    Sudoku.numerosGerados.add(numero);
                    verificaNumeros(numero, i, j);
                } else if (verificaColuna(numero, j) == false) { //Já existe o valor na coluna
                    //Sudoku.contadorPosicao++;
                    Sudoku.numerosGerados.add(numero);
                    verificaNumeros(numero, i, j);
                } else if (analisaQuadrantes(numero, i, j) == false) { //Já existe o valor no quadrante
                    //Sudoku.contadorPosicao++;
                    Sudoku.numerosGerados.add(numero);
                    verificaNumeros(numero, i, j);
                } else {
                    LeituraArquivo.matriz[i][j] = numero;
                    Sudoku.contadorPosicao = 0;
                    limparNumerosGerados();
                    j = LeituraArquivo.dimensoes;
                }

            }
        }
        return true;
    }

    public boolean verificaZeros(int linha, int coluna) {
        if (LeituraArquivo.matriz[linha][coluna] == 0) {
            return true;
        }
        return false;
    }

    public void verificaNumeros(int numero, int linhaAtual, int colunaAtual) {
        if (Sudoku.contadorPosicao <= 9) {
            //int gerador = geraNumero();
            if (numero == 0) {
                Sudoku.contadorPosicao = 0;
                limparNumerosGerados();
                numero = geraNumero();
                insereNumerosPosicaoDeterminada(numero, linhaAtual, colunaAtual + 1);
            } else if (numero == -1) {
                numero = geraNumero();
                Sudoku.contadorPosicao++;
                verificaNumeros(numero, linhaAtual, colunaAtual);
            }
        } else {
            Sudoku.contadorPosicao = 0;
            limparNumerosGerados();
            numero = geraNumero();
            insereNumerosPosicaoDeterminada(numero, linhaAtual, colunaAtual + 1);
        }
    }

    public int geraNumero() {
        int numero;
        numero = gerador.nextInt(LeituraArquivo.dimensoes) + 1; //Gera um número aleatório

        if (Sudoku.numerosGerados.size() == 9) {
            return 0; //já sorteou todos os números possíveis
        } else {
            for (int valor : Sudoku.numerosGerados) {
                if (valor == numero) {
                    return -1; //o número já foi sorteado
                }
            }
        }
        Sudoku.contadorPosicao++;
        return numero;

    }

    public void limparNumerosGerados() {
        for (int valor : Sudoku.numerosGerados) {
            Sudoku.numerosGerados.remove(valor);
        }
    }

    public boolean verificaDisponibilidadeValoresFixos(int linha, int coluna) {

        for (ValoresFixos valor : LeituraArquivo.valores) {
            if (valor.getDisponibilidade(linha, coluna) == false) { //Se já existir um valor fixo na posição
                return false;
            }
        }

        return true;
    }

    //Só verifica e retorna false=não pode inserir
    public boolean verificaLinha(int numero, int linha) {
        for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
            if (LeituraArquivo.matriz[linha][j] == numero) { //Verifica se ele já está na linha

                return false;
            }
        }
        return true;
    }

    public int[] retornaPosicoesLinha(int numero, int linha) {
        int posicao[] = new int[2];

        for (int j = 0; j < LeituraArquivo.dimensoes; j++) {
            if (LeituraArquivo.matriz[linha][j] == numero) { //Verifica se ele já está na linha
                posicao[0] = linha;
                posicao[1] = j;
                return posicao;
            }
        }
        posicao[0] = -1;
        posicao[1] = -1;
        return posicao;
    }

    public boolean verificaColuna(int numero, int coluna) {
        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            if (LeituraArquivo.matriz[i][coluna] == numero) { //Verifica se ele já está na linha
                //Sudoku.linha = linha;
                //Sudoku.coluna = j;
                return false;
            }
        }
        return true;
    }

    public int[] retornaPosicoesColuna(int numero, int coluna) {
        int posicao[] = new int[2];

        for (int i = 0; i < LeituraArquivo.dimensoes; i++) {
            if (LeituraArquivo.matriz[i][coluna] == numero) { //Verifica se ele já está na linha
                posicao[0] = i;
                posicao[1] = coluna;
                return posicao;
            }
        }
        posicao[0] = -1;
        posicao[1] = -1;
        return posicao;
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

    public int retornaQuadrante(int i, int j) {
        if ((i >= 0 && i <= 2) && (j >= 0 && j <= 2)) { //primeiro quadrante
            return 1;
        } else if ((i >= 0 && i <= 2) && (j >= 3 && j <= 5)) { //segundo quadrante
            return 2;
        } else if ((i >= 0 && i <= 2) && (j >= 6 && j <= 8)) { //terceiro quadrante
            return 3;
        } else if ((i >= 3 && i <= 5) && (j >= 0 && j <= 2)) { //quarto quadrante
            return 4;
        } else if ((i >= 3 && i <= 5) && (j >= 3 && j <= 5)) { //quinto quadrante
            return 5;
        } else if ((i >= 3 && i <= 5) && (j >= 6 && j <= 8)) { //sexto quadrante
            return 6;
        } else if ((i >= 6 && i <= 8) && (j >= 0 && j <= 2)) { //sétimo quadrante
            return 7;
        } else if ((i >= 6 && i <= 8) && (j >= 3 && j <= 5)) { //oitavo quadrante
            return 8;
        } else if ((i >= 6 && i <= 8) && (j >= 6 && j <= 8)) { //nono quadrante
            return 9;

        }
        return 0;
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

        //System.out.println(LeituraArquivo.dimensoes);
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
