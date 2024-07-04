
import java.util.Scanner;
 
 
public class Solution {
 
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String res = "IMPOSSIBLE";
        for(int i = 1;i<=t;i++){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String S = sc.next();
            int x = 0;
            int y = 0;
            int resulta = -1;
            for(int j = 0;j<S.length();j++){
                if(X ==x && Y == y){
                    resulta = j;
                    break;
                }
                if(S.charAt(j) == 'N'){
                    Y = Y + 1;
                }else if(S.charAt(j) == 'S'){
                    Y = Y - 1;
                }else if(S.charAt(j)=='E'){
                    X = X+1;
                }else{
                    X = X-1;
                }
                if(X ==x && Y == y){
                    resulta = j+1;
                    break;
                }
                
                if(X>x){
                    x = x + 1;
                }else if(x>X){
                    x = x-1;
                }else if (y<Y){
                    y = y +1;
                }else{
                    y = y -1;
                }
                if(X ==x && Y == y){
                    resulta = j+1;
                    break;
                }
                
                
            }
            if (resulta == -1){
                System.out.println("Case #" + i + ": " + res);
            }else{
                System.out.println("Case #" + i + ": " + resulta);
        
            }
            
            }
       
    }
}