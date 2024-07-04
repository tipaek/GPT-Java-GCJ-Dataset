
import java.util.*;

public class Solution {
        public static int rec(int pX, int pY, String s) {
            char[]str =s.toCharArray();
            int a = 0;int b= 0,limit = 0;
            if(Math.abs(pX-a)+Math.abs(pY-b)<=0){
                return 0;
            }
            limit++;
            for(int i=0;i<str.length;i++){
                     char ch = str[i];
                    if(ch=='N') pY++;
                    else if(ch=='S')pY--;
                    else if(ch=='W') pX--;
                    else pX++;
                    if (Math.abs(pX-a)+Math.abs(pY-b)<=limit)
                    return limit;
                limit+=1;
            }

            
            return -1;
            
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t= sc.nextInt();
            int x = 1;
            while(t-- >0){
                // int m = sc.nextInt();
                int X = sc.nextInt();
                int Y = sc.nextInt();
                String s = sc.next();
                int pX = X, pY =Y;
                // int mini = Integer.MAX_VALUE;
                // for(int i=0;i<s.length();i++){
                //     char ch = s.charAt(i);
                //     if(ch=='N') pX++;
                //     else if(ch=='S')pX--;
                //     else if(ch=='W') pY--;
                //     else pY++;
                //     mini = Math.min(mini, rec(pX,pY))

                // }
                int mini = rec(pX,pY,s);
                // int[][] arr = new int[n][n];
               
                if(mini!=-1)
                System.out.println("Case #"+x+": "+mini);
                else System.out.println("Case #"+x+": IMPOSSIBLE");
                x++;
            }
        }
    
}