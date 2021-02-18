package Application;

import Chess.ChessPiece;
import Chess.Color;

public class UI {
	
	//CODIGO PARA MUDAR A COR DAS PEÇAS
	//https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET  = "\u001B[0m";
	public static final String ANSI_BLACK  = "\u001B[30m";
	public static final String ANSI_RED    = "\u001B[31m";
	public static final String ANSI_GREEN  = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE   = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN   = "\u001B[36m";
	public static final String ANSI_WHITE  = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND  = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND    = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND  = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND   = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND   = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND  = "\u001B[47m";	
	
	//imprime o tabuleiro
	public static void printBoard(ChessPiece[][] pieces) {

		System.out.println("                      ");
		System.out.println("--  CHESS  MATCH   -- ");
		System.out.println("_____________________ ");
		System.out.println("  |                 | ");

		//imprime cada uma das linhas 
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " | ");
			for (int j = 0; j < pieces.length; j++) {
				//printPiece(pieces[i][j], false);
				printPiece(pieces[i][j], false);
				if ( j == (pieces.length-1)) { 
					System.out.print("|");
				}
			}
			System.out.println();
		}
		System.out.println("__|_________________| ");
		System.out.println("  | a b c d e f g h | ");
	}
	
	//imprime uma peça
	private static void printPiece(ChessPiece piece, boolean background) {
	   	// se a peça não existir imprime um traço
		if (piece == null) {
            System.out.print("-");
        }
        // se a peça existir impreme ela mesma
		else {
           // System.out.print( piece );
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }

        }
	   	//imprime espoço para as peças não ficarem grudadas
        System.out.print(" ");
	}


	
	
	
	
	
	
}
