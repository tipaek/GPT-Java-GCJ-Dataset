import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + t + ":");
            
            if (n <= 500) {
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " 1");
                }
                continue;
            }
            
            int x = 2, y = 1;
            System.out.println("1 1");
            n -= 1;
            
            while (n >= y) {
                n -= y;
                System.out.println(x + " " + y);
                x++;
                y++;
            }
            
            while (n > 0) {
                System.out.println(y + " " + y);
                n--;
                y++;
            }
        }
        
        scanner.close();
    }
}