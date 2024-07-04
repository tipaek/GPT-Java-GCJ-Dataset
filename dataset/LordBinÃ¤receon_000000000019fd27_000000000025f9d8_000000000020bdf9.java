import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(n, scanner));
        }
    }

    public static String solve(int n, Scanner scanner) {
        List<int[]> jActivities = new LinkedList<>();
        List<int[]> cActivities = new LinkedList<>();
        StringBuilder out = new StringBuilder(n);
        for (int j = 1; j <= n; j++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            boolean addToJ = true;
            boolean addToC = true;
            for (int[] jActivity : jActivities) {
                if (jActivity[0] < start && jActivity[1] > start) {
                    addToJ = false;
                } else if (jActivity[0] < end && jActivity[1] > end) {
                    addToJ = false;
                }
            }
            if (addToJ) {
                jActivities.add(new int[] {start, end});
                out.append("J");
            } else {
                for (int[] cActivity : cActivities) {
                    if (cActivity[0] < start && cActivity[1] > start) {
                        addToC = false;
                    } else if (cActivity[0] < end && cActivity[1] > end) {
                        addToC = false;
                    }
                }
                if (addToC) {
                    cActivities.add(new int[] {start, end});
                    out.append("C");
                } else {
                    out.replace(0, 0, "F");
                }
            }
        }
        String outString = out.toString();
        if (outString.startsWith("F")) {
            return "IMPOSSIBLE";
        }
        return outString;
    }
}
