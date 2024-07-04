import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader("/home/dev/projects/codejam20/src/input3.txt")));

        //# of test cases
        int T = in.nextInt();

        //iterate test cases
        for (int t = 1; t <= T; t++) {
            int numActivities = in.nextInt();

            List<int[]> activities = new ArrayList<>();
            for (int i = 0; i < numActivities; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new int[]{start, end, i});
            }
            solveActivityList(t, activities);
        }
    }

    private static void solveActivityList(int testCase, List<int[]> activities) {
        System.out.print("Case #" + testCase + ": ");
        //sort by start time
        activities.sort(Comparator.comparing(a -> a[0]));

        String output = divideActivities(activities);
        System.out.println(output);
    }

    private static String divideActivities(List<int[]> activities) {
        Stack<int[]> cStack = new Stack<>();
        Stack<int[]> jStack = new Stack<>();
        char [] assignees = new char[activities.size()];
        for (int i = 0; i < activities.size(); i++) {
            // c's first item
            if (cStack.isEmpty()) {
                cStack.push(activities.get(i));
                assignees[activities.get(i)[2]]= 'C';
                continue;
            } else {
                if (cStack.peek()[1] <= activities.get(i)[0]) {
                    cStack.push(activities.get(i));
                    assignees[activities.get(i)[2]]= 'C';
                    continue;
                } else {
                    // if j's first item
                    if (jStack.isEmpty()) {
                        jStack.push(activities.get(i));
                        assignees[activities.get(i)[2]]= 'J';
                        continue;
                    } else {
                        if (jStack.peek()[1] <= activities.get(i)[0]) {
                            jStack.push(activities.get(i));
                            assignees[activities.get(i)[2]]= 'J';
                            continue;
                        } else {
                            return "IMPOSSIBLE";
                        }
                    }
                }
            }

        }

        return new String(assignees);
    }


}
