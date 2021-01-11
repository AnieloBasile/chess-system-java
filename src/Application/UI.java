package Application;

import Chess.ChessPiece;

public class UI {
	
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
            System.out.print( piece );
        }
	   	//imprime espoço para as peças não ficfarem grudadas
        System.out.print(" ");
	}

}
