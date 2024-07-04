import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        int test;
        Scanner in = new Scanner(System.in);
        test = in.nextInt();
        in.nextLine();

        for (int t = 1; t <= test; t++) {
            String s = in.nextLine();
            int len = s.length();
            int[] ar = new int[len];
            int[] start = new int[len];
            int[] end = new int[len];
            for (int i = 0; i < len; i++) {
                ar[i] = s.charAt(i) - '0';
            }
            start[0] = ar[0];
            for (int i = 1; i < len; i++) {
                int temp = ar[i] - ar[i-1];
                if (temp < 0) temp = 0;
                start[i] = temp;
            }
            end[len-1] = ar[len-1];
            for (int i = 0; i < len - 1; i++) {
                int temp = ar[i] - ar[i+1];
                if (temp < 0) temp = 0;
                end[i] = temp;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < start[i]; j++) {
                    sb.append("(");
                }
                sb.append(s.charAt(i));
                for (int j = 0; j < end[i]; j++) {
                    sb.append(")");
                }
            }

            System.out.println(String.format("Case #%d: %s", t, sb.toString()));
        }
    }
}
