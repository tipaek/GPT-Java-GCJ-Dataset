import java.io.*;
import java.util.*;

class Solution {

    public static void main(String... args){

      Scanner in = new Scanner(System.in);
      int T = in.nextInt();
      for(int t=1;t<=T;t++){



        int x= in.nextInt();
        int y= in.nextInt();

        
        String s = in.next();
        int m = s.length();

        if(x==0 && y==0){
          System.out.println("Case #"+t+": " + "0");
          continue;
        }
        int ans=-1;
        boolean notpos=false;
        for(int i=0;i<m;i++){


          if(s.charAt(i)=='N'){
            y++;
          }else if(s.charAt(i)=='S'){
            y--;
          }else if(s.charAt(i)=='E'){
            x++;
          }else if(s.charAt(i)=='W'){
            x--;
          }
/*
          if(x<0 || y<0){
            notpos=true;
            break;
          }*/
         // System.out.println("x:"+x+" y:"+y);
          if((Math.abs(x)+Math.abs(y))<=(i+1)){
            ans = i+1;
            break;
          }

        }

        if(notpos || ans==-1){
          System.out.println("Case #"+t+": " +  "IMPOSSIBLE");
        }else{

           System.out.println("Case #"+t+": " + ans);

        }




      }


    }

}