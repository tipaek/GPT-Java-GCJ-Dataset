import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answer = new String[T];

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }

            int[][] original = Arrays.copyOf(activities, activities.length);
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            boolean isImpossible = false;
            int CEnd = -1, JEnd = -1;
            char[] sortedOrder = new char[N];
            Arrays.fill(sortedOrder, ' ');

            for (int time = 0; time <= 1500; time++) {
                for (int j = 0; j < N; j++) {
                    if (activities[j][0] == time) {
                        if (CEnd <= time) {
                            CEnd = activities[j][1];
                            sortedOrder[j] = 'C';
                        } else if (JEnd <= time) {
                            JEnd = activities[j][1];
                            sortedOrder[j] = 'J';
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                }
                if (isImpossible) break;
            }

            if (isImpossible) {
                answer[i] = "IMPOSSIBLE";
            } else {
                StringBuilder a = new StringBuilder();
                for (int[] activity : original) {
                    for (int j = 0; j < N; j++) {
                        if (activities[j][0] == activity[0] && activities[j][1] == activity[1]) {
                            a.append(sortedOrder[j]);
                            break;
                        }
                    }
                }
                answer[i] = a.toString();
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answer[i]);
        }
    }
}