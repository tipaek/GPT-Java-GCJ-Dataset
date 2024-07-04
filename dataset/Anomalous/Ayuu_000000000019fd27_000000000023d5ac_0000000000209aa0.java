import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int k = n + 1; 
            
            System.out.println("Case #" + testCase + ": " + "POSSIBLE");
            
            for (int i = 1; i <= n; i++) { 
                int temp = k; 
                
                while (temp <= n) { 
                    System.out.print(temp + " "); 
                    temp++; 
                } 
                
                for (int j = 1; j < k; j++) {
                    System.out.print(j + " "); 
                }
                
                k--; 
                System.out.println(); 
            }
        }
        
        scanner.close();
        System.exit(0);
    }
}