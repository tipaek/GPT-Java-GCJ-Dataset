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
            StringBuilder temp = new StringBuilder();
            for(int i = 0;i < N; i++) {
                String a = in.readLine();
                int asteriskP = a.indexOf("*");
                int asteriskS = a.lastIndexOf("*");
                if (asteriskP > strP.length())
                    strP = a.substring(0, asteriskP);
                if(a.length() - asteriskS > strS.length() + 1)
                    strS = a.substring(asteriskS + 1);
                arrP[i] = a.substring(0, asteriskP);
                arrS[i] = a.substring(asteriskS + 1);
                if(asteriskP+1<asteriskS)
                    temp.append(a.substring(asteriskP+1, asteriskS));
            }
            boolean ws = true;
            for(String A: arrS)
                if(!strS.endsWith(A))
                    ws=false;
            for(String A: arrP)
                if(!strP.startsWith(A))
                    ws=false;
            if(strP.length()+strP.length()+temp.length()>10000)
                throw new Exception("AAAAA");
            sb.append(ws?strP+new String(temp)+strS:"*");
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
