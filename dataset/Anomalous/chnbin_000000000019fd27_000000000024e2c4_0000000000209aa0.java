import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String result = "POSSIBLE";
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Set<Integer> multiples = new HashSet<>();

            if (n % 2 != 0) {
                for (int j = 1; j <= n; j++) {
                    multiples.add(j * n);
                }
                multiples.add(((1 + n) * n) / 2);

                if (!multiples.contains(k)) {
                    result = "IMPOSSIBLE";
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    multiples.add(j * n);
                }

                if (!multiples.contains(k)) {
                    result = "IMPOSSIBLE";
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }

    public static class TimeSlot {
        public int startTime;
        public int endTime;
        public int index;

        public TimeSlot(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }
}