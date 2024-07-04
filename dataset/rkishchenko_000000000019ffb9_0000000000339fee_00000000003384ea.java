import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            long[] parameters = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            String solution = solve(parameters[0], parameters[1]);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(long left, long right) {
        long i = 1;
        while (i <= Math.max(left, right)) {
            if (right > left) {
                right -= i;
            } else {
                left -= i;
            }
            i++;
        }

        return (i - 1) + " " + left + " " + right;
    }

}
