import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int r = in.nextInt();
            int s = in.nextInt();

//            int[] rs = new int[r * s];
//            int[] ss = new int[r * s];
//
//            for (int i = 0; i < s; i++) {
//                for (int j = 0; j < r; j++) {
//                    rs[i * r + j] = j;
//                    ss[i * r + j] = i;
//                }
//            }

//            print(rs, ss);

            int res = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r - 1; i++) {
                for (int j = 0; j < s - 1; j++) {
                    int a = (r - i) * (s - 1) - j;
                    int b = r - i - 1;
                    res++;
                    sb.append(a);
                    sb.append(' ');
                    sb.append(b);
                    sb.append('\n');
//                    move(a, b, rs, ss);

//                    print(rs, ss);
                }
//                System.out.println("HHHH");
            }
//            move(2, 3, rs, ss);

            System.out.println("Case #" + (t + 1) + ": " + res);
            System.out.print(sb);
        }
    }

    static void move(int a, int b, int[] rs, int[] ss) {
        int[] brs = Arrays.copyOfRange(rs, a, a + b);
        int[] bss = Arrays.copyOfRange(ss, a, a + b);

        print(brs, bss);
        System.arraycopy(rs, 0, rs, b, a);
        System.arraycopy(brs, 0, rs, 0, b);

        System.arraycopy(ss, 0, ss, b, a);
        System.arraycopy(bss, 0, ss, 0, b);
    }

    static void print(int [] rs, int[] ss) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rs.length; i++) {
            sb.append("(");
            sb.append(rs[i] + 1);
            sb.append(", ");
            sb.append(ss[i] + 1);
            sb.append(") ");
        }
        System.out.println(sb);
    }
}
