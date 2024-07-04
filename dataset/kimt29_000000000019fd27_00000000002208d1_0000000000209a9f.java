import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            String s = scanner.nextLine();
            String result = "";
            int lCount = 0;
            int rCount = 0;
            int n = Integer.parseInt(s.substring(0, 1));
            int d = depth(s, 0, n);
            for (int k = 0; k < n; k++) {
                result += "(";
                lCount++;
                rCount++;
            }
            for (int k = 0; k < d; k++) {
                result += Integer.toString(n);
            }
            for (int j = d; j < s.length(); j++) {
                n = Integer.parseInt(s.substring(j, j+1));
                if (n < lCount) {
                    int left = lCount;
                    for (int k = 0; k < left - n; k++) {
                        result += ")";
                        rCount--;
                        lCount--;
                    }
                } else if (n > lCount) {
                    int left = lCount;
                    for (int k = 0; k < n - left; k++) {
                        result += "(";
                        lCount++;
                        rCount++;
                    }
                }
                d = depth(s, j, n);
                for (int k = 0; k < d; k++) {
                    result += Integer.toString(n);
                }
                j += d - 1;
            }
            for (int k = 0; k < rCount; k++) {
                result += ")";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    public static int depth(String s, int ind, int n) {
        int d = 0;
        String tmp = s.substring(ind, ind + 1);
        String str = Integer.toString(n);
        while (ind < s.length() && str.equals(tmp)) {
            d++;
            ind++;
            if (ind < s.length()) tmp = s.substring(ind, ind + 1);
        }
        return d;
    }
}