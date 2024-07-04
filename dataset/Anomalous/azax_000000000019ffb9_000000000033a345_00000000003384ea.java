import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = Integer.parseInt(sc.nextLine());
            for (int index = 0; index < numCases; index++) {
                String[] line = sc.nextLine().split(" ");
                long left = Long.parseLong(line[0]);
                long right = Long.parseLong(line[1]);

                long[] result = computeSolution(left, right);

                System.out.printf("Case #%d: %d %d %d%n", index + 1, result[0], result[1], result[2]);
            }
        }
    }

    private static long[] computeSolution(long left, long right) {
        long step = 1;
        while (true) {
            if (left >= right) {
                if (step <= left) {
                    left -= step;
                } else {
                    break;
                }
            } else {
                if (step <= right) {
                    right -= step;
                } else {
                    break;
                }
            }
            step++;
        }

        return new long[]{step - 1, left, right};
    }
}