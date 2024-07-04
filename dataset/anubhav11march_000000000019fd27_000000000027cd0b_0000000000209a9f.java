import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        for(int k=0; k<n; k++){
            String s = inp.next();
            int i=0, currentOpenParas=0;
            while(i<s.length()){
                if(s.charAt(i) == ')' || s.charAt(i) == '(') {
                    i++;
                    continue;
                }
               if(Integer.parseInt(s.charAt(i)+"") > currentOpenParas){
                   while(Integer.parseInt(s.charAt(i)+"") > currentOpenParas){
                       s=s.substring(0, i)+'('+s.substring(i);
                       currentOpenParas++;
                       i++;
                   }

               }
               else if (Integer.parseInt(s.charAt(i)+"") < currentOpenParas) {
                   while(Integer.parseInt(s.charAt(i)+"") < currentOpenParas) {
                       s = s.substring(0, i) + ')' + s.substring(i);
                       currentOpenParas--;
                       i++;
                   }
               }
               i++;
            }
            for(int j=0; j<currentOpenParas; j++){
                s=s+')';
            }

            System.out.println("Case #" + (k+1) +  ": "+  s);
        }
    }
}