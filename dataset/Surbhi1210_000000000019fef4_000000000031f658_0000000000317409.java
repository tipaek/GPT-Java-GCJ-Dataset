import java.util.*;
import java.io.*;
public class Solution{
    static class pair{
        int a,b;
        pair(int x,int y){
            a=x;b=y;
        }
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int p=1;
        while(p<=t){
            int x=s.nextInt();
            int y=s.nextInt();
            HashMap<pair,Integer> h=new HashMap<>();
            // h.add(new pair(x,y));
            String st=s.next();
            int time=0;int x1=0,y1=0;
            
            for(int i=0;i<st.length();i++){
                time++;
                if(st.charAt(i)=='N'){
                   
                   y++;
                }else if(st.charAt(i)=='E'){
                    x++;
                }else if(st.charAt(i)=='S'){
                    y--;
                }else{
                    x--;
                }
                if(time>=(Math.abs(x)+Math.abs(y)))
                break;
            }
             if(time>=(Math.abs(x)+Math.abs(y)))
            System.out.println("Case #"+p+": "+time);
            else
            System.out.println("Case #"+p+": IMPOSSIBLE");
            p++;
        }
    }
}