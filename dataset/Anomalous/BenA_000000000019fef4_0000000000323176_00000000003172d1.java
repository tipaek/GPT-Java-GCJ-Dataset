import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] directoryInput = scanner.nextLine().split(" ");
            int diners = Integer.parseInt(directoryInput[1]);

            String[] sliceInput = scanner.nextLine().split(" ");
            Long[] slices = new Long[sliceInput.length];

            for (int i = 0; i < sliceInput.length; i++) {
                slices[i] = Long.parseLong(sliceInput[i]);
            }

            int result = calculateSlices(slices, diners);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static int calculateSlices(Long[] slices, int diners) {
        Map<Long, Integer> sliceCountMap = new HashMap<>();

        for (Long slice : slices) {
            sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
        }

        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            if (entry.getValue() >= diners) {
                return 0;
            }
        }

        if (diners == 2) {
            return 1;
        }

        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            if (sliceCountMap.containsKey(entry.getKey() * 2)) {
                return 1;
            }
        }

        long highestSlice = Collections.max(sliceCountMap.keySet());
        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            if (highestSlice > entry.getKey()) {
                return 1;
            }
        }

        return 2;
    }
}