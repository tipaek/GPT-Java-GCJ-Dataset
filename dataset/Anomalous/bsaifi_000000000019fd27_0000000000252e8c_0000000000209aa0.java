import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = sc.nextInt();
            int k1 = sc.nextInt();
            
            if (k1 % n != 0 || k1 < n) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }
            
            int t = k1 / n;
            StringBuilder s = new StringBuilder(String.valueOf(t));
            
            for (int i = 1; i <= n; i++) {
                if (i != t) {
                    s.append(i);
                }
            }
            
            System.out.println("Case #" + caseNum + ": POSSIBLE");
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