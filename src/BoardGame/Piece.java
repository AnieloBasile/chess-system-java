package BoardGame;

public class Piece {
	
	protected Position position;
	private   Board    board;
	
	
	public Piece(Board board) {
		this.board = board;
		position   = null;
	}

	//mudando de public para protected , para limitar o acesso
	protected Board getBoard() {
		return board;
	}


	/* o board não pode ser alterado
	public void setBoard(Board board) {
		this.board = board;
	} */
	
	
	
	
	

}
