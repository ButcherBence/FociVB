package hu.progmatic;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Match> matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Resources\\matches_all.csv"))) {
            String line;
            br.readLine();
            try {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    if (values.length > 7) {
                        MatchWithPenalties matchWithPenalties = new MatchWithPenalties(line);
                        matches.add(matchWithPenalties);
                    } else {
                        Match match = new Match(line);
                        matches.add(match);
                    }

                }

                System.out.println("Number of matches: " + matches.size());
                System.out.println("Year of worldcup: ");
                int year = sc.nextInt();

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("Resources\\selected.csv"));
                    bw.write("stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b\n");
                    for (Match match : matches) {
                        if (match.getYear() == year)
                            if (match instanceof MatchWithPenalties) {
                                bw.write(match.getStage() + ";" +
                                        match.getDate() + ";" +
                                        match.getTeamA() + ";" +
                                        match.getTeamB() + ";" +
                                        match.getGoalsA() + ";" +
                                        match.getGoalsB() + ";" +
                                        ((MatchWithPenalties) match).getPentA() + ";" +
                                        ((MatchWithPenalties) match).getPentB() + ";" + "\n");
                            } else {
                                bw.write(match.getStage() + ";" +
                                        match.getDate() + ";" +
                                        match.getTeamA() + ";" +
                                        match.getTeamB() + ";" +
                                        match.getGoalsA() + ";" +
                                        match.getGoalsB() +
                                        ";" + "\n");

                            }

                    }
                   bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                System.out.println("2. Maxmimum goal difference: " + maxGoalDifference(matches, year));
                Map<String, Integer> goalCounter = new LinkedHashMap<>();
                for (Match match : matches) {
                    if (match.getYear() == year) {
                        goalCounter.put(match.getStage(), stageGoalCounter(matches, year, match.getStage()));

                    }
                }
                System.out.println("3. The player has won " + wonBets(matches,year) + " bets.");
                System.out.println("4. Total goals by stage: ");
                for (Map.Entry<String, Integer> entry : goalCounter.entrySet()){
                    System.out.println(entry.getKey() + ": " +
                            entry.getValue());
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static int stageGoalCounter(List<Match> matches, int year, String stage) {
        int sum = 0;
        for (Match match : matches) {
            if (match.getYear() == year) {
                if (match.getStage().equalsIgnoreCase(stage)) {
                    sum += Math.abs(match.getGoalsA() + match.getGoalsB());

                }
            }
        }
        return sum;
    }

    public static int maxGoalDifference(List<Match> matches, int year) {
        int max = Integer.MIN_VALUE;

        for (Match match : matches) {
            int sum = 0;
            if (match.getYear() == year) {
                sum = Math.abs(match.getGoalsA() - match.getGoalsB());

            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static int wonBets(List<Match> matches, int year){
        int counter = 0;
        for (Match match : matches) {
            if (match.getYear() == year) {
                if (match instanceof MatchWithPenalties) {
                    if (((MatchWithPenalties) match).getPentA() > ((MatchWithPenalties) match).getPentB()) {
                        counter++;
                    }
                } else {
                    if (match.getGoalsA() > match.getGoalsB()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
