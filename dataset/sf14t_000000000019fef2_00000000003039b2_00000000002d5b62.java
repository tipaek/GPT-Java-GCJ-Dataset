import java.util.*;
import java.io.*;
public class Solution {
    static StringBuilder ans;
    static int min,x,y;
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            ans=new StringBuilder("");
            min=Integer.MAX_VALUE;
            x=input.nextInt();
            y=input.nextInt();
            solve(0,0,0,new StringBuilder(""));
            if(ans.length()==0) {
                ans=new StringBuilder("IMPOSSIBLE");
            }
            System.out.println("Case #"+t+": "+ans);
        }
        
    }
    public static void solve(int n,int x_pos,int y_pos,StringBuilder str) {
//        System.out.println(x_pos+" "+y_pos);
        if(x==x_pos && y==y_pos) {
            if(n<min) {
                min=n;
                ans=new StringBuilder(str);
            }
            return;
        }
        if(16*Math.abs(x)<Math.abs(x_pos) || 16*Math.abs(y)<Math.abs(y_pos)) {
            return;
        }
        int move=(int)Math.pow(2,n);
        StringBuilder tmp=new StringBuilder(str);
        tmp.append('E');
        solve(n+1,x_pos+move,y_pos,tmp);
        
        tmp=new StringBuilder(str);
        tmp.append('W');
        solve(n+1,x_pos-move,y_pos,tmp);
        
        tmp=new StringBuilder(str);
        tmp.append('N');
        solve(n+1,x_pos,y_pos+move,tmp);
        
        tmp=new StringBuilder(str);
        tmp.append('S');
        solve(n+1,x_pos,y_pos-move,tmp);
    }
}
