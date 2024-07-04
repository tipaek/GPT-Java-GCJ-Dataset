import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int m = 1; m <= t; m++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            boolean[] colHasRepeat = new boolean[n];
            List<Integer>[] colValues = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                colValues[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                Set<Integer> rowValues = new HashSet<>();
                boolean rowRepeatFlag = false;

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(st.nextToken());

                    if (i == j) {
                        trace += value;
                    }

                    if (!rowValues.add(value) && !rowRepeatFlag) {
                        rowRepeats++;
                        rowRepeatFlag = true;
                    }

                    if (!colValues[j].contains(value)) {
                        colValues[j].add(value);
                    } else if (!colHasRepeat[j]) {
                        colRepeats++;
                        colHasRepeat[j] = true;
                    }
                }
            }

            System.out.println("Case #" + m + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        br.close();
    }
}