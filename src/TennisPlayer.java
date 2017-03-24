public class TennisPlayer {
	private String name;
	private boolean gender; // female = true; male = false;
	private String nationality;
	private int rank;

	public TennisPlayer(String name, boolean gender, String nationality, int rank) {
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public boolean getGender() {
		return gender;
	}

	public String getNationality() {
		return nationality;
	}

	public int getRank() {
		return rank;
	}
}