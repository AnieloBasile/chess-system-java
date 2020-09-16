package Application;

import Chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//instancia uma partida 
		ChessMatch chessMatch = new ChessMatch();
		
		UI.printBoard(chessMatch.getPieces());
		
	}

}
