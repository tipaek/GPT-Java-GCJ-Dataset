import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String checkSchedule(int[][] oldArray, int[][] array) {
        Arrays.sort(array, Comparator.comparingInt(entry -> entry[0]));

        List<String> cList = new ArrayList<>();
        List<String> jList = new ArrayList<>();

        int prevCEndTime = 0;
        int prevJEndTime = 0;
        StringBuilder result = new StringBuilder();

        for (int[] interval : array) {
            int start = interval[0];
            int end = interval[1];

            if (cList.isEmpty() || start >= prevCEndTime) {
                cList.add(start + "," + end);
                prevCEndTime = end;
            } else if (jList.isEmpty() || start >= prevJEndTime) {
                jList.add(start + "," + end);
                prevJEndTime = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int[] interval : oldArray) {
            String intervalStr = interval[0] + "," + interval[1];
            if (cList.contains(intervalStr)) {
                result.append("C");
            } else {
                result.append("J");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = in.nextInt();
        in.nextLine();

        for (int k = 1; k <= testCaseCount; ++k) {
            int n = in.nextInt();
            in.nextLine();
            int[][] array = new int[n][2];
            int[][] oldArray = new int[n][2];

            for (int i = 0; i < n; ++i) {
                String[] rowArray = in.nextLine().split(" ");
                int start = Integer.parseInt(rowArray[0]);
                int end = Integer.parseInt(rowArray[1]);
                array[i][0] = start;
                array[i][1] = end;
                oldArray[i][0] = start;
                oldArray[i][1] = end;
            }

            String result = checkSchedule(oldArray, array);
            System.out.println("Case #" + k + ": " + result);
        }
    }
}