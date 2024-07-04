import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
        }
        scanner.close();
    }
    
    public static void solve(Scanner scanner) {
        System.out.println();
        int n = scanner.nextInt();
        
        if (n < 40) {
            handleSmallN(n);
        } else {
            handleLargeN(n);
        }
    }
    
    private static void handleSmallN(int n) {
        int halfN = (n + 1) / 2;
        for (int i = 1; i <= halfN; i++) {
            System.out.println(i + " " + 1);
        }
        
        if (n % 2 == 0) {
            halfN++;
        }
        
        if (n > 3) {
            System.out.println(halfN + " " + 2);
        } else if (n == 3) {
            System.out.println("3 1");
        } else if (n == 2) {
            System.out.println("2 1");
        }
    }
    
    private static void handleLargeN(int n) {
        List<Integer> positions = new ArrayList<>();
        int x = n - 31;
        
        for (int i = 0; i < 31; i++) {
            if (x % 2 == 1) {
                positions.add(i);
            }
            x /= 2;
        }
        
        boolean leftToRight = true;
        int positionIndex = 0;
        
        for (int i = 0; i < 31 + positions.size(); i++) {
            if (positionIndex < positions.size() && positions.get(positionIndex) == i) {
                positionIndex++;
                for (int j = 0; j <= i; j++) {
                    if (leftToRight) {
                        System.out.println((i + 1) + " " + (j + 1));
                    } else {
                        System.out.println((i + 1) + " " + (i + 1 - j));
                    }
                }
                leftToRight = !leftToRight;
            } else {
                if (leftToRight) {
                    System.out.println((i + 1) + " 1");
                } else {
                    System.out.println((i + 1) + " " + (i + 1));
                }
            }
        }
    }
}