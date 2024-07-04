import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] inputs = new String[n];
            for (int j = 0; j < n; j++) {
                inputs[j] = scanner.nextLine();
            }

            String message = new Solution().processInputs(inputs, false);
            if (message.contains("IMPOSSIBLE")) {
                message = new Solution().processInputs(inputs, true);
            }
            if (message.contains("IMPOSSIBLE")) {
                message = "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + message);
        }
    }

    private String processInputs(String[] inputs, boolean optimize) {
        List<int[]> cList = new ArrayList<>();
        List<int[]> jList = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        for (String input : inputs) {
            String[] slots = input.split(" ");
            int[] interval = { Integer.parseInt(slots[0]), Integer.parseInt(slots[1]) };

            if (cList.isEmpty()) {
                cList.add(interval);
                output.append("C");
            } else if (jList.isEmpty() && optimize) {
                jList.add(interval);
                output.append("J");
            } else {
                boolean conflictWithC = hasConflict(cList, interval);
                boolean conflictWithJ = false;

                if (!conflictWithC) {
                    cList.add(interval);
                    output.append("C");
                } else {
                    conflictWithJ = checkAndAddToJList(jList, interval, output);

                    if (conflictWithC && conflictWithJ) {
                        output.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
        }

        return output.toString();
    }

    private boolean hasConflict(List<int[]> list, int[] interval) {
        for (int[] existingInterval : list) {
            if (intervalsOverlap(existingInterval, interval)) {
                return true;
            }
        }
        return false;
    }

    private boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }

    private boolean checkAndAddToJList(List<int[]> jList, int[] interval, StringBuilder output) {
        boolean conflictWithJ = hasConflict(jList, interval);

        if (!conflictWithJ) {
            jList.add(interval);
            output.append("J");
        }

        return conflictWithJ;
    }
}