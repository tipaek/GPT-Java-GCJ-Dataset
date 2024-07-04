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
            sb.append("Case #").append(t).append(": ");
            int N = parseInt(in.readLine());
            String str = "";
            String[] arr = new String[N];
            for(int i = 0;i < N; i++) {
                String a = in.readLine();
                if (a.length() > str.length() + 1)
                    str = a.substring(1);
                arr[i] = a.substring(1);
            }
            boolean ws = true;
            for(String A: arr)
                if(!str.endsWith(A))
                    ws=false;
            sb.append(ws?str:"*");
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
