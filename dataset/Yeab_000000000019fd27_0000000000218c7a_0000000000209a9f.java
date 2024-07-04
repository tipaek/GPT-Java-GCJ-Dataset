
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static String balance(int[] in) {
        StringBuilder rv = new StringBuilder();
        for (int i = 0; i < in.length - 1; i++) {
            rv.append(in[i]);
            if (in[i] < in[i+1]) {
                int diff = in[i+1] - in[i];
                for (int j = 0; j < diff; j++) {
                    rv.append('(');
                }
            } else {
                int diff = -in[i + 1] + in[i];
                for (int j = 0; j < diff; j++) {
                    rv.append(')');
                }
            }
        }
        return rv.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cases; i++) {
            String in = '0' + scan.nextLine() + '0';
            String balanced = balance(Arrays.stream(in.split("")).mapToInt(Integer::parseInt).toArray());
            System.out.printf("Case #%d: %s\n", (i + 1), balanced.substring(1));
        }
    }
}
