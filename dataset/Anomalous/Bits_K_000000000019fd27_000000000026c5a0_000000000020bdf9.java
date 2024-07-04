import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            char[] assigned = new char[n];
            Map<Character, String> schedule = new HashMap<>();
            Map<String, ArrayList<Integer>> ranges = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i][0] = start;
                intervals[i][1] = end;

                String key = start + " " + end;
                ranges.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
            }

            ArrayList<String> sortedKeys = new ArrayList<>(ranges.keySet());
            sortedKeys.sort((o1, o2) -> {
                int start1 = Integer.parseInt(o1.split(" ")[0]);
                int start2 = Integer.parseInt(o2.split(" ")[0]);
                return Integer.compare(start1, start2);
            });

            boolean possible = true;
            for (String key : sortedKeys) {
                ArrayList<Integer> list = ranges.get(key);
                String[] range = key.split(" ");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);

                for (int index : list) {
                    if (assignTask(schedule, 'C', start, end)) {
                        assigned[index] = 'C';
                    } else if (assignTask(schedule, 'J', start, end)) {
                        assigned[index] = 'J';
                    } else {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
                if (!possible) break;
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (char c : assigned) {
                    result.append(c);
                }
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }
            caseNumber++;
        }
    }

    private static boolean assignTask(Map<Character, String> schedule, char person, int start, int end) {
        if (!schedule.containsKey(person)) {
            schedule.put(person, start + " " + end);
            return true;
        } else {
            String[] times = schedule.get(person).split(" ");
            int existingStart = Integer.parseInt(times[0]);
            int existingEnd = Integer.parseInt(times[1]);

            if ((start >= existingStart && start < existingEnd) || (end > existingStart && end <= existingEnd) || (start <= existingStart && end >= existingEnd)) {
                return false;
            } else {
                schedule.put(person, Math.min(start, existingStart) + " " + Math.max(end, existingEnd));
                return true;
            }
        }
    }
}