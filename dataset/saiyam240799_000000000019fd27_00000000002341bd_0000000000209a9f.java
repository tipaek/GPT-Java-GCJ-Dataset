import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);

        int t = input.nextInt();
        int count =1;
        while(t-->0)
        {
            
            
            String s = input.next();
            
            int n = s.length();
            int x =0;
            
            int bracket =0;
            
            StringBuilder ans = new StringBuilder();
            int i=0;
            
            while(i<n)
            {
                x = (int)(s.charAt(i)-'0');
                
                if(bracket==x)
                {
                    ans.append(x);
                    i++;
                    
                }
                else if(bracket<x)
                {
                    
                    bracket++;
                    ans.append("(");
                    
                    if(bracket==x)
                    {
                        ans.append(x);
                        i++;
                    }
                    
                    
                    
                        
                }
                else if(bracket>x)
                {
                    bracket--;
                    ans.append(")");
                    
                    if(bracket==x)
                    {
                        ans.append(x);
                        i++;
                    }
                    
                }
                
            //    System.out.println(ans);
                    
                
                
                
            }
            
            while(bracket!=0)
            {
                ans.append(")");
                bracket--;
            }
            
            
            
            System.out.println("Case " + "#" + count +": " + ans);
            
            
            count++;
            
            
            
        }
        


		w.close();
	}
}



