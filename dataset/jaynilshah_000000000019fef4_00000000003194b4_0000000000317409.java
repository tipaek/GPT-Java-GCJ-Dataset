


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
            int x = in.nextInt();
            int y = in.nextInt();
            String xx = in.next();
            int ans = -1;
            if(Math.abs(x) + Math.abs(y)<=0){
                System.out.println("Case #" + tt + ": " +0);
                continue;
            }
            for(int i=0;i<xx.length();i++){
                if(xx.charAt(i)=='S'){
                    y--;
                }
                else if(xx.charAt(i)=='N'){
                    y++;
                }
                else if(xx.charAt(i)=='E'){
                    x++;
                }
                else {
                    x--;
                }
                if(Math.abs(x)+Math.abs(y)<=i+1){
                    ans=i+1;
                    break;
                }
            }
            if(ans==-1){
                System.out.println("Case #" + tt + ": " +"IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + tt + ": " +ans);
            }

        }
    }
}

