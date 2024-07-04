import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + tc + ":");
            
            if (N <= 500) {
                for (int i = 1; i <= N; i++) {
                    System.out.println(i + " " + 1);
                }
            } else if (N == 501) {
                System.out.println(1 + " " + 1);
                System.out.println(2 + " " + 1);
                System.out.println(3 + " " + 2);
                
                for (int i = 3; i < 500; i++) {
                    System.out.println(i + " " + 1);
                }
            }
        }
        
        scanner.close();
    }
}