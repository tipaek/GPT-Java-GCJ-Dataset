import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int k = in.nextInt();
        for (int i = 1; i <= k; i++) {
            String inputString = in.next();
            String output = nestingDepth(inputString);
            System.out.println(output);
        } 
    }

    public static String nestingDepth(String string) {
        StringBuilder sb = new StringBuilder();
        int previous = 0;
        for (char c: string.toCharArray()) {
            int currentNum = Character.getNumericValue(c);
            String enclosed = encloseDepth(currentNum);
            if (previous == 0 || currentNum == 0) sb.append(enclosed);
            else if (previous <= currentNum) {
                sb.delete(sb.length() - previous, sb.length());
                sb.append(enclosed.substring(previous));
            } else if (currentNum < previous) {
                sb.delete(sb.length() - currentNum, sb.length());
                sb.append(enclosed.substring(currentNum));
            }
            previous = Character.getNumericValue(c);
        }

        return sb.toString();
    } 

    public static String encloseDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) sb.append("(");
        sb.append(String.valueOf(depth));
        for (int i = 0; i < depth; i++) sb.append(")");
        return sb.toString();
    }

}