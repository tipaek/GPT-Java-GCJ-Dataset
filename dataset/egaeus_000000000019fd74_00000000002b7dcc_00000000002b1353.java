/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(":\n");
            int N = parseInt(in.readLine());
            sb.append("1 1\n");
            int s = 1, p = 1;
            while(s + p <= N) {
                s += p;
                sb.append((p+1)+" "+2+"\n");
                p++;
            }
            while(s < N) {
                s++;
                sb.append((p)+" "+1+" "+"\n");
                p++;
            }
        }
        System.out.print(new String(sb));
    }
}
