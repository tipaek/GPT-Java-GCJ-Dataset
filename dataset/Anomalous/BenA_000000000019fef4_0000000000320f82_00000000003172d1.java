import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] directions = scanner.nextLine().split(" ");
            int diners = Integer.parseInt(directions[1]);

            String[] sliceStrings = scanner.nextLine().split(" ");
            Long[] slices = new Long[sliceStrings.length];
            for (int i = 0; i < sliceStrings.length; i++) {
                slices[i] = Long.parseLong(sliceStrings[i]);
            }

            int result = calculateSlices(slices, diners);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static int calculateSlices(Long[] slices, int diners) {
        HashMap<Long, Integer> sliceCountMap = new HashMap<>();
        for (Long slice : slices) {
            sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
        }

        if (sliceCountMap.size() == 1) {
            return diners - 1;
        }

        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            if (entry.getValue() >= diners) {
                return 0;
            }
        }

        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            if (sliceCountMap.containsKey(entry.getKey() * 2)) {
                return 1;
            }
        }

        for (Map.Entry<Long, Integer> entry : sliceCountMap.entrySet()) {
            if (entry.getValue() + 1 >= diners) {
                return 1;
            }
        }

        return 2;
    }
}