import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long T = Long.parseLong(st.nextToken());

        for (long i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            long[] slices = new long[N];
            long[] uniqueSlices = new long[N];
            Map<Long, Integer> sliceCountMap = new HashMap<>();
            int uniqueCount = 0;
            int needed = 0;

            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                slices[j] = Long.parseLong(st.nextToken());
                sliceCountMap.put(slices[j], sliceCountMap.getOrDefault(slices[j], 0) + 1);

                if (sliceCountMap.get(slices[j]) == 1) {
                    uniqueSlices[uniqueCount++] = slices[j];
                }
            }

            if (D == 2) {
                needed = calculateNeededForD2(uniqueSlices, sliceCountMap, uniqueCount);
            } else if (D == 3) {
                needed = calculateNeededForD3(uniqueSlices, sliceCountMap, uniqueCount, slices);
            }

            System.out.println("Case #" + (i + 1) + ": " + needed);
        }
    }

    private static int calculateNeededForD2(long[] uniqueSlices, Map<Long, Integer> sliceCountMap, int uniqueCount) {
        for (int j = 0; j < uniqueCount; j++) {
            if (sliceCountMap.get(uniqueSlices[j]) > 1) {
                return 0;
            }
        }
        return 1;
    }

    private static int calculateNeededForD3(long[] uniqueSlices, Map<Long, Integer> sliceCountMap, int uniqueCount, long[] slices) {
        for (int j = 0; j < uniqueCount; j++) {
            if (sliceCountMap.get(uniqueSlices[j]) > 2) {
                return 0;
            }
        }

        for (int j = 0; j < uniqueCount; j++) {
            if (sliceCountMap.get(uniqueSlices[j]) > 1) {
                return 1;
            }
        }

        for (int j = 0; j < uniqueCount; j++) {
            for (int k = 0; k < uniqueCount; k++) {
                if (j != k && slices[j] == 2 * slices[k]) {
                    return 1;
                }
            }
        }

        return 2;
    }
}