import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution {

    public static String solution(Map<Integer, ArrayList<Integer>> map, Map<String, Character> ordered) {
        boolean isFirstEntry = true;
        PriorityQueue<Integer> cameronQueue = new PriorityQueue<>();
        PriorityQueue<Integer> jamieQueue = new PriorityQueue<>();

        for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> ends = entry.getValue();

            if (ends.size() > 2)
                return "IMPOSSIBLE";

            if (isFirstEntry) {
                isFirstEntry = false;
                cameronQueue.add(ends.get(0));
                ordered.put(entry.getKey() + "-" + ends.get(0), 'C');

                if (ends.size() == 2) {
                    jamieQueue.add(ends.get(1));
                    ordered.put(entry.getKey() + "-" + ends.get(1), 'J');
                }
                continue;
            }

            int start = entry.getKey();

            for (int end : ends) {
                if (!cameronQueue.isEmpty() && !jamieQueue.isEmpty() && start < cameronQueue.peek() && start < jamieQueue.peek()) {
                    return "IMPOSSIBLE";
                }

                if (cameronQueue.isEmpty() || start >= cameronQueue.peek()) {
                    cameronQueue.poll();
                    ordered.put(entry.getKey() + "-" + end, 'C');
                    cameronQueue.offer(end);
                } else if (jamieQueue.isEmpty() || start >= jamieQueue.peek()) {
                    jamieQueue.poll();
                    ordered.put(entry.getKey() + "-" + end, 'J');
                    jamieQueue.offer(end);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Entry<String, Character> entry : ordered.entrySet()) {
            result.append(entry.getValue());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            testCases--;

            TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
            Map<String, Character> ordered = new LinkedHashMap<>();

            int n = in.nextInt();
            in.nextLine();

            for (int i = 0; i < n; ++i) {
                String line = in.nextLine();
                String[] parts = line.split(" ");
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);

                ArrayList<Integer> ends = map.getOrDefault(from, new ArrayList<>());
                ends.add(to);
                map.put(from, ends);
                ordered.put(from + "-" + to, '-');
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(map, ordered));
        }
    }
}