import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            Scanner sc = new Scanner(in);

            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                String s = sc.next();

                StringBuilder sb = new StringBuilder();
                int lopen = 0;
                for (int i = 0; i < s.length(); i++) {
                    int d = s.charAt(i) - '0';

                    if (d > lopen) {
                        for (int j = 0; j < d - lopen; j++) {
                            sb.append('(');
                        }
                    } else {
                        for (int j = 0; j < lopen - d; j++) {
                            sb.append(')');
                        }
                    }
                    sb.append(d);
                    lopen = d;
                }
                for (int i = 0; i < lopen; i++) {
                    sb.append(')');
                }

                out.println(String.format("Case #%d: %s", t + 1, sb));
            }
        }
    }

}
