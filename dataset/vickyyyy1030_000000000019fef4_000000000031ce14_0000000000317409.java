import java.util.*;
public class Solution {
    public static void main(String[] args){
        int T;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Scanner in = new Scanner(System.in);
        T=in.nextInt();
        int num=0;
        while (T>0){
            num++;
            T--;
            int x,y;
            String m;
            x=in.nextInt();
            y=in.nextInt();
            m=in.next();
            int ans=-1;
            for(int i=0;i<m.length();i++){
                if(Math.abs(x)+Math.abs(y)<=i){
                    ans=i;
                    break;
                }
                if(m.charAt(i)=='N'){
                    y=y+1;
                }else if(m.charAt(i)=='S'){
                    y=y-1;
                }else if(m.charAt(i)=='W'){
                    x=x-1;
                }else {
                    x=x+1;
                }
            }
            if(ans==-1&&(Math.abs(x)+Math.abs(y)<=m.length()))
                ans=m.length();
            if(ans>-1)
                System.out.println("Case #"+num+": "+ans);
            else
                System.out.println("Case #"+num+": IMPOSSIBLE");
        }
    }
}