import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        int q,i,j;
        for(q=1;q<(cases+1);q++)
        {
            i=0;
            String s1 = "";
            String s = sc.next();
            while(i<s.length())
            {
                if(s.charAt(i)=='0')
                {
                s1=s1+'0';
                i++;
                }
                else
                {
                    int count=0;
                    for(j=i+1;j<s.length();j++)
                    {
                        if(s.charAt(j)=='1')
                        {
                          count++;  
                        }
                        else
                        break;
                    }
                    for(int k=0;k<(count+1);k++)
                   {
                    s1 = s1 + '(';
                   } 
                   for(int k=0;k<(count+1);k++)
                   {
                    s1 = s1 + '1';
                   }
                   for(int k=0;k<(count+1);k++)
                   {
                    s1 = s1 + ')';
                   }
                   
                    
                    
                    
                    
                    
                    
                    
                    
                    
                }
            }
        }
        
    }
}