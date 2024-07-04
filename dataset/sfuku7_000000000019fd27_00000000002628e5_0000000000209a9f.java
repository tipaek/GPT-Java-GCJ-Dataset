import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            char[] S = sc.next().toCharArray();

            StringBuilder tmp = new StringBuilder();
            int p = 0;
            for (int i = 0; i < S.length; i++) {
                int d = S[i]-'0';
                int diff = d-p;
                p += diff;
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        tmp.append('(');
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        tmp.append(')');
                    }
                }
                tmp.append(S[i]);
            }
            while (p-- > 0) {
                tmp.append(')');
            }

            ans.append("Case #"+t+": "+tmp.toString()+"\n");
 
        }
        System.out.print(ans);
    }
}

