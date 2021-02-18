package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		//instancia uma partida 
		ChessMatch chessMatch = new ChessMatch();
		//UI.printBoard(chessMatch.getPieces());

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
	
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
	
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine(); //expect an "enter"
			}
			catch (InputMismatchException e ) {
				System.out.println(e.getMessage());
				sc.nextLine(); //expect an "enter"
			}
			
		}
		
		
		
	}

}
