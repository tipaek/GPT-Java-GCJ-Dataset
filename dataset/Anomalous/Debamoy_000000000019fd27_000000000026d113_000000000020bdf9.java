import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int numTasks = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[numTasks][2];
            List<String> result = new ArrayList<>(Collections.nCopies(numTasks, "C"));
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();
            boolean impossible = false;

            for (int i = 0; i < numTasks; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            for (int i = 0; i < numTasks; i++) {
                for (int j = 0; j < numTasks; j++) {
                    if (tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                        first.add(i);
                        second.add(j);
                    }
                }
            }

            for (int i = 0; i < first.size(); i++) {
                int idx1 = first.get(i);
                int idx2 = second.get(i);
                if (result.get(Math.min(idx1, idx2)).equals("J")) {
                    result.set(Math.max(idx1, idx2), "C");
                } else if (result.get(Math.min(idx1, idx2)).equals("C")) {
                    result.set(Math.max(idx1, idx2), "J");
                }
            }

            for (int i = 0; i < first.size(); i++) {
                if (Collections.frequency(first, first.get(i)) > 1) {
                    impossible = true;
                    break;
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