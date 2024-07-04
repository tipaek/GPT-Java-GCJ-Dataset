import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static String output1 = "Case #%d: %s";
    private static String output2 = "Case #%d: IMPOSSIBLE";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] intervals = new int[n][4];
        for (int i = 0; i < n; ++i) {
            intervals[i][0] = i;
            intervals[i][1] = scanner.nextInt();
            intervals[i][2] = scanner.nextInt();
        }
        int c = 0;
        int j = 0;
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[1]));
        for (int[] line: intervals) {
            if (c <= line[1]) {
                line[3] = 0;
                c = line[2];
            } else if (j <= line[1]) {
                line[3] = 1;
                j = line[2];
            } else {
                System.out.println(String.format(output2, caseNum));
                return;
            }
        }

        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));
        StringBuilder sb = new StringBuilder();
        for (int[] line: intervals) {
            if (line[3] == 0) {
                sb.append('C');
            } else {
                sb.append('J');
            }
        }
        System.out.println(String.format(output1, caseNum, sb.toString()));
    }
}
