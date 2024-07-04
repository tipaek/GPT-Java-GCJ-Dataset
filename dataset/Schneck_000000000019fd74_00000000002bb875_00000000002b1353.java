import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int N = scan.nextInt();
        System.out.println("1 1");
        if (N <= 30) {
            finish(N - 1, 1, 1);
            return;
        }
        int B = N - 30;
        int direction = -1;
        int r = 1;
        int k = 1;
        int sum = 1;
        int power = 2;
        while (power <= B) {
            if (direction == -1) {
                r++;
            } else {
                r++;
                k++;
            }
            if ((B & power) == 0) {
                System.out.println(r + " " + k);
                sum += 1;
            } else {
                if (direction == -1) {
                    for (int i = 1; i <= r; i++) {
                        System.out.println(r + " " + i);
                    }
                    k = r;
                    sum += power;
                    direction = 1;
                } else {
                    for (int i = r; i >= 1; i--) {
                        System.out.println(r + " " + i);
                    }
                    k = 1;
                    sum += power;
                    direction = -1;
                }
            }
            power *= 2;
        }
        finish(N - sum, r, k);
    }

    private void finish(int num, int r, int k) {
        if (k == 1) {
            for (int i = 1; i <= num; i++) {
                r++;
                System.out.println(r + " " + k);
            }
        } else {
            for (int i = 1; i <= num; i++) {
                r++;
                k++;
                System.out.println(r + " " + k);
            }
        }

    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.println("Case #" + i + ":");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
