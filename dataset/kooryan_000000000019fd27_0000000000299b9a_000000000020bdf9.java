import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(in.readLine());

            StringBuilder schedule = new StringBuilder();
            int[][] timeTable = new int[N][2];

            for (int j = 0; j < N; j++) {
                String[] line = in.readLine().split(" ");
                for (int m = 0; m < 2; m++) {
                    timeTable[j][m] = Integer.parseInt(line[m]);
                }
            }

            ArrayList<int[]> rangeC = new ArrayList<>();
            ArrayList<int[]> rangeJ = new ArrayList<>();
            boolean inRangeC = true;
            boolean inRangeJ = true;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < rangeC.size(); c++) {
                    inRangeC = (timeTable[r][0] < rangeC.get(c)[0]  && timeTable[r][1] <= rangeC.get(c)[0])
                            || (timeTable[r][0] >= rangeC.get(c)[1] && timeTable[r][1] > rangeC.get(c)[1]);
                    if (!inRangeC) {
                        break;
                    }
                }

                if (inRangeC) {
                    rangeC.add(timeTable[r]);

                    schedule.append("C");
                    continue;
                }

                for (int ja = 0; ja < rangeJ.size(); ja++) {
                    inRangeJ = (timeTable[r][0] < rangeJ.get(ja)[0] && timeTable[r][1] <= rangeJ.get(ja)[0])
                            || (timeTable[r][0] >= rangeJ.get(ja)[1] && timeTable[r][1] > rangeJ.get(ja)[1]);
                    if (!inRangeJ) {
                        break;
                    }
                }

                if (inRangeJ) {
                    rangeJ.add(timeTable[r]);
                    schedule.append("J");
                }

                if (!inRangeC && !inRangeJ) {
                    schedule.delete(0, schedule.length());
                    schedule.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + schedule.toString());
        }
    }
}
