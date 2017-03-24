public class Test {
	public static void main(String[] args) {
		TennisPlayer playerOne = new TennisPlayer("Roger Federer", false, "Switzerland", 1);
		TennisPlayer playerTwo = new TennisPlayer("Rafael Nadal", false, "Spain", 2);
		
		/*
		TennisGame game = new TennisGame(playerOne, playerTwo, true);
		game.showScore();
		*/

		/*
		TennisSet set = new TennisSet(playerOne, playerTwo, true);
		set.showScore();
		*/

		
		TennisMatch match = new TennisMatch(playerOne, playerTwo, true, false);
		match.showScore();
		
	}
}