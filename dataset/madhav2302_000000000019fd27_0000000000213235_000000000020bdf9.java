import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int testNumber = 1; testNumber <= T; testNumber++) {
            StringBuilder answer = new StringBuilder();
            int C = -1;
            int J = -1;
            int N = scanner.nextInt();

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(i -> i[0]));

            for (int taskNumber = 1; taskNumber <= N; taskNumber++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                queue.add(new int[]{start, end});
            }

            while (!queue.isEmpty()) {
                int[] interval = queue.poll();

                if (C <= interval[0]) {
                    C = interval[1];
                    answer.append("C");
                } else if (J <= interval[0]) {
                    J = interval[1];
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testNumber + ": " + answer);
        }
    }
}
