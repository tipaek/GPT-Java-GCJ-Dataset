import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int taskCount = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[taskCount][2];
            List<String> result = new ArrayList<>(Collections.nCopies(taskCount, "C"));
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            for (int i = 0; i < taskCount; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            boolean impossible = false;

            for (int i = 0; i < taskCount; i++) {
                for (int j = 0; j < taskCount; j++) {
                    if (tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                        first.add(i);
                        second.add(j);
                    }
                }
            }

            if (first.size() == taskCount) {
                impossible = true;
            }

            for (int i = 0; i < first.size(); i++) {
                int firstIndex = first.get(i);
                int secondIndex = second.get(i);
                if (result.get(Math.min(firstIndex, secondIndex)).equals("J")) {
                    result.set(Math.max(firstIndex, secondIndex), "C");
                } else if (result.get(Math.min(firstIndex, secondIndex)).equals("C")) {
                    result.set(Math.max(firstIndex, secondIndex), "J");
                }
            }

            for (int i = 0; i < first.size(); i++) {
                int count = 0;
                for (int j = 0; j < second.size(); j++) {
                    if (first.get(j) == second.get(i)) {
                        count++;
                    }
                }
                if (count > 2) {
                    impossible = true;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (!impossible) {
                for (String s : result) {
                    System.out.print(s);
                }
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }
}