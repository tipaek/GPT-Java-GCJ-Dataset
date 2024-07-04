import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) 
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int counter = 1;
      while(testCases-- > 0) {    
        counter +=1;
        String s = br.readLine();
        int level = 0;
        String result = "Case #"+counter+": ";
        for(int i=0;i<s.length();i++) {
            int currLevel = (int) s.charAt(i)-'0';

            for(int j=level; j<currLevel;j++) {
                result += "(";
                level++;
            }
            for(int j=level; j>currLevel;j--) {
                result += ")";
                level--;
            }
            result+=s.charAt(i);
        }
        for(int j=level;j>0;j--) {
            result += ")";
            level --;
        }
        System.out.println(result);
      }
    
 }
}