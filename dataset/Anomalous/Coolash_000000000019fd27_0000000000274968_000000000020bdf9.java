import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int testcases = Integer.parseInt(br.readLine());

        for (int j = 0; j < testcases; j++) {
            int activities = Integer.parseInt(br.readLine());
            Map<Integer, Integer> JTime = new HashMap<>();
            Map<Integer, Integer> CTime = new HashMap<>();
            StringBuilder turns = new StringBuilder();

            for (int k = 0; k < activities; k++) {
                String[] time = br.readLine().split("\\s+");
                int st = Integer.parseInt(time[0]);
                int et = Integer.parseInt(time[1]);

                boolean problemToJ = isOverlapping(JTime, st, et);
                boolean problemToC = isOverlapping(CTime, st, et);

                if (!problemToJ) {
                    JTime.put(st, et);
                    turns.append("J");
                } else if (!problemToC) {
                    CTime.put(st, et);
                    turns.append("C");
                } else {
                    turns.setLength(0);
                    turns.append("IMPOSSIBLE");
                    break;
                }
            }

            pw.println("Case #" + (j + 1) + ": " + turns.toString());
        }

        pw.close();
        br.close();
    }

    private static boolean isOverlapping(Map<Integer, Integer> timeMap, int st, int et) {
        for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if ((st >= start && st < end) || (et > start && et < end)) {
                return true;
            }
        }
        return false;
    }
}