public class TennisMatch extends Tennis {
	private boolean gender; // female = true; male = false;

	public TennisMatch(TennisPlayer playerOne, TennisPlayer playerTwo, boolean server, boolean gender) {
		super(playerOne, playerTwo, server);
		this.gender = gender;
	}

	public void setWinner() {
		if (gender) {
			if (getPlayerOneScore() == 2) {
				setPlayerOneWinner();
				return;
			}
			if (getPlayerTwoScore() == 2) {
				setPlayerTwoWinner();
				return;
			}
		} else {
			if (getPlayerOneScore() == 3) {
				setPlayerOneWinner();
				return;
			}
			if (getPlayerTwoScore() == 3) {
				setPlayerTwoWinner();
				return;
			}
		}
	}

	@Override
	public void showScore() {
		// count which set
		int counter = 1;
		while (getWinner() == 0) {
			TennisSet newSet = new TennisSet(getPlayerOne(), getPlayerTwo(), getServer());

			try {
				Thread.sleep(5000L);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(ie);
			}
			
			// print which set
			System.out.println("Set " + counter + " begin.");

			// begin a new set
			newSet.showScore();

			// choose a player to get score
			if (newSet.getWinner() == 1) {
				playerOneSum();
			} else {
				playerTwoSum();
			}

			// change server
			changeServer();

			// judge whether there is a winner
			setWinner();
			if (getWinner() != 0) {
				System.out.println(higherScorePlayer().getName() + " wins the match!");
				System.out.println();
				return;
			}

			System.out.print("Score of the match: " + getPlayerOneScore() + " - " + getPlayerTwoScore());
			if (getPlayerOneScore() != getPlayerTwoScore()) {
				System.out.println(", " + higherScorePlayer().getName() + " leads.");
			} else {
				System.out.println();
			}
			System.out.println();
			counter++;
		}
	}
}