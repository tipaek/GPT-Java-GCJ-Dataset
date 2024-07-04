import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=1;i<=T;i++){
            int X = in.nextInt();
            int Y = in.nextInt();
            
            if((Math.abs(X) + Math.abs(Y)) % 2 == 0){
                System.out.println("Case #"+i+": IMPOSSIBLE");
                continue;
            }
            
            System.out.println("Case #"+i+": "+getDirections(X,Y));
        }
    }
    
    public static String getDirections(int X,int Y){
        StringBuilder ans = new StringBuilder();
        
        int D = Math.abs(X) + Math.abs(Y);
        int S = 1;
        int N = 1;
        
        while(S < D){
            N = N*2;
            S += N;
        }
        
        return helper(X,Y,N);
    }
    
    public static String helper(int X,int Y,int N){
        if(N == 0)return "";
        
        int X_ = X;
        int Y_ = Y;
        
        String dir = "";
        
        if(Math.abs(X) > Math.abs(Y)){
            if(X >= 0){
                X_ = X - N;
                dir = "E";
            }
            else{
                X_ = X + N;
                dir = "W";
            }
        }else{
            if(Y >= 0){
                Y_ = Y - N;
                dir = "N";
            }
            else{
                Y_ = Y + N;
                dir = "S";
            }
        }
        
        return helper(X_,Y_,N/2) + dir;
    }
}