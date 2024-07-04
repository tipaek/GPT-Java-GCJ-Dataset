package Codejam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ParentingPartnering {
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

            boolean isPossible = true;

            for (int i = 0; i < tasks; i++) {
                String[] task = br.readLine().split(" ");
                int start = Integer.parseInt(task[0]);
                int end = Integer.parseInt(task[1]);

                if (cEndTimes.isEmpty() || start >= cEndTimes.get(cEndTimes.size() - 1)) {
                    cStartTimes.add(start);
                    cEndTimes.add(end);
                    schedule.append("C");
                } else if (jEndTimes.isEmpty() || start >= jEndTimes.get(jEndTimes.size() - 1)) {
                    jStartTimes.add(start);
                    jEndTimes.add(end);
                    schedule.append("J");
                } else {
                    isPossible = false;
                    for (int n = i + 1; n < tasks; n++) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (isPossible) {
                System.out.printf("CASE #%d: %s%n", x + 1, schedule.toString());
            } else {
                System.out.printf("CASE #%d: IMPOSSIBLE%n", x + 1);
            }
        }
    }
}