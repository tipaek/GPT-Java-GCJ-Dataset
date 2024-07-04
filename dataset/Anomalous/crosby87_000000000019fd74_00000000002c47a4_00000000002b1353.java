import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int number = scanner.nextInt();
            System.out.println("Case #" + testCase + ": ");
            
            if (number == 501) {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                
                for (int i = 3; i <= 499; i++) {
                    System.out.println(i + " " + i);
                }
            } else {
                for (int i = 1; i <= number; i++) {
                    System.out.println(i + " " + i);
                }
            }
        }
        
        scanner.close();
    }
}