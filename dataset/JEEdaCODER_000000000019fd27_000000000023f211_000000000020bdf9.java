
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
                if (start < 0 || start > 1440 || stop < 0 || stop > 1440 || start > stop) {
                    IMPOSSIBLE = true;
                    break;
                }
                if (free(j, start, stop)) {
                    fill(j, start, stop);
                    result.append("J");
                }
                else if(free(c, start, stop)) {
                    fill(c, start, stop);
                    result.append("C");
                } else {
                    IMPOSSIBLE = true;
                    break;
                }
            }
            System.out.print("Case #" + (i+1) + ": ");
            if (IMPOSSIBLE) System.out.println("IMPOSSIBLE");
            else System.out.println(result.toString());
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
}
