import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());

        for (int run = 1; run <= runs; run++) {
            int num = Integer.parseInt(console.nextLine());
            int[] starts = new int[num];
            int[] ends = new int[num];

            for (int i = 0; i < num; i++) {
                starts[i] = console.nextInt();
                ends[i] = console.nextInt();
            }
            console.nextLine();

            ArrayList<String> CTimes = new ArrayList<>();
            ArrayList<String> JTimes = new ArrayList<>();
            StringBuilder answer = new StringBuilder();

            for (int start = 0; start < starts.length; start++) {
                boolean useC = isAvailable(CTimes, starts[start], ends[start]);
                boolean useJ = isAvailable(JTimes, starts[start], ends[start]);

                if (useC && answer.length() != "IMPOSSIBLE".length()) {
                    CTimes.add(0, starts[start] + " " + ends[start]);
                    answer.append("C");
                } else if (useJ && answer.length() != "IMPOSSIBLE".length()) {
                    JTimes.add(0, starts[start] + " " + ends[start]);
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                }
            }
            System.out.println("Case #" + run + ": " + answer);
        }
    }

    private static boolean isAvailable(ArrayList<String> times, int start, int end) {
        for (String time : times) {
            int testStart = Integer.parseInt(time.split(" ")[0]);
            int testEnd = Integer.parseInt(time.split(" ")[1]);

            if ((start != end && (testStart <= start && testEnd > start) || (testStart < end && testEnd >= end))
                    || (testStart <= start && testEnd >= end)) {
                return false;
            }
        }
        return true;
    }
}