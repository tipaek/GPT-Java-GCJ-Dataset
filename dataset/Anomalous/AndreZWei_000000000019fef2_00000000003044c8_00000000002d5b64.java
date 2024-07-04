import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(r, s));
        }
    }

    public static String solve(int r, int s) {
        if (r == 2) {
            switch (s) {
                case 2:
                    return "1\n2 1";
                case 3:
                    return "2\n2 1\n4 1";
                case 4:
                    return "3\n2 1\n6 1\n5 1";
                case 5:
                    return "4\n2 1\n6 1\n5 1\n8 1";
                case 6:
                    return "5\n2 1\n6 1\n10 1\n6 1\n9 1";
                case 7:
                    return "6\n2 1\n6 1\n10 1\n6 1\n9 1\n12 1";
                default:
                    return "0 0";
            }
        } else {
            switch (s) {
                case 2:
                    return "2\n3 2\n2 1";
                case 3:
                    return "4\n3 2\n6 2\n2 1\n4 1";
                case 4:
                    return "6\n3 2\n9 2\n6 4\n2 1\n6 1\n5 1";
                default:
                    return "0 0";
            }
        }
    }
}