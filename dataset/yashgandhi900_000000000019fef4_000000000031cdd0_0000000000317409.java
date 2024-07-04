  import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
           public static int getInteger(String s){return Integer.parseInt(s);}
           public static String[] getString(BufferedReader buffer)throws Exception{return buffer.readLine().split(" ");}

    public static void main(String[] args) throws Exception{

BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                 int t =  getInteger(buffer.readLine());
                     int itl=1;

                 while(t-->0){
                     String[] array=  getString(buffer);
                           String ans = "IMPOSSIBLE";
                     int x  = getInteger(array[0]);
                     int y =getInteger(array[1]);
                      int s = Math.abs(x)+Math.abs(y);
                     String bapu = array[2];
                     char[] ch = bapu.toCharArray();

                     for(int j=1;j<=ch.length;j++){
                       
                       char ll =  ch[j-1];

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
                       //helper
                       int res = Math.abs(x)+Math.abs(y);
                       if(res<=j){
                        ans=String.valueOf(j);
                        break;
                       }
                     }
                     System.out.println("Case #"+ilt+": "+ans);
                     ilt+=1;

                     //hello strings
                 }
}
}