import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine().trim();
            int[] arr = new int[s.length()];
            
            for (int j = 0; j < s.length(); j++) {
                arr[j] = Character.getNumericValue(s.charAt(j));
            }
            
            StringBuilder sb = new StringBuilder();
            appendOpeningBrackets(sb, arr[0]);
            sb.append(arr[0]);
            
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > arr[j - 1]) {
                    appendOpeningBrackets(sb, arr[j] - arr[j - 1]);
                } else if (arr[j] < arr[j - 1]) {
                    appendClosingBrackets(sb, arr[j - 1] - arr[j]);
                }
                sb.append(arr[j]);
            }
            
            appendClosingBrackets(sb, arr[arr.length - 1]);
            System.out.println("Case #" + i + ": " + sb);
        }
    }

    private static void appendOpeningBrackets(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append('(');
        }
    }

    private static void appendClosingBrackets(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(')');
        }
    }
}