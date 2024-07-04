import java.util.*;
import java.io.*;
class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          String s  = in.next();
		    
		    int l = s.length();
		    
		    int ux = x;
		    int uy = y;
		    int j;
		    int time = 0;
		    for( j=0;j<l;j++)
		    {
		        char c = s.charAt(j);
		        int dist = 0;
		        switch(c){
		            
		            case 'N':
		                uy++;
		            break;
		            
		            case 'S':
		                uy--;
		            break;
		            
		            case 'E':
		                ux++;
		            break;
		            
		            case 'W':
		                ux--;
		            break;
		                      
		        }
		        dist = Math.abs(ux) + Math.abs(uy);
		        
		        //System.out.println(dist+ " "+j);
		        if(dist <= j+1)
		        {
		            time = j+1;
		            break;
		        }
		        
		        
		    }
		    if(j>=l){
		        System.out.println("Case #" +i+": "+ "IMPOSSIBLE");
		    }
		    else{
		        System.out.println("Case #" + i + ": "+ time);
		    }
		    
        }
      }
    }