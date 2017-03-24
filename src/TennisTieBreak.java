import java.util.Random;

public class TennisTieBreak extends Tennis {
	public TennisTieBreak(TennisPlayer playerOne, TennisPlayer playerTwo, boolean server) {
		super(playerOne, playerTwo, server);
	}

	public void whoServes() {
		System.out.println((getServer() ? getPlayerOne().getName() 
										: getPlayerTwo().getName()) + " serves.");
	}

	public void setWinner() {
		if(getPlayerOneScore() >= 5 && getPlayerOneScore() >= getPlayerTwoScore() + 2) {
			setPlayerOneWinner();
			return;
		}
		if(getPlayerTwoScore() >= 5 && getPlayerTwoScore() >= getPlayerOneScore() + 2) {
			setPlayerOneWinner();
			return;
		}
	}

	@Override
	public void showScore() {
		System.out.println("Tie Break!");
		whoServes();

		Random random = new Random();

		while (getWinner() == 0) {

			try {
				int sleep = random.nextInt(10);
				Thread.sleep(sleep * 100L + 500L);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(ie);
			}

			// choose a player to get score randomly
			int playerOneWinRate = random.nextInt(100 - getPlayerOne().getRank());
			int playerTwoWinRate = random.nextInt(100 - getPlayerTwo().getRank());
			if (playerOneWinRate > playerTwoWinRate) {
				playerOneSum();
			} else {
				playerTwoSum();
			}

			// judge whether there is a winner
			setWinner();

			// change server
			changeServer();

			// show scores
			System.out.print(getPlayerOneScore() + " : " + getPlayerTwoScore());

			// show who serves if not end
			if (getWinner() == 0) {
				System.out.print(", ");
				whoServes();
			} else {
				System.out.println(" ");
			}
		}		
	}
}