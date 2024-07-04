import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] dirInput = scanner.nextLine().split(" ");
            int diners = Integer.parseInt(dirInput[1]);

            String[] slicesInput = scanner.nextLine().split(" ");
            Long[] slices = new Long[slicesInput.length];
            for (int i = 0; i < slicesInput.length; i++) {
                slices[i] = Long.parseLong(slicesInput[i]);
            }

            int result = calculateSlices(slices, diners);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static int calculateSlices(Long[] slices, int diners) {
        Map<Long, Integer> sliceCountMap = new HashMap<>();

        for (Long slice : slices) {
            sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
        }

        for (int count : sliceCountMap.values()) {
            if (count >= diners) {
                return 0;
            }
        }

        for (Long key : sliceCountMap.keySet()) {
            if (sliceCountMap.containsKey(key * 2)) {
                return 1;
            }
        }

        for (int count : sliceCountMap.values()) {
            if (count + 1 >= diners) {
                return 1;
            }
        }

        return 2;
    }
}