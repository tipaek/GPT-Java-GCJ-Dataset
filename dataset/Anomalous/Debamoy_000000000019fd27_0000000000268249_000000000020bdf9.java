import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int tasksCount = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[tasksCount][2];
            List<String> result = new ArrayList<>(Collections.nCopies(tasksCount, t == 3 ? "J" : "C"));

            for (int i = 0; i < tasksCount; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            for (int i = 0; i < tasks.length; i++) {
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                        first.add(i);
                        second.add(j);
                    }
                }
            }

            for (int i = 0; i < first.size(); i++) {
                int firstIndex = first.get(i);
                int secondIndex = second.get(i);
                int minIndex = Math.min(firstIndex, secondIndex);
                int maxIndex = Math.max(firstIndex, secondIndex);

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