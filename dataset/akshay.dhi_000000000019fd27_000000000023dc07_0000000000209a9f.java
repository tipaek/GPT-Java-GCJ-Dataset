import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int counter = 1;
      while(testCases > 0) {    
        counter +=1;
        String s = br.readLine();
        int level = 0;
        String result = "Case #"+counter+": ";
        for(int i=0;i<s.length();i++) {
            int currLevel = (int) s.charAt(i)-'0';
            System.out.println("curr level "+currLevel+" level "+level);
            
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
        System.out.println(result);
      }
    }

}