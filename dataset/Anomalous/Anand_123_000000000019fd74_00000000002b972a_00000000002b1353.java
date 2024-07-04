import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + t + ":");
            System.out.println(1 + " " + 1);
            n--;
            int row = 2;
            
            while (n > 0) {
                if (n >= row - 1) {
                    n -= (row - 1);
                    System.out.println(row + " " + 2);
                } else {
                    n--;
                    System.out.println(row + " " + 1);
                }
                row++;
            }
        }
        
        scanner.close();
    }
}