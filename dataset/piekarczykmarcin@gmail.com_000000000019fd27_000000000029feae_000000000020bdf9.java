import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Comparator<ArrayList<Integer>> byTime = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (!o1.get(1).equals(o2.get(1)))
                    return o1.get(1) - o2.get(1);
                else
                    return o1.get(2) - o2.get(2);
            }
        };

        Comparator<ArrayList<Integer>> byNumber = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        };
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        final int MINUTES_IN_THE_DAY = 1440;

        for (int t = 0; t < T; t++) {

            boolean isPossible = true;
            int N = in.nextInt();
            ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();
            int[] numberOfTasks = new int[MINUTES_IN_THE_DAY];
            for (int n = 0; n < N; n++) {
                ArrayList<Integer>task= new ArrayList<>();
                task.add(n);
                task.add(in.nextInt());
                task.add(in.nextInt());
                tasks.add(task);
                for (int i = task.get(1); i < task.get(2); i++)
                    numberOfTasks[i]++;
            }

            /*tasks.sort(byTime);
            for (ArrayList<Integer> task : tasks) System.out.println(task.get(1) + " " + task.get(2));
            tasks.sort(byNumber);
            for (ArrayList<Integer> task : tasks) System.out.println(task.get(1) + " " + task.get(2));
            for (int i = 0; i < MINUTES_IN_THE_DAY; i++) {
                System.out.print(numberOfTasks[i] + " ");
            }*/

            for (int i = 0; i < MINUTES_IN_THE_DAY; i++)
                if (numberOfTasks[i] > 2) {
                    isPossible = false;
                    break;
                }

            StringBuilder answer = new StringBuilder().append("Case #").append(t+1).append(": ");
            if (isPossible) {
                tasks.sort(byTime);

                int currentStart = tasks.get(0).get(1);
                int currentEnd = tasks.get(0).get(2);
                int currentParent = 1;
                tasks.get(0).add(currentParent);

                for (int i = 1; i < N; i++) {
                    tasks.get(i).add(-currentParent);
                    if (tasks.get(i).get(2) > currentEnd) {
                        currentParent *= -1;
                        currentEnd = tasks.get(i).get(2);
                    }
                }

                tasks.sort(byNumber);
                for (int i = 0; i < N; i++) {
                    if ((tasks.get(i).get(3)) == 1)
                        answer.append("C");
                    else
                        answer.append("J");
                }
            }
            else
                answer.append("IMPOSSIBLE");
            System.out.println(answer);
        }
    }
}