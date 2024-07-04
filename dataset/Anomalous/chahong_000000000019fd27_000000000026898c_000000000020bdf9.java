import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] schedule = new int[t][2];
            Map<Integer, List<Integer>> startTimesMap = new HashMap<>();

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                startTimesMap.computeIfAbsent(schedule[j][0], k -> new ArrayList<>()).add(j);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] work = new char[t];
            int maxEndTime = Arrays.stream(schedule).mapToInt(a -> a[1]).max().orElse(0);

            int cEnd = 0, jEnd = 0;
            boolean cAvailable = true, jAvailable = true, possible = true;
            int currentIndex = 0;

            for (int time = 0; time <= maxEndTime; time++) {
                if (time == cEnd) cAvailable = true;
                if (time == jEnd) jAvailable = true;

                while (currentIndex < t && schedule[currentIndex][0] == time) {
                    int[] currentTask = schedule[currentIndex];
                    int taskIndex = startTimesMap.get(currentTask[0]).remove(0);

                    if (cAvailable) {
                        work[taskIndex] = 'C';
                        cAvailable = false;
                        cEnd = currentTask[1];
                    } else if (jAvailable) {
                        work[taskIndex] = 'J';
                        jAvailable = false;
                        jEnd = currentTask[1];
                    } else {
                        possible = false;
                        break;
                    }
                    currentIndex++;
                }

                if (!possible) break;
            }

            System.out.println("Case #" + (i + 1) + ": " + (possible ? new String(work) : "IMPOSSIBLE"));
        }

        sc.close();
    }
}