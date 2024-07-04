import java.util.Scanner;

public class Solution {
    public static int[] transformToArray(final String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }
    
    public static String computeNestingDepth(int[] arr) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr[0]; ++i) {
            sb.append("(");
        }
        sb.append(arr[0]);
        
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] < arr[i]) {
                for (int j = 0; j < arr[i] - arr[i - 1]; ++j) {
                    sb.append("(");
                }
            } else if (arr[i - 1] > arr[i]) {
                for (int j = 0; j < arr[i - 1] - arr[i]; ++j) {
                    sb.append(")");
                }
            }
            sb.append(arr[i]);
        }
        
        for (int i = 0; i < arr[arr.length - 1]; ++i) {
            sb.append(")");
        }
        
        return sb.toString();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; ++i) {
            int[] arr = transformToArray(in.nextLine());
            String nestingDepth = computeNestingDepth(arr);
            System.out.printf("Case #%d: %s%n", i + 1, nestingDepth);
        }
    }
}