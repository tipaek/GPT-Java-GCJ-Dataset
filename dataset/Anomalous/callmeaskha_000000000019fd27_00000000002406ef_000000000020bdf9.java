import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            boolean[] cOccupied = new boolean[24 * 60];
            boolean[] jOccupied = new boolean[24 * 60];
            int N = Integer.parseInt(br.readLine());
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (int n = 0; n < N; n++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (canSchedule(cOccupied, start, end)) {
                    schedule.append("C");
                    markOccupied(cOccupied, start, end);
                } else if (canSchedule(jOccupied, start, end)) {
                    schedule.append("J");
                    markOccupied(jOccupied, start, end);
                } else {
                    possible = false;
                }
            }

            System.out.println("Case #" + t + ": " + (possible ? schedule.toString() : "IMPOSSIBLE"));
        }
    }

    private static boolean canSchedule(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            if (occupied[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markOccupied(boolean[] occupied, int start, int end) {
        for (int i = start; i < end; i++) {
            occupied[i] = true;
        }
    }
}