import java.io.*;
import java.util.*;

 
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
    int t=Integer.parseInt(br.readLine());
    for(int j=1;j<=t;j++){
        String[] str=br.readLine().split(" ");
        int x=Integer.parseInt(str[0]);
        int y=Integer.parseInt(str[1]);
        
        String s=str[2];
        int[] arr=new int[s.length()];
       int ans=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            //System.out.println(s.charAt(i));
            if(s.charAt(i)=='N'){
                y++;
            }
            else if(s.charAt(i)=='S')
                y--;
            else if(s.charAt(i)=='E')
                x++;
            else if(s.charAt(i)=='W')
                x--;
           
            if(Math.abs(x)+Math.abs(y)<=i+1){
                ans=Math.min(ans,i+1);
            };
        }
         if(ans==Integer.MAX_VALUE){
             System.out.println("Case #"+j+": IMPOSSIBLE");
         }
         else{
             System.out.println("Case #"+j+": "+ans);
         }
    }
    }}