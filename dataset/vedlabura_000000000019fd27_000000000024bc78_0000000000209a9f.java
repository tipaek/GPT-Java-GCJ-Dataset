

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution {
	public static void main (String[] args) throws java.lang.Exception{
	    
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int  i =0; i<t;i++){
            String s = in.next();
            int count = 0;
            
            StringBuilder ans  = new StringBuilder(); 
            
            for(int j = 0; j<s.length();j++){
                int current = Character.getNumericValue(s.charAt(j));
                while(current< count){ ans.append(")");
                count--;
                }
                while(current> count){ ans.append("(");
                count++;
                }
                if(current==count) ans.append(current);
                
            }
            
            while(count>0){ ans.append(")");
                count--;
                }
            
            System.out.println("Case #"+(i+1) + ":"+ " "+ans);
        }
	}
}
