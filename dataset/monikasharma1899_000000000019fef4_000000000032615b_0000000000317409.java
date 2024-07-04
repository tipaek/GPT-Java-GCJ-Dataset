import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int X=sc.nextInt();
            int Y=sc.nextInt();
            String M=sc.next();
            
            int n=M.length();
            int c=0;
            
        boolean flag=false;
        int ans=0;
        
        int Z=Math.abs(X)+Math.abs(Y);
        for (int i = 0; i < n; i++) {
        if (M.charAt(i) == 'N') {
            Y = Y + 1;
            Z=Math.abs(X)+Math.abs(Y);
        } else if (M.charAt(i) == 'E') {
            X = X + 1;
            Z=Math.abs(X)+Math.abs(Y);
        } else if (M.charAt(i) == 'S') {
            Y = Y - 1;
            Z=Math.abs(X)+Math.abs(Y);
        } else if (M.charAt(i) == 'W') {
            X = X - 1;
            Z=Math.abs(X)+Math.abs(Y);
        }
        
        if (Z <= (i + 1)) {
            ans= (i + 1);
            flag=true;
            break;
        }
    }
            //int m=Math.abs(X)+Math.abs(Y);
            if(flag){
                System.out.println("Case #"+t+": "+ans);
            }
            /*else if(n>m){
                System.out.println("Case #"+t+": "+(c));
            }*/
            else{
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }
        }
    }
}