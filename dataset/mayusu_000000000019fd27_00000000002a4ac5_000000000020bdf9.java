import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            Map<Integer, Map.Entry<Integer, Integer>> schedule = new HashMap<>();
            int n = in.nextInt();
            for (int j = 1; j <= n; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                schedule.put(j, new AbstractMap.SimpleEntry<>(startTime, endTime));
            }
            List<Map.Entry<Integer, Map.Entry<Integer, Integer>>> sortedSchedule = schedule.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(o -> o.getValue().getKey()))
                    .collect(Collectors.toList());

            String solution = new String(new char[n]).replace("\0", "N");
            List<Map.Entry<Integer, Integer>> jamieSchedule = new ArrayList<>();
            List<Map.Entry<Integer, Integer>> cameronSchedule = new ArrayList<>();
            boolean isThereOverlapping = false;
            for (int j = 0; j < n; j++) {
                Map.Entry<Integer, Map.Entry<Integer, Integer>> entry = sortedSchedule.get(j);
                int position = entry.getKey() - 1;
                Map.Entry<Integer, Integer> interval = entry.getValue();
                for (Map.Entry<Integer, Integer> jamieEntry : jamieSchedule) {
                    if (isThereOverlapping(interval, jamieEntry)) {
                        isThereOverlapping = true;
                    }
                }
                if (!isThereOverlapping) {
                    jamieSchedule.add(interval);
                    solution = changeCharInPosition(position, 'J', solution);
                } else {
                    isThereOverlapping = false;
                    for (Map.Entry<Integer, Integer> cameronEntry : cameronSchedule) {
                        if (isThereOverlapping(interval, cameronEntry)) {
                            isThereOverlapping = true;
                        }
                    }
                    if (!isThereOverlapping) {
                        cameronSchedule.add(interval);
                        solution = changeCharInPosition(position, 'C', solution);
                    } else {
                        solution = "IMPOSSIBLE";
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static boolean isThereOverlapping(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
        return Math.min(entry1.getValue(), entry2.getValue()) - Math.max(entry1.getKey(), entry2.getKey()) > 0;
    }

    public static String changeCharInPosition(int position, char ch, String str) {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

}