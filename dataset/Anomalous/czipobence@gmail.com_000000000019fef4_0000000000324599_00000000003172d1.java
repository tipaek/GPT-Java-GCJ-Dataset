import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            Map<Long, Integer> sliceCounts = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long slice = scanner.nextLong();
                sliceCounts.put(slice, sliceCounts.getOrDefault(slice, 0) + 1);
            }

            int maxSliceCount = Collections.max(sliceCounts.values());
            int cuts = d - 1;

            if (maxSliceCount >= d || d == 1) {
                cuts = 0;
            } else if (d == 2 || maxSliceCount == d - 1) {
                cuts = 1;
            } else if (d == 3) {
                boolean canDouble = false;
                for (long sliceSize : sliceCounts.keySet()) {
                    for (long otherSliceSize : sliceCounts.keySet()) {
                        if (sliceSize == 2 * otherSliceSize) {
                            canDouble = true;
                            break;
                        }
                    }
                    if (canDouble) break;
                }
                cuts = canDouble ? 1 : 2;
            }

            System.out.println("Case #" + testCase + ": " + cuts);
        }
    }
}