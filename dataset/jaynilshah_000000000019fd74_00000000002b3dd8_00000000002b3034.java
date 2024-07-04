


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
            Arrays.sort(x, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    if(s.length()!=t1.length()){
                        return Integer.compare(s.length(),t1.length());
                    }
                    else {
                        return s.compareTo(t1);
                    }
                }
            });
            boolean set = true;
            for(int i=1;i<n;i++){
                for(int j=0;j<x[i-1].length()-1;j++){
                    if(x[i].charAt(x[i].length()-j-1)!=x[i-1].charAt(x[i-1].length()-1-j)){
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
                ans.append(x[n-1].substring(1));
            }
            System.out.println("Case #" + tt + ": " + ans.toString());
        }
    }
}

