import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNumber = in.nextInt();
        String[] answers = new String[caseNumber];

        for (int i = 0; i < caseNumber; i++) {
            int activityNumber = in.nextInt();
            int[][] activityTimes = new int[activityNumber][2];
            Set<Integer> allTimes = new TreeSet<>();
            for (int j = 0; j < activityNumber; j++) {
                activityTimes[j][0] = in.nextInt();
                activityTimes[j][1] = in.nextInt();
                allTimes.add(activityTimes[j][0]);
                allTimes.add(activityTimes[j][1]);
            }

            boolean[][] table = new boolean[activityNumber][allTimes.size() - 1];
            String answer = "";

            Integer[] allTimesArray = new Integer[allTimes.size()];
            allTimes.toArray(allTimesArray);

            for (int j = 0; j < table.length; j++) {
                int start = activityTimes[j][0];
                int finish = activityTimes[j][1];
                for (int k = 0; k < table[0].length; k++) {
                    table[j][k] = allTimesArray[k] >= start && allTimesArray[k] < finish;
                }
            }

            for (int j = 0; j < table[0].length; j++) {
                int sumOfOverlaps = 0;
                for (boolean[] booleans : table) {
                    if (booleans[j]) {
                        sumOfOverlaps++;
                    }
                }

                if (sumOfOverlaps > 2) {
                    answer = "IMPOSSIBLE";
                    break;
                }
            }

            char[] arr = new char[activityNumber];
            Arrays.fill(arr, 'C');
            for (int j = 1; j < table.length; j++) {
                for (int k = 0; k < table[0].length; k++) {
                    if (table[j][k]) {
                        for (int l = j - 1; l >= 0; l--) {
                            if (table[l][k] && arr[l] == 'C') {
                                arr[j] = 'J';
                                break;
                            }
                        }
                    }
                }
            }
            if (!answer.equals("IMPOSSIBLE")) {
                answer = String.valueOf(arr);
            }

            answers[i] = "Case #" + (i + 1) + ": " + answer;
        }
        for (int i = 0; i < caseNumber; i++) {
            System.out.println(answers[i]);
        }
    }
}
