import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int x = 0; x < cases; x++) {
            int tasks = Integer.parseInt(br.readLine());

            ArrayList<Integer> cEndTimes = new ArrayList<>();
            ArrayList<Integer> jEndTimes = new ArrayList<>();
            ArrayList<Integer> cStartTimes = new ArrayList<>();
            ArrayList<Integer> jStartTimes = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < tasks; i++) {
                String[] taskTimes = br.readLine().split(" ");
                int start = Integer.parseInt(taskTimes[0]);
                int end = Integer.parseInt(taskTimes[1]);

                if (cEndTimes.isEmpty() || start >= cEndTimes.get(cEndTimes.size() - 1)) {
                    cStartTimes.add(start);
                    cEndTimes.add(end);
                    schedule.append("C");
                } else if (end <= cStartTimes.get(cStartTimes.size() - 1)) {
                    cStartTimes.add(0, start);
                    cEndTimes.add(0, end);
                    schedule.append("C");
                } else if (jEndTimes.isEmpty() || start >= jEndTimes.get(jEndTimes.size() - 1)) {
                    jStartTimes.add(start);
                    jEndTimes.add(end);
                    schedule.append("J");
                } else if (end <= jStartTimes.get(jStartTimes.size() - 1)) {
                    jStartTimes.add(0, start);
                    jEndTimes.add(0, end);
                    schedule.append("J");
                } else {
                    for (int n = i + 1; n < tasks; n++) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (schedule.length() < tasks) {
                System.out.println("CASE #" + (x + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("CASE #" + (x + 1) + ": " + schedule.toString());
            }
        }
    }
}