import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= t; i++) {
                boolean[] cameron = new boolean[1450];
                boolean[] jamie = new boolean[1450];
                int n = Integer.parseInt(br.readLine());
                result.setLength(0); // Clear the result for the new test case

                boolean isImpossible = false;
                StringBuilder schedule = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    String[] data = br.readLine().split(" ");
                    int s = Integer.parseInt(data[0]);
                    int e = Integer.parseInt(data[1]);

                    boolean assigned = false;

                    if (!isImpossible) {
                        if (isAvailable(cameron, s, e)) {
                            assign(cameron, s, e);
                            schedule.append("C");
                            assigned = true;
                        } else if (isAvailable(jamie, s, e)) {
                            assign(jamie, s, e);
                            schedule.append("J");
                            assigned = true;
                        } else {
                            isImpossible = true;
                        }
                    }

                    if (isImpossible) {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                    }
                }

                result.append("Case #").append(i).append(": ").append(schedule.toString()).append("\n");
            }
            System.out.print(result.toString());

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void assign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}