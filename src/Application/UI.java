package Application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
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
	
	// Clears the screen so that the board does not appear with each piece movement
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	//encontra posição do usuario no tabuleiro
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s      = sc.nextLine(); //read what was typed on the screen
			char   column = s.charAt(0);   //takes the first position of the string
			int    row    = Integer.parseInt(s.substring(1)); // takes the second position of the string, starting from the first
			return new ChessPosition(column, row);
		}
		catch (RuntimeException e) {
			//exception "InputMismatchException" existing in java
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
		}
	}

//	public static void printMatch(ChessMatch chessMatch) {
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn : " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
		
		if (chessMatch.getCheck()) {
			System.out.println("YOU ARE IN CHECK!");
		}
	}

	
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
				//printPiece(pieces[i][j]);
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
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {

		System.out.println("                      ");
		System.out.println("--  CHESS  MATCH   -- ");
		System.out.println("_____________________ ");
		System.out.println("  |                 | ");

		//imprime cada uma das linhas 
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " | ");
			for (int j = 0; j < pieces.length; j++) {
				//printPiece(pieces[i][j], false);
				printPiece(pieces[i][j], possibleMoves[i][j]);
				if ( j == (pieces.length-1)) { 
					System.out.print("|");
				}
			}
			System.out.println();
		}
		System.out.println("__|_________________| ");
		System.out.println("  | a b c d e f g h | ");

//		System.out.println();
//		printCapturedPieces(captured);

	}

	
	//imprime uma peça
	private static void printPiece(ChessPiece piece, boolean background) {
	   	// se a peça não existir imprime um traço
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
    	if (piece == null) {
            //System.out.print("-");
            System.out.print("-" + ANSI_RESET);
        }

    	// se a peça existir impreme ela mesma
		else {
           // System.out.print( piece );
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_GREEN + piece + ANSI_RESET);
            }

        }
	   	//imprime espoço para as peças não ficarem grudadas
        System.out.print(" ");
	}

	//
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		/*
		System.out.println("Captured pieces:");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
		*/
		System.out.println("Captured pieces:");
		
		System.out.print(ANSI_YELLOW);
		System.out.print("White: ");
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		
		System.out.print(ANSI_GREEN);
		System.out.print("Black: ");
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
	}
	
	
	
	
	
}
