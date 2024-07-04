import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            if (k % n != 0 || k < n) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                continue;
            }
            
            int quotient = k / n;
            StringBuilder sequence = new StringBuilder();
            sequence.append(quotient);
            
            for (int i = 1; i <= n; i++) {
                if (i != quotient) {
                    sequence.append(i);
                }
            }
            
            System.out.println("Case #" + testCase + ": POSSIBLE");
            printSequence(sequence.toString());
            
            for (int i = 1; i < n; i++) {
                sequence = new StringBuilder(sequence.charAt(sequence.length() - 1) + sequence.substring(0, sequence.length() - 1));
                printSequence(sequence.toString());
            }
        }
    }
    
    private static void printSequence(String sequence) {
        for (int i = 0; i < sequence.length() - 1; i++) {
            System.out.print(sequence.charAt(i) + " ");
        }
        System.out.println(sequence.charAt(sequence.length() - 1));
    }
}