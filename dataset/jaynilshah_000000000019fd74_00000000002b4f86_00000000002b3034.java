


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
            int n = in.nextInt();
            String[] x = new String[n];
            for(int i=0;i<n;i++){
                x[i] = in.next();
            }
            Character pre[]= new Character[100];
            Character post[]= new Character[100];
            Arrays.fill(pre,'a');
            Arrays.fill(post,'a');
            boolean set = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<x[i].length();j++){
                    if(x[i].charAt(j)=='*'){
                        break;
                    }
                    if(pre[j]=='a'){
                        pre[j] = x[i].charAt(j);
                        continue;
                    }
                    if(pre[j]!='a' && pre[j]!=x[i].charAt(j)){
                        set = false;
                        break;
                    }
                }
                if(!set){
                    break;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<x[i].length();j++){
                    if(x[i].charAt(x[i].length()-j-1)=='*'){
                        break;
                    }
                    if(post[j]=='a'){
                        post[j] = x[i].charAt(x[i].length()-j-1);
                        continue;
                    }
                    if(post[j]!='a' && post[j]!=x[i].charAt(x[i].length()-j-1)){
                        set = false;
                        break;
                    }
                }
                if(!set){
                    break;
                }
            }
            StringBuilder ans = new StringBuilder("");
            if(!set){
                ans.append("*");
            }
            else {
                StringBuilder pr = new StringBuilder();
                StringBuilder po = new StringBuilder();
                for(int i=0;i<100;i++){
                    if(pre[i]=='a'){
                        break;
                    }
                    pr.append(pre[i]);
                }
                for(int i=0;i<100;i++){
                    if(post[i]=='a'){
                        break;
                    }
                    po.append(post[i]);
                }
                ans.append(pr.toString());
                ans.append(po.reverse().toString());
            }
            System.out.println("Case #" + tt + ": " + ans.toString());
        }
    }
}

