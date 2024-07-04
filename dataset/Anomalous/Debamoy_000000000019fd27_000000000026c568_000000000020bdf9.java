import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int taskCount = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[taskCount][2];
            List<String> result = new ArrayList<>(Collections.nCopies(taskCount, "C"));

            for (int i = 0; i < taskCount; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            for (int i = 0; i < taskCount; i++) {
                for (int j = 0; j < taskCount; j++) {
                    if (i != j && tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                        first.add(i);
                        second.add(j);
                    }
                }
            }

            boolean impossible = false;
            for (int i = 0; i < first.size(); i++) {
                int a = first.get(i);
                int b = second.get(i);

                if (result.get(Math.min(a, b)).equals("J")) {
                    result.set(Math.max(a, b), "C");
                } else {
                    result.set(Math.max(a, b), "J");
                }
            }

            for (int i = 0; i < first.size(); i++) {
                if (Collections.frequency(first, first.get(i)) > 1) {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (String s : result) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
    }
}