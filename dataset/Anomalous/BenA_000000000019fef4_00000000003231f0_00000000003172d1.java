import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String[] dirs = scanner.nextLine().split(" ");
            int diners = Integer.parseInt(dirs[1]);

            String[] sliceStrings = scanner.nextLine().split(" ");
            Long[] slices = new Long[sliceStrings.length];
            for (int i = 0; i < sliceStrings.length; i++) {
                slices[i] = Long.parseLong(sliceStrings[i]);
            }

            int result = calculateMinimumSplits(slices, diners);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static int calculateMinimumSplits(Long[] slices, int diners) {
        Map<Long, Integer> sliceCountMap = new HashMap<>();
        for (Long slice : slices) {
            sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
        }

        for (int count : sliceCountMap.values()) {
            if (count >= diners) {
                return 0;
            }
        }

        if (diners == 2) {
            return 1;
        }

        for (Long slice : sliceCountMap.keySet()) {
            if (sliceCountMap.containsKey(slice * 2)) {
                return 1;
            }
        }

        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            Long slice = entry.getKey();
            int count = entry.getValue();

            if (count + 1 >= diners) {
                Long maxSlice = Collections.max(sliceCountMap.keySet());
                if (maxSlice > slice) {
                    return 1;
                }
            }
        }

        return 2;
    }
}