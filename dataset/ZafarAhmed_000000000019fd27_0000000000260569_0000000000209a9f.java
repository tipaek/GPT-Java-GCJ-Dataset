import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String s = in.next();
          
          String paraS = "";
          for (int j = 0; j < s.length(); j++) 
          {
			int val = Integer.parseInt(s.charAt(j)+"");
			if( val == 0 )
			{
				paraS = paraS + val;
			}
			else 
			{
				String temp = ""+val;
				for (int k = 0; k < val; k++) {
					temp = "(" + temp + ")";		
				}
				paraS = paraS + temp;
			}
          }
          
          while( paraS.contains(")(") )
          {
        	  paraS = paraS.replace( ")(", "" );
          }
                   
       
          System.out.println("Case #"+i+": "+ paraS);  
        }
        in.close();
      }
      
    }
