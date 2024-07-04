import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            String result = "IMPOSSIBLE";
            
            if (k % n == 0 && (k / n <= n)) {
                result = "POSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
            
            if (result.equals("POSSIBLE")) {
                int start = k / n;
                for (int row = 0; row < n; row++) {
                    StringBuilder gridRow = new StringBuilder();
                    for (int col = 0; col < n; col++) {
                        gridRow.append(start).append(" ");
                        start = (start % n) + 1;
                    }
                    System.out.println(gridRow.toString().trim());
                    start = (start - 2 + n) % n + 1;
                }
            }
        }
        scanner.close();
    }
}