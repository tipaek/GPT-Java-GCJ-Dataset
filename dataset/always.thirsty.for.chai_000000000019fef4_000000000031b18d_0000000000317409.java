import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t =  sc.nextInt();
        int tt = t;
        while(t-->0){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();
            char[] path = M.toCharArray();
           int len = M.length();
           int currX = X;
           int currY = Y;
            int time = 0;
            int mintime  = Integer.MAX_VALUE;
            boolean canreach = false;
           for(int i=0;i<len;i++){
               switch (path[i]){
                   case 'S':
                     currY = currY-1;
                     break;
                   case 'N':
                       currY = currY+1;
                       break;
                   case 'E':
                       currX = currX+1;
                       break;
                   case 'W':
                       currX = currX -1;
                       break;
                   default:
               }
               time++;
               int totalpath = Math.abs(currX)+Math.abs(currY);

               if(totalpath  <= time){
                   canreach = true;
                   mintime = Math.min(mintime,time);
               }

           }
           if(canreach){
               System.out.println("Case #"+(tt-t)+": "+mintime);
           }
           else{
               System.out.println("Case #"+(tt-t)+": IMPOSSIBLE");
           }
        }
    }
}
