import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            final int activityCount = input.nextInt();

            final Set<Integer> busyC = new HashSet<>();
            final Set<Integer> busyJ = new HashSet<>();
            final StringBuilder solution = new StringBuilder(activityCount);

            System.out.print(String.format("Case #%d: ", t));
            for(int i = 0; i < activityCount; ++i) {
                final Set<Integer> activity = IntStream.range(input.nextInt(), input.nextInt())
                        .boxed()
                        .collect(Collectors.toSet());

                if(activity.stream().noneMatch(busyC::contains)) {
                    solution.append('C');
                    busyC.addAll(activity);
                }
                else if(activity.stream().noneMatch(busyJ::contains)) {
                    solution.append('J');
                    busyJ.addAll(activity);
                }
                else {
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }

            if(solution.length() == activityCount)
                System.out.println(solution);
        }
    }
}