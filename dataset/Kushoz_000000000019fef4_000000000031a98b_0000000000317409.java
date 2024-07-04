import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
           public static int getInt(String s){return Integer.parseInt(s);} 
           public static String[] get(BufferedReader br)throws Exception{return br.readLine().split(" ");}
	
	     public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 int tc =  getInt(br.readLine());
                     int i=1;

                 while(tc-->0){
                     String[] arr=  get(br);
                           String ans = "IMPOSSIBLE";
                     int x  = getInt(arr[0]);
                     int y =getInt(arr[1]);
                      int sum = Math.abs(x)+Math.abs(y);
                     String moves = arr[2];
                     char[] mov = moves.toCharArray();

                     for(int j=1;j<=mov.length;j++){
                       
                       char m =  mov[j-1];

                       if(m=='S'){
                       	y=y-1;
                       }
                       else if(m=='N'){
                       	y+=1;
                       }
                       else if(m=='E'){
                       	x+=1;
                       }
                       else{
                       	x-=1;
                       }

                       int required = Math.abs(x)+Math.abs(y);
                       if(required<=j){
                       	ans=String.valueOf(j);
                       	break;
                       }
                     }
                     System.out.println("Case #"+i+": "+ans);
                     i+=1;

                     
                 }
	}
}