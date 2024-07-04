import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            BitSet jSchedule = new BitSet(24 * 60 + 1);
            BitSet cSchedule = new BitSet(24 * 60 + 1);

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                int nextJ = jSchedule.nextSetBit(start);
                boolean conflictsWithJ = nextJ >= start && nextJ < end;

                if (!conflictsWithJ) {
                    jSchedule.set(start, end);
                    result.append('J');
                    continue;
                }

                int nextC = cSchedule.nextSetBit(start);
                boolean conflictsWithC = nextC >= start && nextC < end;

                if (!conflictsWithC) {
                    cSchedule.set(start, end);
                    result.append('C');
                    continue;
                }

                isImpossible = true;
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + result.toString());
            }
        }
    }
}