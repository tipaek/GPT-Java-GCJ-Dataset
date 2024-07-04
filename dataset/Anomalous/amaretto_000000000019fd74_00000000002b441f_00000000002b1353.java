import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int sum = 0;
            
            System.out.println("Case #" + testCase + ":");
            
            if (n < 501) {
                for (int i = 1; i <= n; i++) {
                    if (sum == n) {
                        break;
                    }
                    System.out.println(i + " " + i);
                    sum += i;
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                System.out.println("3 3");
                sum = 5;
                
                for (int i = 4; i <= n; i++) {
                    if (sum >= n) {
                        break;
                    }
                    System.out.println(i + " " + i);
                    sum++;
                }
            }
        }
        
        scanner.close();
    }
}