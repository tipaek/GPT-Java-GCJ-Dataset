import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // String input = generateInput(10,5);
        // System.out.print(input);
        // Scanner in = new Scanner(input);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int tasks = in.nextInt();
            int[] j = new int[1441];
            int[] c = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean IMPOSSIBLE = false;
            for (int k = 0; k < tasks; k++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                if (IMPOSSIBLE) continue;
                if (free(j, start, stop)) {
                    fill(j, start, stop);
                    result.append("J");
                }
                else if(free(c, start, stop)) {
                    fill(c, start, stop);
                    result.append("C");
                } else {
                    IMPOSSIBLE = true;
                }
            }
            if (IMPOSSIBLE) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            else System.out.println("Case #" + (i+1) + ": " + result.toString());

            // System.out.println(Arrays.toString(j));
            // System.out.println(Arrays.toString(c));
        }
    }

    private static void fill(int[] j, int start, int stop) {
        for (int i = start; i < stop; i++) {
            j[i] = 1;
        }
    }

    private static boolean free(int[] j, int start, int stop) {
        for (int i = start; i < stop; i++) {
            if (j[i] != 0) return false;
        }
        return true;
    }

    public static String generateInput (int n, int c) {
        Random random = new Random();
        StringBuilder input = new StringBuilder();
        input.append(n + "\n");
        for (int i = 0; i < n; i++) {
            input.append(c + "\n");
            for (int j = 0; j < c; j++) {
                int start = random.nextInt(1440);
                int end = random.nextInt(400) + start;
                input.append(start + " " + end + "\n");
            }
        }
        return input.toString();
    }
}
