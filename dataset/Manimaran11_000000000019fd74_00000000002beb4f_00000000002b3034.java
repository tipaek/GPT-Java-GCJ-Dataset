
import java.io.*;
import java.util.*;


public class Solution {


    public static void main(String[] args) throws Exception {

            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int y=1;
        while(t>0){
            System.out.print("Case #"+y+": ");
            int n = Integer.parseInt(br.readLine());
            String[] s = new String[n];
            for(int i=0;i<n;i++){
                s[i] = br.readLine().replace("*", "");
            }
            boolean b= true;
            int len = 0;int mi=0;
            for(int i=0;i<n;i++){
               if(s[i].length()>len){
                   len=s[i].length();
                   mi=i;
               }
            }
            for(int i=0;i<n;i++){
                if(!s[mi].contains(s[i])){
                    b=false;
                    break;
                }
            }
            if(b){
                System.out.print(s[mi]);
            }
            else{
                System.out.print("*");
            }
            System.out.println("");
            y++;
            t--;
        }
    
    }
}