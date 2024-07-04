import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int tasksCount = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[tasksCount][2];
            List<String> result = new ArrayList<>(Collections.nCopies(tasksCount, "J"));

            for (int i = 0; i < tasksCount; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            List<Integer> first = new LinkedList<>();
            List<Integer> second = new LinkedList<>();

            for (int i = 0; i < tasks.length; i++) {
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                        first.add(i);
                        second.add(j);
                    }
                }
            }

            for (int i = 0; i < first.size(); i++) {
                int index1 = first.get(i);
                int index2 = second.get(i);
                int minIndex = Math.min(index1, index2);
                int maxIndex = Math.max(index1, index2);

                if (result.get(minIndex).equals("J")) {
                    result.set(maxIndex, "C");
                } else if (result.get(minIndex).equals("C")) {
                    result.set(maxIndex, "J");
                }
            }

            System.out.print("Case #" + t + ": ");
            for (String s : result) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}