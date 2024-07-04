import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            StringBuilder result = new StringBuilder();
            int n = in.nextInt();
            char[] scheduleC = new char[1440];
            char[] scheduleJ = new char[1440];
            for (int j = 0; j < n; j++) {
                int startTmp = in.nextInt();
                int endTmp = in.nextInt();
                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }
                String valC = new String(Arrays.copyOfRange(scheduleC, startTmp, endTmp));
                if (!valC.contains("C")) {
                    Arrays.fill(scheduleC, startTmp, endTmp, 'C');
                    result.append("C");
                } else {
                    String valJ = new String(Arrays.copyOfRange(scheduleJ, startTmp, endTmp));
                    if (!valJ.contains("J")) {
                        Arrays.fill(scheduleJ, startTmp, endTmp, 'J');
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            System.out.println("case #" + i + ": " + result);
        }
    }

}
