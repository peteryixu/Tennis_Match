import java.util.Random;

public class TennisGame extends Tennis {
	
	public TennisGame(TennisPlayer playerOne, TennisPlayer playerTwo, boolean server) {
		super(playerOne, playerTwo, server);
	}

	public String transformScore(int score) {
		switch(score) {
			case 0: 
				return "Love";
			case 1:
				return "Fifteen";
			case 2:
				return "Thirty";
			case 3:
				return "Forty";
			default:
				return "Invalid Score!";
		}
	}

	public void whoServes() {
		System.out.println((getServer() ? getPlayerOne().getName() 
										: getPlayerTwo().getName()) + " serves.");
	}

	public boolean isDeuce() {
		return getPlayerOneScore() >= 3 && getPlayerOneScore() == getPlayerTwoScore();
	}

	public boolean hasAdvantage() {
		if(getPlayerOneScore() >= 4 && getPlayerOneScore() == getPlayerTwoScore() + 1) {
			return true;
		}
		if(getPlayerTwoScore() >= 4 && getPlayerTwoScore() == getPlayerOneScore() + 1) {
			return true;
		}
		return false;
	}
	
	public void setWinner() {
		if(getPlayerOneScore() >= 4 && getPlayerOneScore() >= getPlayerTwoScore() + 2) {
			setPlayerOneWinner();
			return;
		}
		if(getPlayerTwoScore() >= 4 && getPlayerTwoScore() >= getPlayerOneScore() + 2) {
			setPlayerTwoWinner();
			return;
		}
	}

	@Override
	public void showScore() {
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
			if (getWinner() != 0) {
				System.out.println(higherScorePlayer().getName() + " wins a game!");
				return;
			}

			// judge whether there is a duece or advantage
			if (isDeuce()) {
				System.out.print("Deuce. "); 
			} else if (hasAdvantage()) {
				System.out.print(higherScorePlayer().getName() + " has AD. ");
			} else {
				System.out.print(transformScore(getPlayerOneScore()) + " : " + transformScore(getPlayerTwoScore()) + ". ");
			}
			whoServes();
		}
		
	}
}