import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int X = in.nextInt();
          int Y = in.nextInt();
          String M=in.next();
          int dist=Math.abs(X)+Math.abs(Y);
          int j=0;
          if(dist!=0){
          while(j<M.length()){
            char m=M.charAt(j);
            if(m=='S')Y--;
            else if(m=='N')Y++;
            else if(m=='E')X++;
            else if(m=='W')X--;
            dist=Math.abs(X)+Math.abs(Y);
            if(j+1>=dist){
                System.out.println("Case #" + i + ": " +(j+1));
             break;
            }
              j++;
            }
        }
        else System.out.println("Case #" + i + ": 0"); 
        if(j==M.length()) System.out.println("Case #" + i + ": IMPOSSIBLE"); 
        }
      }
    }