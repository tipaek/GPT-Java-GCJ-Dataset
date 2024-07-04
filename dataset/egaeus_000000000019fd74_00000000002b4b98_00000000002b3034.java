/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String args[]) throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t++<T;) {
            sb.append("Case #").append(t).append(": ");
            int N = parseInt(in.readLine());
            String strS = "";
            String strP = "";
            String[] arrS = new String[N];
            String[] arrP = new String[N];
            for(int i = 0;i < N; i++) {
                String a = in.readLine();
                int asterisk = a.indexOf("*");
                if (asterisk > strP.length())
                    strP = a.substring(0, asterisk);
                if(a.length() - asterisk > strS.length() + 1)
                    strS = a.substring(asterisk + 1);
                arrP[i] = a.substring(0, asterisk);
                arrS[i] = a.substring(asterisk + 1);
            }
            boolean ws = true;
            for(String A: arrS)
                if(!strS.endsWith(A))
                    ws=false;
            for(String A: arrP)
                if(!strP.startsWith(A))
                    ws=false;
            sb.append(ws?strP+strS:"*");
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
