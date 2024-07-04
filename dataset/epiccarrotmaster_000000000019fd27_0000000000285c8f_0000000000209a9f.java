import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = Integer.parseInt(in.nextLine());
        for (int k = 1; k <= N; k++) {
            String rawNum = in.nextLine();
            StringBuilder sb = new StringBuilder();

            boolean close = false, prevIs1 = false;
            for (char c : rawNum.toCharArray()) {
                if (c == '1') {
                    if (!prevIs1) {
                        prevIs1 = true;
                        sb.append('(');
                    }
                    close = true;
                } else {
                    if (close) {
                        sb.append(')');
                        close = false;
                    }
                    prevIs1 = false;
                }
                sb.append(c);
            }
            if (close) sb.append(')');

            System.out.println("Case #" + k + ": " + sb.toString());
        }
    }
}