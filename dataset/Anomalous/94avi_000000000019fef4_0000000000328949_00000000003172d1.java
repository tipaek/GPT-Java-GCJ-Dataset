import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String[] input = br.readLine().split(" ");
            String[] degreesInput = br.readLine().split(" ");
            int sliceCount = Integer.parseInt(input[0]);
            int tableCount = Integer.parseInt(input[1]);

            List<Long> degreeList = Arrays.stream(degreesInput)
                                          .map(Long::parseLong)
                                          .collect(Collectors.toList());
            Collections.sort(degreeList);

            Map<Integer, List<Long>> frequencyMap = new HashMap<>();
            int frequency = 1;

            for (int i = 0; i < degreeList.size() - 1; i++) {
                if (degreeList.get(i).equals(degreeList.get(i + 1))) {
                    frequency++;
                } else {
                    frequencyMap.computeIfAbsent(frequency, k -> new ArrayList<>()).add(degreeList.get(i));
                    frequency = 1;
                }
            }
            frequencyMap.computeIfAbsent(frequency, k -> new ArrayList<>()).add(degreeList.get(sliceCount - 1));

            int cuts = findMaxFrequency(frequencyMap, tableCount);

            if (cuts == tableCount) {
                System.out.println("Case #" + testCase + ": 0");
            } else if (cuts == -1) {
                int maxFactor = findMaxFactor(degreeList, tableCount);
                System.out.println("Case #" + testCase + ": " + (tableCount - maxFactor));
            } else {
                System.out.println("Case #" + testCase + ": " + (tableCount - cuts - 1));
            }
        }
    }

    private static int findMaxFactor(List<Long> degreeList, int tableCount) {
        int maxFactor = 1;
        for (int i = 0; i < degreeList.size() - 1; i++) {
            for (int j = i + 1; j < degreeList.size(); j++) {
                if (degreeList.get(j) % degreeList.get(i) == 0 && degreeList.get(i) != 1) {
                    int factor = (int) (degreeList.get(j) / degreeList.get(i));
                    maxFactor = Math.max(maxFactor, factor);
                }
            }
            if (maxFactor >= tableCount) {
                break;
            }
        }
        return maxFactor;
    }

    private static int findMaxFrequency(Map<Integer, List<Long>> frequencyMap, int tableCount) {
        if (tableCount == 1) {
            return -1;
        }
        return frequencyMap.containsKey(tableCount) ? tableCount : findMaxFrequency(frequencyMap, tableCount - 1);
    }
}