package BoardGame;

public class BoardException extends RuntimeException {

	/**
	 * every exception has version control 
	*/
	private static final long serialVersionUID = 1L;
	
	public BoardException (String msq) {
		super(msq);
	}

}
