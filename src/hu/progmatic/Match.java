package hu.progmatic;

public class Match {
    private int year;
    private String stage;
    private String date;
    private String teamA;
    private String teamB;
    private int goalsA;
    private int goalsB;


    public Match() {
    }

    public Match(int year,String stage, String date, String teamA, String teamB, int goalsA, int goalsB, int pentA, int pentB) {
        this.year = year;
        this.stage = stage;
        this.date = date;
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
    }

    public Match(String line) {
        String [] pieces = line.split(";");
            this.year = Integer.parseInt(pieces[0]);
            this.stage = pieces[1];
            this.date = pieces[2];
            this.teamA = pieces[3];
            this.teamB = pieces[4];
            this.goalsA = Integer.parseInt(pieces[5]);
            this.goalsB = Integer.parseInt(pieces[6]);

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getGoalsA() {
        return goalsA;
    }

    public void setGoalsA(int goalsA) {
        this.goalsA = goalsA;
    }

    public int getGoalsB() {
        return goalsB;
    }

    public void setGoalsB(int goalsB) {
        this.goalsB = goalsB;
    }


    @Override
    public String toString() {
        return "Match{" +
                "year=" + year +
                ", stage='" + stage + '\'' +
                ", date='" + date + '\'' +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", goalsA=" + goalsA +
                ", goalsB=" + goalsB +
                '}';
    }
}
