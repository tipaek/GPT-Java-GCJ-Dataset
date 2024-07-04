import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int test = 1; test <= testCaseCount; test++) {
            String[] input = br.readLine().split(" ");
            String[] degrees = br.readLine().split(" ");
            int slice = Integer.parseInt(input[0]);
            int table = Integer.parseInt(input[1]);

            List<Long> degreeList = Arrays.stream(degrees)
                                          .map(Long::parseLong)
                                          .collect(Collectors.toList());
            Collections.sort(degreeList);

            Map<Integer, List<Long>> degreeFrequencyMap = new HashMap<>();
            int count = 1;

            for (int i = 0; i < degreeList.size() - 1; i++) {
                if (degreeList.get(i).equals(degreeList.get(i + 1))) {
                    count++;
                } else {
                    degreeFrequencyMap.computeIfAbsent(count, k -> new ArrayList<>()).add(degreeList.get(i));
                    count = 1;
                }
            }

            degreeFrequencyMap.computeIfAbsent(count, k -> new ArrayList<>()).add(degreeList.get(slice - 1));
            int cuts = findRepeated(degreeFrequencyMap, table);

            if (cuts == table) {
                System.out.println("Case #" + test + ": 0");
            } else if (cuts == -1) {
                System.out.println("Case #" + test + ": " + (table - 1));
            } else {
                if (slice - 1 - degreeList.lastIndexOf(degreeFrequencyMap.get(cuts)) >= 0)
                    System.out.println("Case #" + test + ": " + (table - cuts - 1));
            }
        }
    }

    private static int findRepeated(Map<Integer, List<Long>> map, int table) {
        if (table == 1) {
            return -1;
        }
        if (map.containsKey(table)) {
            return table;
        }
        return findRepeated(map, table - 1);
    }
}