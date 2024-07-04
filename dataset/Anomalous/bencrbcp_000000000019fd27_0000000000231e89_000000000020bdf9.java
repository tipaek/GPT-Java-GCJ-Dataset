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
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < tasks; i++) {
                String[] times = br.readLine().split(" ");
                int currStart = Integer.parseInt(times[0]);
                int currEnd = Integer.parseInt(times[1]);

                if (cEndTimes.isEmpty() || currStart >= cEndTimes.get(cEndTimes.size() - 1)) {
                    cStartTimes.add(currStart);
                    cEndTimes.add(currEnd);
                    output.append("C");
                } else if (currEnd <= cStartTimes.get(cStartTimes.size() - 1)) {
                    int n = cStartTimes.size() - 1;
                    while (n > 0 && currEnd < cStartTimes.get(n - 1)) {
                        n--;
                    }
                    cStartTimes.add(n, currStart);
                    cEndTimes.add(n, currEnd);
                    output.append("C");
                } else if (jEndTimes.isEmpty() || currStart >= jEndTimes.get(jEndTimes.size() - 1)) {
                    jStartTimes.add(currStart);
                    jEndTimes.add(currEnd);
                    output.append("J");
                } else if (currEnd <= jStartTimes.get(jStartTimes.size() - 1)) {
                    int n = jStartTimes.size() - 1;
                    while (n > 0 && currEnd <= jStartTimes.get(n - 1)) {
                        n--;
                    }
                    jStartTimes.add(n, currStart);
                    jEndTimes.add(n, currEnd);
                    output.append("J");
                } else {
                    for (int n = i + 1; n < tasks; n++) {
                        br.readLine();
                    }
                    break;
                }
            }

            if (output.length() < tasks) {
                System.out.println("CASE #" + (x + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("CASE #" + (x + 1) + ": " + output);
            }
        }
    }
}