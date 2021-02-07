package fighting.Model;

public class FighterRecord {

    private int wins;
    private int losses;
    private int draws;
    private int noContest;

    public FighterRecord() {

    }

    public FighterRecord(int wins, int losses) {
        this.wins = wins;
        this.losses = losses;
        this.draws = 0;
        this.noContest = 0;
    }

    public FighterRecord(int wins, int losses, int draws, int noContest) {
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.noContest = noContest;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getLosses() {
        return losses;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDraws() {
        return draws;
    }

    public void setNoContest(int noContest) {
        this.noContest = noContest;
    }

    public int getNoContest() {
        return noContest;
    }

    public String quickView() {
        String record = "";
        if (noContest == 0) {
            record = wins + "-" + losses + "-" + draws + " (W-L-D)";
        } else if (noContest > 0 && draws <= 0) {
            record = wins + "-" + losses + "\n(" + noContest + ")";
        } else if (noContest >= 1 && draws >= 1) {
            record = wins + "-" + losses + "-" + draws + "\n(" + noContest + ")";
        }

        return record;
    }
}