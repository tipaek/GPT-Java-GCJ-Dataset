import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bf.readLine());

        for (int i = 0; i < cases; i++) {
            boolean[] stateC = new boolean[1441];
            boolean[] stateJ = new boolean[1441];
            StringBuilder res = new StringBuilder();
            boolean isPossible = true;

            int activitiesCount = Integer.parseInt(bf.readLine());
            ArrayList<Pair> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                String[] timeLimits = bf.readLine().split(" ");
                int start = Integer.parseInt(timeLimits[0]);
                int end = Integer.parseInt(timeLimits[1]);
                activities.add(new Pair(start, end));
            }

            Collections.sort(activities, new PairComparator());

            for (Pair activity : activities) {
                boolean conflictC = false;
                boolean conflictJ = false;

                for (int k = activity.start; k < activity.end; k++) {
                    if (stateC[k]) {
                        conflictC = true;
                        for (int o = k - 1; o >= activity.start; o--) stateC[o] = false;
                        break;
                    } else {
                        stateC[k] = true;
                    }
                }

                if (conflictC) {
                    for (int k = activity.start; k < activity.end; k++) {
                        if (stateJ[k]) {
                            conflictJ = true;
                            for (int o = k - 1; o >= activity.start; o--) stateJ[o] = false;
                            break;
                        } else {
                            stateJ[k] = true;
                        }
                    }
                }

                if (!conflictC) {
                    res.append("C");
                } else if (!conflictJ) {
                    res.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + res);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}

class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getDuration() {
        return end - start;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + "): " + getDuration();
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o2.getDuration(), o1.getDuration());
    }
}