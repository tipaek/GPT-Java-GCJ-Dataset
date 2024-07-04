import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static int getFullRows(int n) {
        int result = 0;
        for (int i = n; i >= 1; i--) {
            if ((i & (i-1)) == 0) {
                result = (int) Math.floor(Math.log(i)/Math.log(2.0));
                break;
            }
        }
        return result;
    }

    private static void generate(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.println(i + " " + j);
                } else {
                    System.out.println(i + " " + (i-j+1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; ++t) {
            int target = scanner.nextInt();
            int fullRows = getFullRows(target);
            target -= Math.pow(2, fullRows);

            System.out.println("Case #" + t + ":");
            generate(fullRows);
            int start = fullRows+1;
            if (fullRows % 2 == 0) {
                for (int i = 0; i <= target; i++) {
                    System.out.println(start + " " + start++);
                }
            } else {
                for (int i = 0; i <= target; i++) {
                    System.out.println(start++ + " " + 1);
                }
            }
            System.out.flush();
        }
    }
}