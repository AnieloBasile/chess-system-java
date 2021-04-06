package Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		
		List<ChessPiece> captured = new ArrayList<>();


		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();

				//-------------------------------------------------------------------------
				//UI.printBoard(chessMatch.getPieces()); ---old
				//UI.printMatch(chessMatch);             ---old  
				UI.printMatch(chessMatch, captured);
				//-------------------------------------------------------------------------
				
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
	
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
	
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				
				
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
		
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
	}

}
