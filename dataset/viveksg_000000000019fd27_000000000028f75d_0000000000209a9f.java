import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int tc = Integer.parseInt(br.readLine()) + 1;
         String res = "", inp = "";
         String bracket_left[] = new String[10];
         String bracket_right[] = new String[10];
         int i1 = 0, i = 0, j = 0, k  = 0, bleft = 0;
         bracket_left[0] = "";
         bracket_right[0] = "";
         for(i = 1; i < bracket_left.length; i++){
             bracket_left[i] = bracket_left[i-1] + "(";
             bracket_right[i] = bracket_right[i-1] + ")";
         }
         for(i1 = 1; i1 < tc; i1++){
             res = "";
             bleft = 0;
             inp = br.readLine().trim();
             for(i = 0; i < inp.length(); i++){
                 j = inp.charAt(i) - '0';
                 if(bleft <= j){
                     res += (bracket_left[j - bleft] + j);
                 }
                 else{
                     res += (bracket_right[bleft] + bracket_left[j] + j);
                 }
                 bleft = j;
             }
             res += bracket_right[bleft];
             System.out.println("Case #"+i1+": "+res);
         }
    }
}