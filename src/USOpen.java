import java.util.Random;
import java.io.Console;
import java.io.IOException;

public class USOpen {
	private TennisPlayer playerOne;
	private TennisPlayer playerTwo;

	public USOpen() {
		this.playerOne = new TennisPlayer("Roger Federer", false, "Switzerland", 3);
		this.playerTwo = new TennisPlayer("Rafeal Nadal", false, "Spain", 1);
	}

	public USOpen(TennisPlayer playerOne, TennisPlayer playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public TennisPlayer getPlayerOne() {
		return playerOne;
	}

	public TennisPlayer getPlayerTwo() {
		return playerTwo;
	}

	public boolean whoServes() {
		Random r = new Random();
		return r.nextInt() % 2 == 1 ? true : false;
	}

	public static void main(String[] args) {
		
		System.out.println();
		Console c = System.console();
		boolean isValidInput = false;

		int modeInt = 0;
		while (!isValidInput) {
			String modeStr = c.readLine("Please choose your match mode. For default mode, type 1; For customized mode, type 2: ");
			modeInt = Integer.parseInt(modeStr);
			if (modeInt == 1 || modeInt == 2) {
				isValidInput = true;
			} else {
				System.out.println("Invalid Input! Please read instruction carefully.");
			}
		}

		System.out.println();

		USOpen usopen = null;
		if (modeInt == 1) {
			usopen = new USOpen();
		} else {
			isValidInput = false;
			boolean gender = false;
			while (!isValidInput) {
				String genderStr = c.readLine("Please enter gender of your match. For male, type m; For female, type f: ");
				if (genderStr.equals("m")) {
					isValidInput = true;
					gender = false;
				} else if (genderStr.equals("f")) {
					isValidInput = true;
					gender = true;
				} else {
					System.out.println("Invalid Input! Please read instruction carefully.");
				}
			}
			
			System.out.println();

			System.out.println("Please enter information of player one.");
			String playerOneName = c.readLine("Name: ");
			String playerOneNation = c.readLine("Nationality: ");
			int playerOneRank = Integer.parseInt(c.readLine("Rank: "));
			TennisPlayer playerOne = new TennisPlayer(playerOneName, gender, playerOneNation, playerOneRank);

			System.out.println();

			System.out.println("Please enter information of player two.");
			String playerTwoName = c.readLine("Name: ");
			String playerTwoNation = c.readLine("Nationality: ");
			int playerTwoRank = Integer.parseInt(c.readLine("Rank: "));
			TennisPlayer playerTwo = new TennisPlayer(playerTwoName, gender, playerTwoNation, playerTwoRank);

			System.out.println();

			usopen = new USOpen(playerOne, playerTwo);
		}

		System.out.println("Loading...");

		for (int i = 0; i < 60; i++) {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(ie);
			}
			System.out.print("-");
		}
		System.out.println();

		System.out.println("Welcome to our USOPEN!");

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}

		System.out.println("Let's first welcome " + usopen.getPlayerOne().getName() + 
							" from " + usopen.getPlayerOne().getNationality() + "!");

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}

		System.out.println("And then, " + usopen.getPlayerTwo().getName() +
							" from "+ usopen.getPlayerTwo().getNationality() + "!");

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}

		TennisMatch newMatch = new TennisMatch(usopen.getPlayerOne(), 
												usopen.getPlayerTwo(), 
												usopen.whoServes(),
												usopen.getPlayerOne().getGender());

		System.out.println("Referee in place.");

		try {
			Thread.sleep(2000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}

		System.out.println("Match Begin!");

		System.out.println();

		newMatch.showScore();
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}

		System.out.println("Congratulations to the winner: " + newMatch.higherScorePlayer().getName() + "!");

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		}

		System.out.println("Thank you for watching!");
	}
}