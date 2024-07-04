import java.util.*;
import java.io.*;
 
 
public class Solution {
        
    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            for(int q = 1;q<=tc;q++){
                System.out.print("Case #"+q+": ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                String dir = sc.next();
                int M = dir.length();
                int ans = -1;
                for(int i = 0;i<M;i++){
                    if((Math.abs(x)+Math.abs(y))<=i){
                        ans = i ;
                        break;
                    }
                    if(dir.charAt(i)=='S')y--;
                    else if(dir.charAt(i)=='N')y++;
                    else if(dir.charAt(i)=='E')x++;
                    else x--;
                }
                if(ans==-1 && Math.abs(x)+Math.abs(y)<=M){
                    ans = M;
                }
                if(ans==-1){
                    System.out.println("IMPOSSIBLE");
                }else{
                    System.out.println(ans);
                }
            }
            
              
    }
}