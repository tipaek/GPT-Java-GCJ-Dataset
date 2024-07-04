import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int number = scanner.nextInt();
            long sum = 0;
            
            System.out.println("Case #" + testCase + ": ");
            
            if (number < 501) {
                for (int j = 1; j <= number; j++) {
                    sum++;
                    System.out.println(j + " 1");
                }
            } else if (number == 501) {
                for (int j = 1; j <= number - 3; j++) {
                    if (j == 3) {
                        sum += 2;
                        System.out.println(j + " 2");
                    }
                    sum++;
                    System.out.println(j + " 1");
                }
            }
        }
        
        scanner.close();
    }
}