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
                String[] inputs = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(inputs[0]);
                tasks[i][1] = Integer.parseInt(inputs[1]);
            }

            boolean impossible = false;
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

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
                int idx1 = first.get(i);
                int idx2 = second.get(i);
                int minIdx = Math.min(idx1, idx2);
                int maxIdx = Math.max(idx1, idx2);

                if (result.get(minIdx).equals("J")) {
                    result.set(maxIdx, "C");
                } else if (result.get(minIdx).equals("C")) {
                    result.set(maxIdx, "J");
                }
            }

            System.out.print("Case #" + t + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String s : result) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}