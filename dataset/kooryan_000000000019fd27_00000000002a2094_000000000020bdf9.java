import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.CookieHandler;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(in.readLine());

            StringBuilder schedule = new StringBuilder();
            String[] scheduleHolder = new String[N];
            int[][] timeTable = new int[N][3];

            for (int j = 0; j < N; j++) {
                String[] line = in.readLine().split(" ");
                timeTable[j][0] = j;
                for (int m = 1; m < 3; m++) {
                    timeTable[j][m] = Integer.parseInt(line[m - 1]);
                }
            }

            List<int[]> range = Arrays.asList(timeTable);

            range.sort(Comparator.comparing(a -> a[1]));

            ArrayList<int[]> rangeC = new ArrayList<>();
            ArrayList<int[]> rangeJ = new ArrayList<>();
            boolean inRangeC = true;
            boolean inRangeJ = true;
            boolean possible = true;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < rangeC.size(); c++) {
                    inRangeC = (range.get(r)[1] < rangeC.get(c)[1]  && range.get(r)[2] <= rangeC.get(c)[1])
                            || (range.get(r)[1] >= rangeC.get(c)[2] && range.get(r)[2] > rangeC.get(c)[2]);

                    if (!inRangeC) {
                        break;
                    }
                }

                if (inRangeC) {
                    rangeC.add(range.get(r));
                    scheduleHolder[range.get(r)[0]] = "C";
                    continue;
                }

                for (int ja = 0; ja < rangeJ.size(); ja++) {
                    inRangeJ = (range.get(r)[1] < rangeJ.get(ja)[1] && range.get(r)[2] <= rangeJ.get(ja)[1])
                            || (range.get(r)[1] >= rangeJ.get(ja)[2] && range.get(r)[2] > rangeJ.get(ja)[2]);
                    if (!inRangeJ) {
                        break;
                    }
                }

                if (inRangeJ) {
                    rangeJ.add(timeTable[r]);
                    scheduleHolder[range.get(r)[0]] = "J";
                } else {
                    possible = false;
                    schedule.delete(0, schedule.length());
                    schedule.append("IMPOSSIBLE");
                    break;
                }
            }

            if (possible) {
                for (String s : scheduleHolder) {
                    schedule.append(s);
                }
            }

            System.out.println("Case #" + i + ": " + schedule.toString());
        }
    }
}
