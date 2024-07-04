import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.valueOf(in.readLine());
        for(int i = 0;i < time;++i) {
            int n = Integer.valueOf(in.readLine());
            String[] matches = new String[n];
            for(int j = 0;j < n;++j) {
                matches[j] = in.readLine();
            }
            
            System.out.println("Case #"+(i+1)+": "+solve(n,matches));
        }
    }
    private static String solve(int n,String[] matches) {
        List<String> mid = new ArrayList<>();
        String start = "";
        for(int i = 0;i < n;++i) {
            String ts = "";
            int j = 0;
            for(j = 0;j < matches[i].length();++j) {
                if(matches[i].charAt(j)=='*') break;
            }
            ts = matches[i].substring(0,j);
            if(i==0) start = ts;
            else {
                for(int k = 0;k < start.length()&&k < ts.length();++k) {
                    if(start.charAt(k)!=ts.charAt(k)) return "*";
                }
                if(ts.length()>start.length()) start = ts;
            }
        }
        String end = "";
        for(int i = 0;i < n;++i) {
            String ts = "";
            int e = 0;
            for(int j = 0;j < matches[i].length();++j) {
                if(matches[i].charAt(j)=='*') e = j;
            }
            ts = matches[i].substring(e+1,matches[i].length());
            if(i==0) end = ts;
            else {
                for(int k = 0;k < end.length()&&k < ts.length();++k) {
                    if(end.charAt(end.length() -1 - k)!=ts.charAt(ts.length() - 1 - k)) return "*";
                }
                if(ts.length()>end.length()) end = ts;
            }
        }
        for(int i = 0;i < n;++i) {
            String[] ls = matches[i].split("\\*");
            for(int j = 1;j < ls.length-1;++j) mid.add(ls[i]);
        }
        String res = start;
        for(int i = 0;i < mid.size();++i) {
            res+=mid.get(i);
        }
        return res+end;
    }
}