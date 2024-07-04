// package codejam.q_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution implements Runnable{

//    public static void main(String... a) {
//        new Thread(new Solution_4()).start();
//    }

    @Override
    public void run() {
        try {
            solve();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solve () throws IOException {

        String s = "1\n" +
                "10\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "0\n" +
                "Y\n";


        int T;
        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner(s);
        PrintWriter out = new PrintWriter(System.out);

        T = in.nextInt();

        int B=in.nextInt();

        for (int t=1; t<=T; ++t) {
            if (B==10) {
                StringBuffer answer = new StringBuffer();
                for (int i=1; i<=10; ++i) {
                    out.println("" + i);
                    out.flush();
                    answer.append(in.nextInt());
                }

                out.println(answer);
                out.flush();

                in.next();
            } else {
                out.println("1");
                out.flush();
                out.println("01110010100111001010");
                out.flush();
                in.next();
            }
        }

        in.close();
        out.close();
    }
}
