import java.io.*;
import java.util.*;

public class Solution {
   
   
    public static void main(String[] args) {
        Scanner y = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t;
        t=y.nextInt();
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+":");
            int n=y.nextInt();
             int count=0;
              for (int line = 0;count < n; line++) 
                  { 
                        for (int j = 0; j <= line; j++)
                        {
                            if(count<n)
                               {
                                   if(j==0 || j==line)
                                    {
                                        System.out.println((line+1)+" "+(j+1));
                                         count++;
                                       // System.out.println("count="+count);
                                    }
                               }
                                    
                               
                        } 
                 }
                   
             
        }
    }
}
	
	
	