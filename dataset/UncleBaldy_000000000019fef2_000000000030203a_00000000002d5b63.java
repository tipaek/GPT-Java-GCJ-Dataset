import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String[] line = in.readLine().split(" ");
        int T = Integer.parseInt(line[0]);
        int A = Integer.parseInt(line[1]);
        int B = Integer.parseInt(line[2]);
        for (int x = 1; x <= T; x++) {
            solve(A, B);
        }
    }

    static void solve(int A, int B) throws Exception {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                String line = in.readLine();
                if (line.equals("CENTER")) {
                    return;
                }
            }
        }
        throw new Exception("DRAT!");
    }
}
