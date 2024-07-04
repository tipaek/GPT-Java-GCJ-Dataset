import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = input.nextInt();

            Set<Integer> busyC = new HashSet<>();
            Set<Integer> busyJ = new HashSet<>();
            StringBuilder solution = new StringBuilder();

            System.out.print("Case #" + t + ": ");
            boolean possible = true;

            for (int i = 0; i < activityCount; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                Set<Integer> activity = IntStream.range(start, end).boxed().collect(Collectors.toSet());

                if (Collections.disjoint(busyC, activity)) {
                    solution.append('C');
                    busyC.addAll(activity);
                } else if (Collections.disjoint(busyJ, activity)) {
                    solution.append('J');
                    busyJ.addAll(activity);
                } else {
                    System.out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println(solution);
            }
        }

        input.close();
    }
}