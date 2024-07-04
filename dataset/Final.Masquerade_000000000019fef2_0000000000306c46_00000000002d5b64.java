package round1b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(in.readLine());
        Solver s = new Solver();
        for (int i = 1; i <= testCount; i++) {
            s.solve(i, in);
        }
    }

    static class Solver {

        public void solve(int k, BufferedReader in) throws IOException {
            String[] l = in.readLine().split(" ");
            int a = Integer.parseInt(l[0]);
            int a_buf = Integer.parseInt(l[0]);
            int b = Integer.parseInt(l[1]);
            int b_buf = Integer.parseInt(l[1]);
            int c = 0;
            StringBuilder res = new StringBuilder();

            int A = 0, B = 1;

            while ( true ) {
                b_buf -= 1;
                a_buf -= 1;
                c++;
                A = a * b - 1 - (a - 1);
                B = a - 1;
                res.append(A).append(" ").append(B).append("\n");

                if (b_buf == 1 || a_buf == 1) break;
            }

            while (B != 1) {
                c++;
                A = A - 1;
                B = B - 1;
                res.append(A).append(" ").append(B).append("\n");
                
            }

            System.out.println("Case #" + k + ": " + c);
            System.out.println(res);
        }

    }
}

//
//1
//2 3
//
//