import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int c = 1; c <= t; c++) {
            boolean[] a = new boolean[b];
            
            // Placeholder for the commented-out logic
            // Uncomment and implement the logic as needed
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(a[i] ? '1' : '0');
            }
            System.out.println(result);
            
            if (scanner.next().equals("N")) {
                break;
            }
        }
        
        scanner.close();
    }
}