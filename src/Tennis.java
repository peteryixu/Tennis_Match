public abstract class Tennis {
	private TennisPlayer playerOne;
	private TennisPlayer playerTwo;
	private int playerOneScore = 0;
	private int playerTwoScore = 0;
	private boolean server; // true = player one, false = player two
	private int winner; // 0 means no winner;
							// 1 means player one;
							// 2 means player two;

	public Tennis(TennisPlayer playerOne, TennisPlayer playerTwo, boolean server) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.server = server;
		this.winner = 0;
	}

	// to have player one information
	public TennisPlayer getPlayerOne() {
		return playerOne;
	}

	// to have player two information
	public TennisPlayer getPlayerTwo() {
		return playerTwo;
	}

	// to have player one score
	public int getPlayerOneScore() {
		return playerOneScore;
	}

	// to have player two score
	public int getPlayerTwoScore() {
		return playerTwoScore;
	}

	// to have server
	public boolean getServer() {
		return server;
	}

	// to have winner
	public int getWinner() {
		return winner;
	}

	public void changeServer() {
		server = !server;
	}

	public void setPlayerOneWinner() {
		winner = 1;
	}

	public void setPlayerTwoWinner() {
		winner = 2;
	}

	public void playerOneSum() {
		playerOneScore++;
	}

	public void playerTwoSum() {
		playerTwoScore++;
	}

	public TennisPlayer higherScorePlayer() {
		return playerOneScore > playerTwoScore ? playerOne : playerTwo;
	}

	public abstract void showScore();
}