import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
           public static int getInteger(String s){return Integer.parseInt(s);}
           public static String[] getString(BufferedReader br)throws Exception{return br.readLine().split(" ");}

    public static void main(String[] args) throws Exception{

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 int t =  getInteger(br.readLine());
                     int cases=1;

                 while(t-->0){
                     String[] array=  getString(br);
                           String ans = "IMPOSSIBLE";
                     int x  = getInteger(array[0]);
                     int y =getInteger(array[1]);
                      int s = Math.abs(x)+Math.abs(y);
                     String mov = array[2];
                     char[] moves = mov.toCharArray();

                     for(int j=1;j<=moves.length;j++){
                       
                       char ll =  moves[j-1];

                       if(ll=='S'){
                        y=y-1;
                       }
                       else if(ll=='N'){
                        y+=1;
                       }
                       else if(ll=='E'){
                        x+=1;
                       }
                       else{
                        x-=1;
                       }

                       int res = Math.abs(x)+Math.abs(y);
                       if(res<=j){
                        ans=String.valueOf(j);
                        break;
                       }
                     }
                     System.out.println("Case #"+cases+": "+ans);
                     cases+=1;

                     
                 }
}
}