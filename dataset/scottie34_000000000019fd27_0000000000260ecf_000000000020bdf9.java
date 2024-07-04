import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            StringBuilder result = new StringBuilder();
            int n = in.nextInt();
            char[] schedule = new char[1440];
            for (int j = 0; j < n; j++) {
                int startTmp = Math.max(0, in.nextInt());
                int endTmp = Math.min(1440, in.nextInt());
                String val = new String(Arrays.copyOfRange(schedule, startTmp, endTmp));
                if (!val.contains("C")) {
                    Arrays.fill(schedule, startTmp, endTmp, 'C');
                    result.append("C");
                }
                else if (!val.contains("J")) {
                    Arrays.fill(schedule, startTmp, endTmp, 'J');
                    result.append("J");
                }
                else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("case #" + i + ": " + result);
        }
    }

}
