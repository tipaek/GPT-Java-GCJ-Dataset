import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int testCasesCount = numberOfTestCases;

        String result = "";

        for (int i = 0; i < numberOfTestCases; i++) {

            int intervalSize = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[][] intervals = new String[intervalSize][2];
            for (int j = 0; j < intervalSize; j++) {
                String[] interval = scanner.nextLine().split(" ");
                intervals[j][0] = interval[0];
                intervals[j][1] = interval[1];
            }
            result = result + "Case #" + (i+1) + ":" + new Solution().getIntervals(intervalSize,intervals) + "\n";
        }

        System.out.println(result);
    }


    public String getIntervals(int size, String[][] intervals) {
        int[] intervalInfo = new int[size];     // 1 for Jamie and 2 for Cameron
        int[][] intervalsWithIndex = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {
            intervalsWithIndex[i] = new int[]{i, Integer.parseInt(intervals[i][0]), Integer.parseInt(intervals[i][1])};
        }
        Arrays.sort(intervalsWithIndex, new IntervalComparator());

        System.out.println();
        boolean impossible = false;
        int CameronEndTime = 0;
        int JamieEndTime = 0;

        for (int[] interval : intervalsWithIndex) {
if (JamieEndTime <= interval[1]) {
                intervalInfo[interval[0]] = 1;
                JamieEndTime = interval[2];
            } else if (CameronEndTime <= interval[1]) {
                intervalInfo[interval[0]] = 2;
                CameronEndTime = interval[2];
            } else {
                impossible = true;
                break;
            }

        }

        String answer = "";
        if (impossible) {
            return "IMPOSSIBLE";
        }

        for (int i : intervalInfo) {
            if (i == 1) {
                answer += "C";
            } else {
                answer += "J";
            }
        }
        return answer;

    }
}

class IntervalComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
    }
}