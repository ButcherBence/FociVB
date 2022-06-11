package hu.progmatic;

public class MatchWithPenalties extends Match {
    private int pentA;
    private int pentB;

    public MatchWithPenalties(int pentA, int pentB) {
        this.pentA = pentA;
        this.pentB = pentB;
    }


    public MatchWithPenalties(String line, int pentA, int pentB) {
        super(line);
        String[] pieces = line.split(";");
        this.pentA = Integer.parseInt(pieces[7]);
        this.pentB = Integer.parseInt(pieces[8]);
    }

    public MatchWithPenalties(String line) {
        String[] pieces = line.split(";");
        this.setYear(Integer.parseInt(pieces[0]));
        this.setStage(pieces[1]);
        this.setDate(pieces[2]);
        this.setTeamA(pieces[3]);
        this.setTeamB(pieces[4]);
        this.setGoalsA(Integer.parseInt(pieces[5]));
        this.setGoalsB(Integer.parseInt(pieces[6]));
        this.pentA = Integer.parseInt(pieces[7]);
        this.pentB = Integer.parseInt(pieces[8]);
    }

    public int getPentA() {
        return pentA;
    }

    public void setPentA(int pentA) {
        this.pentA = pentA;
    }

    public int getPentB() {
        return pentB;
    }

    public void setPentB(int pentB) {
        this.pentB = pentB;
    }

    @Override
    public String toString() {
        return "Match{" +
                "year=" + getYear() +
                ", stage='" + getStage() + '\'' +
                ", date='" + getDate() + '\'' +
                ", teamA='" + getTeamA() + '\'' +
                ", teamB='" + getTeamB() + '\'' +
                ", goalsA=" + getGoalsA() +
                ", goalsB=" + getGoalsB() +
                ", pentA=" + pentA +
                ", pentB=" + pentB +
                '}';
    }
}
