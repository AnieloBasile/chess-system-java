package Chess;

import BoardGame.Board;
import BoardGame.Piece;

public class ChessPiece extends Piece{
	
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
	
	

}
