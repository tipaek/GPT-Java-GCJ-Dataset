import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int intervalsCount = scanner.nextInt();
            Map<Integer, Set<Character>> timeMap = new TreeMap<>();
            List<Integer> times = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < intervalsCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                times.add(startTime);
                times.add(endTime);
                timeMap.putIfAbsent(startTime, new HashSet<>());
                timeMap.putIfAbsent(endTime, new HashSet<>());
            }

            boolean impossible = false;
            for (int k = 0; k < times.size(); k += 2) {
                int startTime = times.get(k);
                int endTime = times.get(k + 1);
                boolean hasJ = false, hasC = false, hasBoth = false;

                for (int time = startTime; time < endTime; time++) {
                    if (timeMap.containsKey(time)) {
                        Set<Character> set = timeMap.get(time);
                        if (set.contains('J') && set.contains('C')) {
                            hasBoth = true;
                            break;
                        } else if (set.contains('J')) {
                            hasJ = true;
                        } else if (set.contains('C')) {
                            hasC = true;
                        }
                    }
                }

                if (hasBoth) {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }

                char assignment = hasJ ? 'C' : 'J';
                for (int time = startTime; time < endTime; time++) {
                    timeMap.get(time).add(assignment);
                }
                result.append(assignment);
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}