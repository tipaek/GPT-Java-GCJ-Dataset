import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = scanner.nextInt();
            writer.println("Case #" + cs + ":");

            int mul = 1;
            boolean dir = true;
            for (int i = 1; N > 0; i++) {
                if (i < 30 && mul <= N) {
                    if (dir) {
                        for (int j = 1; j <= i; j++) {
                            writer.println(i + " " + j);
                        }
                    } else {
                        for (int j = i; j > 0; j--) {
                            writer.println(i + " " + j);
                        }
                    }
                    dir = !dir;
                    N -= mul;
                    mul *= 2;
                    continue;
                }
                if (N >= 2 * i) {
                    if (dir) {
                        writer.println(i + " 1");
                        writer.println(i + " 2");
                        writer.println((i + 1) + " 2");
                    } else {
                        writer.println(i + " " + i);
                        writer.println(i + " " + (i - 1));
                        writer.println((i + 1) + " " + i);
                    }
                    N -= (2 * i);
                    i++;
                    if (N > 0) {
                        if (dir) {
                            writer.println(i + " 1");
                        } else {
                            writer.println(i + " " + i);
                        }
                        N--;
                    }
                    continue;
                }
                if (N == i) {
                    if (dir) {
                        writer.println(i + " 1");
                        writer.println(i + " 2");
                    } else {
                        writer.println(i + " " + i);
                        writer.println(i + " " + (i - 1));
                    }
                    N -= i;
                    continue;
                }
                if (dir) {
                    writer.println(i + " 1");
                } else {
                    writer.println(i + " " + i);
                }
                N--;
            }
        }
        writer.flush();
    }
}