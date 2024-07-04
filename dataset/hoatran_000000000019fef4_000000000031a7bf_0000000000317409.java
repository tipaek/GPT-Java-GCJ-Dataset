import java.io.*;

public class Solution {
    static boolean debug = false;
    public static void main(String args[]) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        if (debug) {
            File file = new File("test.in");
            reader = new FileReader(file);
        }
        BufferedReader in = new BufferedReader(reader);
        int            t  = Integer.parseInt(in.readLine());
        for (int tt = 1; tt <= t; tt++) {
            String[] tmp = in.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            String m = tmp[2];
            findSolution(tt, x, y, m);
        }
    }
    public static void findSolution(int index, int x0, int y0, String m) {
        int result = 0;
        int x = x0;
        int y = y0;
        for (int i = 1; i <= m.length(); i++) {
            switch (m.charAt(i-1)) {
                case 'S':
                    y = y - 1;
                    break;
                case 'N':
                    y = y + 1;
                    break;
                case 'W':
                    x = x - 1;
                    break;
                case 'E':
                    x = x + 1;
                    break;
                default:
                    break;
            }
            if (Math.abs(x) + Math.abs(y) <= i) {
                result = i;
                break;
            }
        }
        if (result == 0) {
            System.out.println("Case #" + index + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + index + ": " + result);
        }
    }
}