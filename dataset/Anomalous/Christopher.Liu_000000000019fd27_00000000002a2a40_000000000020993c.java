import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int sum = num1 + num2;
            int product = num1 * num2;
            System.out.printf("Case #%d: %d %d%n", i, sum, product);
        }
    }
}