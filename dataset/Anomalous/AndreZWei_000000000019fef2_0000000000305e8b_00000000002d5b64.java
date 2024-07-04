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
        StringBuilder result = new StringBuilder();

        if (r == 2) {
            switch (s) {
                case 2:
                    result.append("1\n2 1");
                    break;
                case 3:
                    result.append("2\n2 1\n4 1");
                    break;
                case 4:
                    result.append("3\n2 1\n4 1\n6 1");
                    break;
                case 5:
                    result.append("4\n2 1\n4 1\n6 1\n8 1");
                    break;
                case 6:
                    result.append("5\n2 1\n4 1\n6 1\n8 1\n10 1");
                    break;
                case 7:
                    result.append("6\n2 1\n4 1\n6 1\n8 1\n10 1\n12 1");
                    break;
                default:
                    result.append("0 0");
            }
        } else if (r == 3) {
            switch (s) {
                case 2:
                    result.append("2\n3 2\n2 1");
                    break;
                case 3:
                    result.append("4\n3 2\n6 2\n2 1\n4 1");
                    break;
                case 4:
                    result.append("6\n3 2\n6 2\n9 2\n2 1\n4 1\n6 1");
                    break;
                default:
                    result.append("0 0");
            }
        } else if (r == 4) {
            switch (s) {
                case 2:
                    result.append("3\n4 3\n3 2\n2 1");
                    break;
                case 3:
                    result.append("6\n4 3\n8 3\n3 2\n6 2\n2 1\n4 1");
                    break;
                default:
                    result.append("0 0");
            }
        } else {
            result.append("4\n5 4\n4 3\n3 2\n2 1");
        }

        return result.toString();
    }
}