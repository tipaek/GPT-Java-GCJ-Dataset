import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSetSize = in.nextInt();

        for (int i = 1; i <= testSetSize; ++i) {
            int numberActivities = in.nextInt();
            List<Integer> cameronStarting = new ArrayList<>();
            List<Integer> cameronEnding = new ArrayList<>();
            List<Integer> jamieStarting = new ArrayList<>();
            List<Integer> jamieEnding = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < numberActivities; j++) {
                int startingTime = in.nextInt();
                int endingTime = in.nextInt();

                if (!isImpossible) {
                    if (tryAssignActivity(startingTime, endingTime, cameronStarting, cameronEnding)) {
                        answer.append("C");
                    } else if (tryAssignActivity(startingTime, endingTime, jamieStarting, jamieEnding)) {
                        answer.append("J");
                    } else {
                        isImpossible = true;
                        answer = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static boolean tryAssignActivity(int startingTime, int endingTime, List<Integer> startingArray, List<Integer> endingArray) {
        for (int i = 0; i < startingArray.size(); i++) {
            int startingTimeI = startingArray.get(i);
            int endingTimeI = endingArray.get(i);

            boolean overlaps = (startingTime < endingTimeI && endingTime > startingTimeI);
            if (overlaps) {
                return false;
            }
        }

        startingArray.add(startingTime);
        endingArray.add(endingTime);
        return true;
    }
}