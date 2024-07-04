import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] results = new int[10];
            
            for (int index = 0; index < 10; index++) {
                System.out.println(index + 1);
                System.out.flush();
                results[index] = scanner.nextInt();
            }
            
            for (int result : results) {
                System.out.print(result);
            }
            System.out.println();
            System.out.flush();
            
            String response = scanner.next();
        }
    }
}