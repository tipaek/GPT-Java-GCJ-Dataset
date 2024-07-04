


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            StringBuilder ans = new StringBuilder();
            String x = in.next();
            int c =0;
            for(int i=0;i<x.length();i++){
                int p =x.charAt(i)-'0';
                if(p<c){

                    for(int j=p;j<c;j++){
                        ans.append(")");
                    }
                    c=p;
                    ans.append(x.charAt(i));
                    continue;
                }
                else if(p>c) {
                    for(int j=c;j<p;j++){
                        ans.append("(");
                    }
                    c = p;
                    ans.append(x.charAt(i));
                    continue;
                }
                else {
                    ans.append(x.charAt(i));
                }
            }
            while (c-->0){
                ans.append(")");
            }
            System.out.println("Case #" + tt + ": " +ans.toString());
        }
    }
}

