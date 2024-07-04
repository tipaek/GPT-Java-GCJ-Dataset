import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int n = scanner.nextInt();
                System.out.println("Case #" + i + ":");
                for (int j = 1; j <= n; j++) {
                    System.out.println(j + " " + 1);
                }
            }
        }
    }
}