import java.util.*;
import java.util.Scanner;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int k = 1; k <= num; k++) {
            String line = scanner.nextLine();
            String result = helper(line.toCharArray());
            System.out.println("Case #" + k + ": " + result);
        }
    }

    static String helper(char input[]) {
        StringBuilder builder = new StringBuilder();
        int n = input.length;
        int prev = -1;
        for(int i = 0; i < n; i++) {
            int count = input[i] - '0';
            if(prev > 0 && prev != count) {
                for(int j = 0; j < prev; j++) {
                    builder.append(")");
                }
            }
            if(count > 0 && prev != count) {
                for(int j = 0; j < count; j++) {
                    builder.append("(");
                }
            }
            prev = count;
            builder.append(count);
        }
        if(prev > 0 ) {
            for(int i = 0; i < prev; i++) {
                builder.append(")");
            }
        }
        return builder.toString();
    }

}
