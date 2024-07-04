import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
      static HashMap<String,String> points =new HashMap<>();
      static int size=0;
      static int full=100;
      static String temp;
      static int[][][] dp=new int[2*full+1][2*full+1][2*full];
    public static void main(String[] args){
        solve(0,0,1,"");
         points.put("0 0","");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        String ans;
        for(int j=0; j<t; j++){
            int x=in.nextInt();
           int y=in.nextInt();
           ans=points.get(x+" "+y);
           if(ans==null)
           ans="IMPOSSIBLE";
           
            System.out.println("Case #"+(j+1)+":"+ans);

           
            
        }
        
       // System.out.println(size);
        
    }
    
    public static void solve(int x,int y,int jump,String sol) {
      if(y+jump<=full&&dp[full+x][full+y+jump][jump]==0){
          temp=points.get(x+" "+(y+jump));
          if(temp!=null&&temp.length()<=(1+sol.length())){}
          else
          points.put(x+" "+(y+jump),sol+"N");
          
          
          dp[full+x][full+y+jump][jump]=1;
          size++;
          solve(x,(y+jump),jump*2,sol+"N");
      }
      if(y-jump>=-full&&dp[full+x][full+y-jump][jump]==0){
          temp=points.get(x+" "+(y-jump));
          if(temp!=null&&temp.length()<=(sol.length()+1)){}
          else
          points.put(x+" "+(y-jump),sol+"S");
          dp[full+x][full+y-jump][jump]=1;size++;
          solve(x,(y-jump),jump*2,sol+"S");
      }
      if(x+jump<=full&&dp[full+x+jump][full+y][jump]==0){
          temp=points.get((x+jump)+" "+y);
          if(temp!=null&&temp.length()<=(sol.length()+1)){}
          else
          points.put((x+jump)+" "+y,sol+"E");
          dp[full+x+jump][full+y][jump]=1;size++;
          solve((x+jump),y,jump*2,sol+"E");
      }
      if(x-jump>=-full&&dp[full+x-jump][full+y][jump]==0){
          temp=points.get((x-jump)+" "+y);
          if(temp!=null&&temp.length()<=(1+sol.length())){}
          else
          points.put((x-jump)+" "+y,sol+"W");
          dp[full+x-jump][full+y][jump]=1;size++;
          solve((x-jump),y,jump*2,sol+"W");
      }
       
    }
    
    
}






