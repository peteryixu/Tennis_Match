public class TennisSet extends Tennis {

	public TennisSet(TennisPlayer playerOne, TennisPlayer playerTwo, boolean server) {
		super(playerOne, playerTwo, server);
	}

	public void setWinner() {
		if(getPlayerOneScore() >= 6 && getPlayerOneScore() >= getPlayerTwoScore() + 2) {
			setPlayerOneWinner();
			return;
		}
		if(getPlayerTwoScore() >= 6 && getPlayerTwoScore() >= getPlayerOneScore() + 2) {
			setPlayerTwoWinner();
			return;
		}
	}

	public boolean needTieBreak() {
		return (getPlayerOneScore() == getPlayerTwoScore() && getPlayerOneScore() == 6) ? true : false;
	}

	@Override
	public void showScore() {
		while (getWinner() == 0 && !needTieBreak()) {
			TennisGame newGame = new TennisGame(getPlayerOne(), getPlayerTwo(), getServer());

			try {
				Thread.sleep(2000L);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(ie);
			}

			// begin a new game
			newGame.showScore();

			// choose a player to get score
			if (newGame.getWinner() == 1) {
				playerOneSum();
			} else {
				playerTwoSum();
			}

			// change server
			changeServer();

			System.out.print("Score of the set: " + getPlayerOneScore() + " - " + getPlayerTwoScore());

			// judge whether there is a winner
			setWinner();
			if (getWinner() != 0) {
				System.out.println(". " + higherScorePlayer().getName() + " wins a set!");
				System.out.println();
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
					throw new RuntimeException(ie);
				}
				return;
			}
			
			if (getPlayerOneScore() != getPlayerTwoScore()) {
				System.out.println(", " + higherScorePlayer().getName() + " leads.");
			} else {
				System.out.println();
			}
								
		}

		// let's tie break
		TennisTieBreak tieBreak = new TennisTieBreak(getPlayerOne(), getPlayerTwo(), getServer());
		tieBreak.showScore();
		if (tieBreak.getWinner() == 1) {
			setPlayerOneWinner();
		} else {
			setPlayerTwoWinner();
		}
		System.out.println(tieBreak.higherScorePlayer().getName() + " wins a set!");
		System.out.println();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}
	}

}