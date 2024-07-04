import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int sum = 0;
            System.out.println("Case #" + test);

            if (n < 501) {
                for (int i = 0; i < n; i++) {
                    if (sum == n) {
                        break;
                    }
                    int position = i + 1;
                    System.out.println(position + " " + position);
                    sum += position;
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                System.out.println("3 3");
                sum = 5;
                
                for (int i = 3; i < n; i++) {
                    if (sum >= n) {
                        break;
                    }
                    int position = i + 1;
                    System.out.println(position + " " + position);
                    sum += 1;
                }
            }
        }
        
        scanner.close();
    }
}