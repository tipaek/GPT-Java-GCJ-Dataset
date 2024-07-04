import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int i=1;i<=T;i++){
            int Px = in.nextInt();
            int Py = in.nextInt();
            String str = in.nextLine().trim();
            System.out.println("Case #"+i+": "+getMinute(Px,Py,str));
        }
    }
    
    private static String getMinute(int Px,int Py,String str){
        int Ox = 0,Oy = 0;
        int M = str.length();
        
        for(int t=1;t<=M;t++){
            switch(str.charAt(t-1)){
                case 'N' : Py += 1;break;
                case 'S' : Py -= 1;break;
                case 'E' : Px += 1;break;
                case 'W' : Px -= 1;break;
            }
            
            if(Math.abs(Px - Ox) + Math.abs(Py - Oy) <= t)
                return String.valueOf(t);
        }
            
        return "IMPOSSIBLE";
    }
}