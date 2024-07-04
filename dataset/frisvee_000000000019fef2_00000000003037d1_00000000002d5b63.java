import java.io.*;
import java.util.*;

public class Solution {

    private static final Integer M = 300;
    private static final Integer L = 1_000_000_000;

    private static void loopy() {
        for (int i = 0; i < M; i++) {
            System.out.println("0 0");
            System.out.flush();
        }
    }

    private static void solve(Scanner in, int A, int B) {
        String result;
        int R = (A + B) / 2;
        int S = L - R;

        if (S > 5) {
            loopy();
            return;
        }

        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j < 5; j++) {
                System.out.println("" + i + " " + j);
                System.out.flush();

                result = in.nextLine();
                if (result.equals("CENTER")) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        in.nextLine();

        for (int t = 1; t <= T; t++) {
            solve(in, A, B);
        }

        System.out.flush();
        System.out.close();
        in.close();
    }
}