import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            String str = in.next();
            char[] arr = str.toCharArray();
            int k = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                int m = arr[i] - '0';
                for (int j = k; j < m; j++) {
                    res.append('(');
                }
                for (int j = m; j < k; j++) {
                    res.append(')');
                }
                res.append(m);
                k = m;
            }

            for (int i = 0; i < k; i++) {
                res.append(')');
            }
            System.out.println("Case #" + t + ": " + res);
        }
    }
}