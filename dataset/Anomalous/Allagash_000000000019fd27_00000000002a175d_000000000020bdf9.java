import java.util.*;
import java.io.*;

public class Solution {

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class SortByStart implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            return Integer.compare(a.start, b.start);
        }
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int numActs = in.nextInt();
            List<Activity> acts = new ArrayList<>(numActs);
            for (int j = 0; j < numActs; ++j) {
                acts.add(new Activity(in.nextInt(), in.nextInt()));
            }
            Collections.sort(acts, new SortByStart());

            StringBuilder output = new StringBuilder();
            int endC = acts.get(0).end;
            int endJ = 0;
            output.append("C");

            if (numActs > 1) {
                Activity secondAct = acts.get(1);
                if (secondAct.start >= endC) {
                    output.append("C");
                    endC = secondAct.end;
                } else {
                    output.append("J");
                    endJ = secondAct.end;
                }

                for (int j = 2; j < numActs; ++j) {
                    Activity currentAct = acts.get(j);
                    if (currentAct.start >= endC) {
                        output.append("C");
                        endC = currentAct.end;
                    } else if (currentAct.start >= endJ) {
                        output.append("J");
                        endJ = currentAct.end;
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}