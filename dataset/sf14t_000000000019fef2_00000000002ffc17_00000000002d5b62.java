import java.util.*;
import java.io.*;
public class Solution {
    static StringBuilder ans;
    static int min,x,y;
    static long two_pow[];
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int test=input.nextInt();
        for(int t=1;t<=test;t++) {
            ans=new StringBuilder("");
            min=Integer.MAX_VALUE;
            x=input.nextInt();
            y=input.nextInt();
            two_pow=new long[40];
            long pow=1;
            for(int i=0;i<40;i++) {
                two_pow[i]=pow;
                pow*=2;
            }
            solve();
            if(ans.length()==0) {
                ans=new StringBuilder("IMPOSSIBLE");
            }
            System.out.println("Case #"+t+": "+ans);
        }
        
    }
    static void solve() {
        boolean x_pos[],x_neg[],y_pos[],y_neg[];
        x_pos=pos(x);
        y_pos=pos(y);
        x_neg=neg(x);
        y_neg=neg(y);
        if(check(x_pos,y_pos)) {
            create_str(x_pos,y_pos,true,true);
        }
        if(check(x_pos,y_neg)) {
            create_str(x_pos,y_neg,true,false);
        }
        if(check(x_neg,y_pos)) {
            create_str(x_neg,y_pos,false,true);
        }
        if(check(x_neg,y_neg)) {
            create_str(x_neg,y_neg,false,false);
        }
    }
    static boolean[] pos(long n) {
        n=Math.abs(n);
        boolean pos[]=new boolean[40];
        for(int i=39;i>=0;i--) {
            if(two_pow[i]<=n) {
                n-=two_pow[i];
                pos[i]=true;
            }
        }
        return pos;
    }
    
    static boolean[] neg(long n) {
        n=Math.abs(n);
        boolean pos[]=new boolean[40];
        int indx=-1;
        for(int i=0;i<39;i++) {
            if(two_pow[i]>n) {
                indx=i;
                pos[i]=true;
                n=two_pow[i]-n;
                break;
            }
        }
        for(int i=39;i>=0;i--) {
            if(two_pow[i]<=n) {
                n-=two_pow[i];
                pos[i]=true;
            }
        }
        return pos;
    }
    static boolean check(boolean[] b1,boolean b2[]) {
        int indx=-1;
        for(int i=39;i>=0;i--) {
            if(b1[i] || b2[i]) {
                indx=i;
                break;
            }
        }
        for(int i=0;i<=indx;i++) {
            if(b1[i] && b2[i]) {
                return false;
            }
            else if(!b1[i] && !b2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void create_str(boolean b1[],boolean b2[],boolean x_pos,boolean y_pos) {
        StringBuilder str=new StringBuilder("");
        if(x_pos && y_pos) {
            for(int i=0;i<39;i++) {
                if(b1[i]) {
                    if(x>0) {
                        str.append('E');
                    }
                    else {
                        str.append('W');
                    }
                }
                else if(b2[i]){
                    if(y>0) {
                        str.append('N');
                    }
                    else {
                        str.append('S');
                    }
                }
            }
        }
        
        if(!x_pos && !y_pos) {
            for(int i=0;i<39;i++) {
                if(b1[i] && !b1[i+1] && !b2[i+1]) {
                    if(x>0) {
                        str.append('W');
                    }
                    else {
                        str.append('E');
                    }
                }
                else if(b1[i]) {
                    if(x>0) {
                        str.append('E');
                    }
                    else {
                        str.append('W');
                    }
                }
                
                
                if(b2[i] && !b1[i+1] && !b2[i+1]) {
                    if(y>0) {
                        str.append('S');
                    }
                    else {
                        str.append('N');
                    }
                }
                else if(b2[i]) {
                    if(y>0) {
                        str.append('N');
                    }
                    else {
                        str.append('S');
                    }
                }
            }
        }
            if(!x_pos && y_pos) {
                for(int i=0;i<39;i++) {
                    if(b1[i] && !b1[i+1] && !b2[i+1]) {
                        if(x>0) {
                            str.append('W');
                        }
                        else {
                            str.append('E');
                        }
                    }
                    else if(b1[i]) {
                        if(x>0) {
                            str.append('E');
                        }
                        else {
                            str.append('W');
                        }
                    }
                
                
                    else if(b2[i]){
                        if(y>0) {
                            str.append('N');
                        }
                        else {
                            str.append('S');
                        }
                    }
                }
            }
            
            
            if(x_pos && !y_pos) {
                for(int i=0;i<39;i++) {
                    if(b1[i]) {
                        if(x>0) {
                            str.append('E');
                        }
                        else {
                            str.append('W');
                        }
                    }


                    if(b2[i] && !b1[i+1] && !b2[i+1]) {
                        if(y>0) {
                            str.append('S');
                        }
                        else {
                            str.append('N');
                        }
                    }
                    else if(b2[i]) {
                        if(y>0) {
                            str.append('N');
                        }
                        else {
                            str.append('S');
                        }
                    }
                }
            }
            str.reverse();
            ans=new StringBuilder(str);
        }
}

