import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int Xp = sc.nextInt();
            int Yp = sc.nextInt();
            String M = sc.next();
            int Xm = 0, Ym = 0;
            int ans = -1;
            for(int i=0;i<M.length();i++){
                if(M.charAt(i)=='E')
                    Xp++;
                if(M.charAt(i)=='W')
                    Xp--;
                if(M.charAt(i)=='S')
                    Yp--;
                if(M.charAt(i)=='N')
                    Yp++;
                    
                //Compare
                if(i+1 >= (abs(Xp)+abs(Yp))){
                    ans = i+1;
                    break;
                }
            }
            if(ans == -1)
                System.out.println("Case #"+t+": IMPOSSIBLE");
            else
                System.out.println("Case #"+t+": "+ans);
        }
    }
    
    public static int abs(int x){
        if(x<0)
            return x*(-1);
        return x;
    }
}