import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.valueOf(in.readLine());
        for(int i = 0;i < time;++i) {
            String firstMultipleInput = in.readLine();
            StringBuilder sb = new StringBuilder(firstMultipleInput);
            System.out.println("Case #"+(i+1)+": "+solve(sb,0,sb.length()-1,0).toString());
        }
    }
    private static StringBuilder solve(StringBuilder s,int f,int e,int step) {
        StringBuilder sb = new StringBuilder();
        for(int i = f;i <= e;++i) {
            int k = s.charAt(i)-'0';
            if(k==step) {
                sb.append(k);
                continue;
            }
            if(k>step) {
                int start = i;
                int end = i;
                for(int j = i+1;j <= e;++j) {
                    if(s.charAt(j)-'0'>step) end++;
                    else break;
                }
                sb.append('(');
                sb.append(solve(s,start,end,step+1));
                sb.append(')');
                i = end;
            }
        }
        return sb;
    }
}