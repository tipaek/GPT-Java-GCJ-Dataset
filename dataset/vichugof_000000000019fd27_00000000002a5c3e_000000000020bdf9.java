/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vichugof
 */
import java.io.*;
import java.util.*;

class Pair {
    public int x;
    public int y;

    // Constructor
    public Pair(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
};

public class Solution {
    private final String endLine;
    private int idxCasosReal;

    public static void main(final String[] args) throws FileNotFoundException {
        final Solution objSolution = new Solution();
        objSolution.execute();
    }

    public void execute() {
        try {
            final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            String line = "";
            String output = "";
            int numCases = 0;
            

            line = in.nextLine();

            numCases = Integer.parseInt(line);

            for (int idxCasos = 0; idxCasos < numCases; idxCasos++) {
                final int numActivities = Integer.parseInt(in.nextLine());

                final Pair[] schedule = new Pair[numActivities];
                for (int idxActivity = 0; idxActivity < numActivities; idxActivity++) {
                    final String[] activity = in.nextLine().split(" ");
                    final Pair activityPair = new Pair(Integer.parseInt(activity[0]), Integer.parseInt(activity[1]));
                    
                    schedule[idxActivity] = activityPair;
                    this.idxCasosReal++;
                }

                Arrays.sort(schedule, new Comparator<Pair>() {
                    public int compare(Pair activity1, Pair activity2) {
                        if (activity1.y < activity2.y) {
                            return -1;
                        }
                        return 0;
                    }
                });

                int lastActivityCameron = 0;
                int lastActivityJames = 0;
                int numAssignedActivy = 0;
                String scheduleFinal = "";

                for (int idxActSorted =0; idxActSorted < schedule.length; idxActSorted++) {
                    if (lastActivityCameron <= schedule[idxActSorted].x) {
                        lastActivityCameron = schedule[idxActSorted].y;
                        scheduleFinal += 'C';
                        numAssignedActivy++;
                    } else if(lastActivityJames <= schedule[idxActSorted].x) {
                        lastActivityJames = schedule[idxActSorted].y;
                        scheduleFinal += 'J';
                        numAssignedActivy++;
                    }
                    
                }

                if (numAssignedActivy != schedule.length) {
                    scheduleFinal = "IMPOSSIBLE";
                }

                output = scheduleFinal;

                System.out.println("Case #" + (int) (idxCasosReal) + ": " + output + this.endLine);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public boolean compare(Pair activity1, Pair activity2) {
        return activity1.y < activity2.y;
    }
    

    public Solution() {
        this.idxCasosReal = 0;
        this.endLine = "\r";

    }

    public void printSchedule(Pair [] schedule) {
        for (int idx = 0; idx < schedule.length; idx++) {
            Pair pair = schedule[idx];
            System.out.println(pair.x + " "+ pair.y);
        }
    }
}
