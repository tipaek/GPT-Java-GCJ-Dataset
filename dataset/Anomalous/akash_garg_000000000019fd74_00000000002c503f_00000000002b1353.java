import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        long[] powersOfTwo = new long[33];
        powersOfTwo[1] = 1;
        
        for (int i = 2; i <= 32; i++) {
            powersOfTwo[i] = powersOfTwo[i - 1] * 2;
        }
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            long n = scanner.nextLong();
            int index = 0;
            
            while (powersOfTwo[index] <= n) {
                index++;
            }
            index--;
            
            for (int i = 1; i <= index; i++) {
                System.out.println(index + " " + i);
            }
            n -= powersOfTwo[index];
            boolean reverseOrder = false;
            
            while (n != 0) {
                index--;
                if (powersOfTwo[index] > n) {
                    n--;
                    if (reverseOrder) {
                        System.out.println(index + " " + 1);
                    } else {
                        System.out.println(index + " " + index);
                    }
                    continue;
                }
                if (reverseOrder) {
                    for (int i = 1; i <= index; i++) {
                        System.out.println(index + " " + i);
                    }
                } else {
                    for (int i = index; i >= 1; i--) {
                        System.out.println(index + " " + i);
                    }
                }
                reverseOrder = !reverseOrder;
                n -= powersOfTwo[index];
            }
        }
        scanner.close();
    }
}