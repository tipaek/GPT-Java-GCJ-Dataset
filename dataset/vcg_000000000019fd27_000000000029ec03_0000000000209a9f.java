import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        char[] S;
        int N;
        StringBuffer O = new StringBuffer();
        for (int t = 1; t <= T; ++t) {
            S = in.next().toCharArray();
            int B = 0;
            for(int i = 0;i<S.length;i++) {
                N = S[i]-'0';
                B = B - N;
                if(B<0) {
                    for (int b = 0; b < -B; b++) {
                        O.append("(");
                    }
                }
                else if(B>0) {
                    for (int b = 0; b < B; b++) {
                        O.append(")");
                    }
                }
                O.append(S[i]);
                B=N;
            }
            for (int b = 0; b < B; b++) {
                O.append(")");
            }
            System.out.println("Case #" + t + ": " + O.toString());
            O.delete(0,O.length());
        }
    }
}
