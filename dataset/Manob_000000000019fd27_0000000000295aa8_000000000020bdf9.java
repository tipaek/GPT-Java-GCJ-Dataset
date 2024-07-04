import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = myScanner.nextInt();

        for (int _t = 1; _t <= t; ++_t) {
            int N = myScanner.nextInt();
            int S[] = new int[N + 1];
            int E[] = new int[N + 1];
            S[0] = 0;
            E[0] = 0;
            for (int i = 1; i <= N; i++) {
                S[i] = myScanner.nextInt();
                E[i] = myScanner.nextInt();
            }
            //System.out.println(Arrays.toString(S)+":"+Arrays.toString(E));
            int Jend = 0;
            int Cend = 0;

            StringBuilder outString = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if (!isOverLap(S[Jend], E[Jend], S[i], E[i])) {
                    Jend = i;
                    outString.append("J");
                } else if (!isOverLap(S[Cend], E[Cend], S[i], E[i])) {
                    Cend = i;
                    outString.append("C");
                } else {
                    outString = null;
                    outString = new StringBuilder();
                    outString.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + _t + ": " + outString.toString());

        }

    }

    static boolean isOverLap(int s1, int e1, int s2, int e2) {
        if ((s1 < s2 && s2 < e1) || (s2 < s1 && s1 < e2)) {
            return true;
        }
        return false;
    }

}
