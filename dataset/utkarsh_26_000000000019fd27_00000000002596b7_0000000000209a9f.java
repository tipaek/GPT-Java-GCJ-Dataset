import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String input = sc.nextLine();
            String ans = "";
            int i = 0;
            char ch = input.charAt(i);
            int val = Integer.parseInt(String.valueOf(ch));
            while (val-- > 0) {
                ans += '(';
            }
            ans += ch;
            int len = input.length();
            for (i = 1; i < len; i++) {
                ch = input.charAt(i);
                val = Integer.parseInt(String.valueOf(ch));
                int peekValue = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
                if (peekValue > val) {
                    int temp = peekValue - val;
                    while (temp-- > 0) {
                        ans += ')';
                    }
                } else if (peekValue < val) {
                    int temp = val - peekValue;
                    while (temp-- > 0) {
                        ans += '(';
                    }
                }
                ans += ch;
            }
            int peekValue = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
            if (peekValue > 0) {
                int temp = peekValue;
                while (temp-- > 0) {
                    ans += ')';
                }
            }
            System.out.println("Case #" + testCase + ": "+ans);
        }
        sc.close();
    }
}