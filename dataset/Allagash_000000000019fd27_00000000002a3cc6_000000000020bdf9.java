//package  com.jsomers;

// Google Code Jam 2019
// Split big int into 2 positive addends, neither can have the digit 4

import java.util.*;
import java.io.*;
// import java.math.BigInteger;

public class Solution {

    class Activity  {
        public int start;
        public int end;

        Activity(int start, int end) {
            this.start =  start;
            this.end = end;
        }
    }

    class SortByStart implements Comparator<Activity>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Activity a, Activity b)
        {
            return a.start - b.start;
        }
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numActs = in.nextInt();
            ArrayList<Activity> acts = new ArrayList<>();
            for (int j = 0; j < numActs; ++j) {
                int start = in.nextInt();
                int end = in.nextInt();
                acts.add(new Activity(start, end));
            }
            Collections.sort(acts, new SortByStart());

            StringBuilder output = new StringBuilder();

            Activity currentAct = acts.get(0);
            int endC = currentAct.end;
            int endJ = 0;
            output.append("C");

            currentAct = acts.get(1);
            if (currentAct.start >= endC) {
                output.append("C");
                endC = currentAct.end;
            } else {
                output.append("J");
                endJ = currentAct.end;
            }
            for (int j = 2; j < numActs; ++j) {
                currentAct = acts.get(j);
                if (currentAct.start >= endC) {
                    output.append("C");
                    endC = currentAct.end;
                } else if  (currentAct.start >= endJ) {
                    output.append("J");
                    endJ = currentAct.end;
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }



            System.out.println("Case #" + i + ": " + output);
        }

    }

    public static void main(String[] args)  {

        Solution foregone = new Solution();
        foregone.run();

    }
}
