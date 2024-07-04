import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] inputs = new int[t];
        
        for (int i = 0; i < t; i++) {
            inputs[i] = scanner.nextInt();
        }
        
        for (int input : inputs) {
            List<Integer> digits = new ArrayList<>();
            int num = input;
            
            while (num > 0) {
                digits.add(num % 10);
                num /= 10;
            }
            
            Collections.reverse(digits);
            int currentDepth = 0;
            
            for (int digit : digits) {
                while (currentDepth < digit) {
                    System.out.print("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    System.out.print(")");
                    currentDepth--;
                }
                System.out.print(digit);
            }
            
            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}