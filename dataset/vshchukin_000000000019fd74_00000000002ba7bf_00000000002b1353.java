import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PascalWalk solver = new PascalWalk();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PascalWalk {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int num = in.nextInt();
            int sum = 0;
            int step = 0;
            boolean nextState = false;
            out.printf("Case #%d\n", testNumber);
            while (sum < num) {
                //out.println("sum is "+sum+ " and step = "+step);
                if (step == 0 && !nextState) {
                    out.println("1 1");
                    sum++;
                    step++;
                } else if (step == 1 && !nextState) {
                    out.println("1 2");
                    sum++;
                    step++;
                } else if (!nextState) {
                    out.printf("%d 2\n", step);
                    sum += (step);
                    step++;
                    if (sum + step > num) {
                        nextState = true;
                        step--;
                    }
                } else {
                    out.printf("%d 1\n", step);
                    sum++;
                    step--;
                }
            }
        }

    }
}

