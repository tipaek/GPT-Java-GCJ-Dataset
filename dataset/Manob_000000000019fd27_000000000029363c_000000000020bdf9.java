import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = myScanner.nextInt();

        for (int _t = 1; _t <= t; ++_t) {
            int N = myScanner.nextInt();
            int S[] = new int[N];
            int E[] = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = myScanner.nextInt();
                E[i] = myScanner.nextInt();
            }
            //System.out.println(Arrays.toString(S)+":"+Arrays.toString(E));
            int Jend = -1;
            int Cend = -1;

            StringBuilder outString = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (Jend < S[i]) {
                    Jend = E[i];
                    outString.append("J");
                } else if (Cend < S[i]) {
                    Cend = E[i];
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

}
