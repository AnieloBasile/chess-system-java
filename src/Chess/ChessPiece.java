package Chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	/* a cor da piece n�o pode ser alterada
	public void setColor(Color color) {
		this.color = color;
	}*/
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
