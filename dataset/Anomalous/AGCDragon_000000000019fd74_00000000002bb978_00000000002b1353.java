import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");
            
            if (N <= 1000) {
                int count = 1;
                System.out.println("1 1");
                
                for (int x = 2; x <= 500; x++) {
                    if (count == N) {
                        break;
                    }
                    
                    if (count + x - 1 > N) {
                        for (int y = 0; y < N - count; y++) {
                            System.out.println((x + y) + " 1");
                        }
                        break;
                    }
                    
                    System.out.println(x + " 2");
                    count += x - 1;
                }
            }
        }
        
        scanner.close();
    }
}