import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int z=1;
        while(z<=t){
           String str = br.readLine();
           String res="";
           
           int prev = 0,curr = Character.getNumericValue(str.charAt(0));
           for(int i = 0;i<str.length();i++){
               char ch = str.charAt(i);
               curr = Character.getNumericValue(ch);
                int diff = prev-curr;
                
                if(diff<0){
                    while(diff++<0) res+="(";
                    res+=ch;
                }
                else if(diff==0) res+=ch;
                
                else{
                    while(diff-->0) res+=")";
                    res+=ch;
                }
                prev = curr;

               
           }
           for(int i = 0;i<curr;i++) res+=")";
           
            System.out.println("Case #"+z+": "+res);
            z++;
        }
    }
}