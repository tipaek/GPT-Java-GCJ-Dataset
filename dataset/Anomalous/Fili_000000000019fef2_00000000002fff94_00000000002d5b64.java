import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.print("Case #" + testCase + ": ");
            solve();
        }
    }

    private static void solve() {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        System.out.println((rows - 1) * (columns - 1));
        
        int offset = 0;
        for (int i = rows; i >= 2; i--) {
            for (int j = 0; j < columns - 1; j++) {
                System.out.println(i + " " + ((rows * columns - 1) - (offset * columns) - i - j));
            }
            offset++;
        }
    }
}