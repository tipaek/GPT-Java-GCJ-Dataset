 import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
           public static int getInteger(String s){return Integer.parseInt(s);}
           public static String[] getString(BufferedReader br)throws Exception{return br.readLine().split(" ");}

    public static void main(String[] args) throws Exception{

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 int t =  getInteger(br.readLine());
                     int temp=1;
//reading input
                 while(t-->0){
                     String[] arr=  getString(br);
                           String ans = "IMPOSSIBLE";
                     int x  = getInteger(arr[0]);
                     int y =getInteger(arr[1]);
                      int s = Math.abs(x)+Math.abs(y);
                     String mov = arr[2];
                     char[] moves = mov.toCharArray();

                     for(int j=1;j<=moves.length;j++){
                       
                       char ch =  moves[j-1];

                       if(ch=='S'){
                        y=y-1;
                       }
                       else if(ch=='N'){
                        y+=1;
                       }
                       else if(ch=='E'){
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
                     System.out.println("Case #"+temp+": "+ans);
                     temp+=1;

                     
                 }
}
}