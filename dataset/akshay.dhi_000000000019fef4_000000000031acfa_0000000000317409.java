import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        
        int testCases = Integer.parseInt(str.nextToken());

        int no = 1;
        while(testCases-- > 0) {
            boolean found = false;
            int steps = 0;
            str = new StringTokenizer(br.readLine());
       	    int east = Integer.parseInt(str.nextToken());
            int north = Integer.parseInt(str.nextToken());
            
            String path = str.nextToken();
            
            for(int i= 0;i<path.length();i++) {
                
                char ch = path.charAt(i);
                if(ch == 'N') {
                    north = north+1;
                    
                } else if (ch == 'S') {
                    north = north -1;
                    
                } else if (ch == 'W') {
                    east = east - 1;
                    
                } else {
                    east = east + 1;
                    
                }
                
                if((Math.abs(east)+Math.abs(north))<= (i+1))
                {
                    found = true;
                    steps = i+1;
                    break;
                }
                
            }
            
            if(found)
           System.out.println("Case #"+no+": "+steps);
           else
           System.out.println("Case #"+no+": IMPOSSIBLE");
           
           no++;
            
            
        }
    
    }

}