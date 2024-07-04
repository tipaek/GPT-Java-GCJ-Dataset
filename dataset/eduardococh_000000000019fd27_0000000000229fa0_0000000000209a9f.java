import java.util.*;
import java.io.*;

public class Solution{
   public static void main(String arg[]){
       
        Scanner read = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nCases=read.nextInt();
        
        for(int j=0;j<nCases;j++){
            String input=read.next();
            StringBuilder result=new StringBuilder("");
            int numP=0;
            final int len=input.length();
            for(int i=0;i<len;i++){
               char current=input.charAt(i);
               int num=current-'0';
               while(numP>num){
                  result.append(')');
                  numP--;
               }
               while(numP<num){
                  result.append('(');
                  numP++;
               }
               while(i<len && input.charAt(i)==current){
                  result.append(current);
                  i++;
               }
               i--;
            }
            while(numP>0){
               result.append(')');
               numP--;
            }
            System.out.println("Case #"+(j+1)+": "+result.toString());
        }
   }
}