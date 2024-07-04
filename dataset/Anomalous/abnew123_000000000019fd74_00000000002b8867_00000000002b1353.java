import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ":");
            
            if (n < 501) {
                for (int j = 0; j < n; j++) {
                    System.out.println((j + 1) + " " + 1);
                }
            } else if (n < 998) {
                for (int j = 0; j < 499; j++) {
                    if (j == n - 499) {
                        System.out.println((j + 1) + " " + 2);
                    }
                    System.out.println((j + 1) + " " + 1);
                }
            } else if (n < 1001) {
                System.out.println(1 + " " + 1);
                System.out.println(2 + " " + 1);
                System.out.println(3 + " " + 2);
                System.out.println(4 + " " + 2);
                System.out.println(5 + " " + 2);
                System.out.println(5 + " " + 1);
                
                for (int j = 5; j < 498; j++) {
                    if (j == n - 505) {
                        System.out.println((j + 1) + " " + 2);
                    }
                    System.out.println((j + 1) + " " + 1);
                }
            }
        }
        
        scanner.close();
    }
}