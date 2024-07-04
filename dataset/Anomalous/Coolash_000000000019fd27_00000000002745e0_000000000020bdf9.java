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
            boolean isImpossible = false;
            Map<Integer, Integer> JTime = new HashMap<>();
            Map<Integer, Integer> CTime = new HashMap<>();
            StringBuilder turns = new StringBuilder();

            for (int k = 0; k < activities; k++) {
                String[] time = br.readLine().split("\\s+");
                int st = Integer.parseInt(time[0]);
                int et = Integer.parseInt(time[1]);
                boolean problemToJ = false;
                boolean problemToC = false;

                for (Map.Entry<Integer, Integer> entry : JTime.entrySet()) {
                    int jStartTime = entry.getKey();
                    int jEndTime = entry.getValue();
                    if ((st >= jStartTime && st < jEndTime) || (et > jStartTime && et < jEndTime)) {
                        problemToJ = true;
                        break;
                    }
                }

                if (!problemToJ) {
                    JTime.put(st, et);
                    turns.append('J');
                    continue;
                }

                for (Map.Entry<Integer, Integer> entry : CTime.entrySet()) {
                    int cStartTime = entry.getKey();
                    int cEndTime = entry.getValue();
                    if ((st >= cStartTime && st < cEndTime) || (et > cStartTime && et < cEndTime)) {
                        problemToC = true;
                        break;
                    }
                }

                if (!problemToC) {
                    CTime.put(st, et);
                    turns.append('C');
                    continue;
                }

                isImpossible = true;
                break;
            }

            if (isImpossible) {
                pw.println("Case #" + (j + 1) + ": IMPOSSIBLE");
            } else {
                pw.println("Case #" + (j + 1) + ": " + turns.toString());
            }
        }

        pw.close();
        br.close();
    }
}