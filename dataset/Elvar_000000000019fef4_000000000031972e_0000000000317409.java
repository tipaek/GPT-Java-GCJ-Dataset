import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x<=T;x++){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();
            int n = M.length();
            int Yi = Y;
            int Xi = X;
            boolean haegt = false;
            int stadur = -1;
            for(int i = 1; i<=n; i++){
                char att = M.charAt(i-1);
                if(att=='N') Yi++;
                if(att=='S') Yi--;
                if(att=='E') Xi++;
                if(att=='W') Xi--;
                if(TaxiM(Xi,Yi,0,0)<=i && !haegt) {
                    haegt = true;
                    stadur = i;
                }
            }
            System.out.print("Case #"+x+": ");
            if(!haegt) System.out.println("IMPOSSIBLE");
            else System.out.println(stadur);
        }
        
    }
    public static int TaxiM(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}