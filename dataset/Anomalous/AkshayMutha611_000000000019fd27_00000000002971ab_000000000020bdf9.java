import java.util.*;

public class Solution {
    int t, n, start_time, end_time, xyz;
    Map<Integer, String> map = new HashMap<>();

    public static void main(String args[]) {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    void takeInputAndSolve() {
        Scanner s = new Scanner(System.in);
        t = s.nextInt();

        for (xyz = 0; xyz < t; xyz++) {
            n = s.nextInt();
            List<Integer> start_times = new ArrayList<>();
            List<Integer> end_times = new ArrayList<>();

            for (int b = 0; b < n; b++) {
                start_time = s.nextInt();
                end_time = s.nextInt();
                start_times.add(start_time);
                end_times.add(end_time);
            }

            String outputString = checkForImpossible(start_times, end_times);
            if (outputString.isEmpty()) {
                populateMap(start_times, end_times);
                outputString = generateOutputString();
            }

            System.out.println(outputString);
        }
        s.close();
    }

    String checkForImpossible(List<Integer> start_times, List<Integer> end_times) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (start_times.get(i + 1) > start_times.get(i) && end_times.get(i + 1) < Collections.max(end_times)) {
                count++;
            }
            if (count == 2) {
                return "Case #" + (xyz + 1) + ": IMPOSSIBLE";
            }
        }
        return "";
    }

    void populateMap(List<Integer> start_times, List<Integer> end_times) {
        for (int l = 0; l < n; l++) {
            map.put(start_times.get(l), end_times.get(l).toString());
        }
    }

    String generateOutputString() {
        TreeMap<Integer, String> sorted = new TreeMap<>(map);
        StringBuilder w = new StringBuilder("C");

        for (int m = 0; m < n - 1; m++) {
            int a = (Integer) sorted.keySet().toArray()[m + 1];
            int b = (Integer) sorted.keySet().toArray()[m];
            int c = Integer.parseInt(sorted.get(sorted.keySet().toArray()[m + 1]));
            int d = Integer.parseInt(sorted.get(sorted.keySet().toArray()[m]));

            if (a > b && (c < d || a < b)) {
                if (w.charAt(w.length() - 1) == 'C') {
                    w.append("J");
                } else {
                    w.append("C");
                }
            } else {
                w.append(w.charAt(w.length() - 1));
            }
        }
        return "Case #" + (xyz + 1) + ": " + w.toString();
    }
}