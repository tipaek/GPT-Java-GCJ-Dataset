import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            if (k % n != 0 || k < n) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                continue;
            }
            
            int t = k / n;
            StringBuilder s = new StringBuilder(String.valueOf(t));
            
            for (int i = 1; i <= n; i++) {
                if (i != t) {
                    s.append(i);
                }
            }
            
            System.out.println("Case #" + testCase + ": POSSIBLE");
            printSequence(s.toString());
            
            for (int i = 1; i < n; i++) {
                char lastChar = s.charAt(s.length() - 1);
                s.insert(0, lastChar).deleteCharAt(s.length() - 1);
                printSequence(s.toString());
            }
        }
    }
    
    private static void printSequence(String s) {
        for (int j = 0; j < s.length() - 1; j++) {
            System.out.print(s.charAt(j) + " ");
        }
        System.out.println(s.charAt(s.length() - 1));
    }
}