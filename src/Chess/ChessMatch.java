package Chess;

import BoardGame.Board;
import BoardGame.Position;
import Chess.pieces.King;
import Chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;		
	}
	/*
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}*/	
	

	private void initialSetup() {
		//board.placePiece(piece, position(R,C);
 
		board.placePiece(new Rook(board, Color.WHITE), new Position(0,1));
		board.placePiece(new Rook(board, Color.BLACK), new Position(2,2));
		board.placePiece(new King(board, Color.WHITE), new Position(3,1));
		/*	board.placePiece(new King(board, Color.WHITE), new Position(4,1));
		board.placePiece(new King(board, Color.BLACK), new Position(5,2));
	

		placeNewPiece('a', 2, new Rook(board, Color.WHITE));
		placeNewPiece('b', 2, new Rook(board, Color.BLACK));
		placeNewPiece('a', 3, new King(board, Color.WHITE));
		placeNewPiece('b', 3, new King(board, Color.BLACK));
*/
	}
}
