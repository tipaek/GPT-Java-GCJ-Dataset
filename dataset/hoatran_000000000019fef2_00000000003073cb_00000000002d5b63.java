import java.io.*;

public class Solution {
    public static void solve(BufferedReader input, int b) throws IOException {
        int x = 500000000;
        int y = 500000000;
        boolean flag = true;
        for (x = 500000000 -5; x <=500000005; x++) {
            for (y = 500000000 -5; y <=500000005; y++) {
                String s = x + " " + y;
                System.out.println(s);
                System.out.flush();
                s = input.readLine();
                if (s.equals("CENTER")) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.exit(0);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] params = input.readLine().split(" ");
        int T = Integer.parseInt(params[0]);
        for (int ks = 1; ks <= T; ks++) {
            int b = Integer.parseInt(params[1]);
            solve(input, b);
        }
    }
}