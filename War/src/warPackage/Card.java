package warPackage;

public class Card {
    private int rank;

    public Card(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}