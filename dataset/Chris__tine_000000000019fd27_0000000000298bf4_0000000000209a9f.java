import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String S = scanner.next();
            String s = helper(S);
            System.out.printf("Case #%d: %s\n", i + 1, s);
        }
    }
    
    public static String helper(String S) {
        //String to int arr
        int n = S.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Character.getNumericValue(S.charAt(i));
        }
        //add parenthesis
        StringBuilder sb = new StringBuilder();
        int leftP = arr[0];
        int l = 0;
        int r = 0;
        for (int i = 0 ; i < arr[0]; i++) {
            sb.append("(");
        }
        // sb.append(StringUtils.repeat("(", arr[0]));
        sb.append(Integer.toString(arr[0]));
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                l = arr[i] - arr[i - 1];
                for (int j = 0 ; j < l; j++) {
                    sb.append("(");
                }
                // sb.append("(".repeat(l));
                sb.append(Integer.toString(arr[i]));
                leftP += l;
            } else if (arr[i] < arr[i - 1]) {
                r = arr[i - 1] - arr[i];
                for (int j = 0 ; j < r; j++) {
                    sb.append(")");
                }
                // sb.append(")".repeat(r));
                sb.append(Integer.toString(arr[i]));
                leftP -= r;
            } else {
                sb.append(Integer.toString(arr[i]));
            }
        }

        if (leftP > 0) {
            for (int j = 0 ; j < leftP; j++) {
                sb.append(")");
            }
            // sb.append(")".repeat(leftP));
        }
        String s = sb.toString();
        return s;
    }
}