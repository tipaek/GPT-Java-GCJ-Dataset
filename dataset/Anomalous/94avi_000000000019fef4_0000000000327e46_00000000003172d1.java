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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(br.readLine());

            for (int test = 1; test <= testCaseCount; test++) {
                String[] input = br.readLine().split(" ");
                String[] degreeStrings = br.readLine().split(" ");
                
                int sliceCount = Integer.parseInt(input[0]);
                int tableCount = Integer.parseInt(input[1]);

                List<Long> degrees = Arrays.stream(degreeStrings)
                                           .map(Long::parseLong)
                                           .collect(Collectors.toList());
                Collections.sort(degrees);

                Map<Integer, List<Long>> degreeFrequencyMap = new HashMap<>();
                int frequency = 1;

                for (int i = 0; i < degrees.size() - 1; i++) {
                    if (degrees.get(i).equals(degrees.get(i + 1))) {
                        frequency++;
                    } else {
                        degreeFrequencyMap.computeIfAbsent(frequency, k -> new ArrayList<>()).add(degrees.get(i));
                        frequency = 1;
                    }
                }
                degreeFrequencyMap.computeIfAbsent(frequency, k -> new ArrayList<>()).add(degrees.get(sliceCount - 1));

                int cuts = findMaxFrequency(degreeFrequencyMap, tableCount);

                if (cuts == tableCount) {
                    System.out.println("Case #" + test + ": 0");
                } else if (cuts == -1) {
                    System.out.println("Case #" + test + ": " + (tableCount - 1));
                } else {
                    if (sliceCount - 1 - degrees.lastIndexOf(degreeFrequencyMap.get(cuts)) >= 0) {
                        System.out.println("Case #" + test + ": " + (tableCount - cuts - 1));
                    }
                }
            }
        }
    }

    private static int findMaxFrequency(Map<Integer, List<Long>> degreeFrequencyMap, int tableCount) {
        if (tableCount == 1) return -1;
        if (degreeFrequencyMap.containsKey(tableCount)) return tableCount;
        return findMaxFrequency(degreeFrequencyMap, tableCount - 1);
    }
}