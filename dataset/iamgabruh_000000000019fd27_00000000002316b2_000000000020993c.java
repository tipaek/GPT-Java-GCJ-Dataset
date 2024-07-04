/* package codechef; // don't place package name! */
// package random;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
     static int countset(int x)
{
    x ^= x>>16;
    x ^= x>>8;
    x ^= x>>4;
    x ^= x>>2;
    x ^= x>>1;

    return (x & 1);
}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int test=1;
		while(t-->0)
		{
		    int n=Integer.parseInt(br.readLine().trim()); 
		    
		    
		    
            int mat[][]=new int[n][n];
            int l=0;
            for(int i=0;i<n;i++)
            {
            	StringTokenizer tok=new StringTokenizer(br.readLine()," ");
                
                for(int j=0;j<n;j++)
                {
                    mat[l][j]=Integer.parseInt(tok.nextToken());
                    
                    
                }
                l++;
              
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            int r=0;
            int c=0;
            int sum=0;
            for(int i=0;i<n;i++)
            {
                sum+=mat[i][i];
                for(int j=0;j<n;j++)
                {
                    if(map.containsKey(mat[i][j])){
                        r++;
                       
                        break;
                    }
                    else{
                        map.put(mat[i][j],1);
                    }
                    
                    
                }
                map.clear();
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    
                    if(map.containsKey(mat[j][i])){
                        c++;
                        break;
                    }
                    else{
                        map.put(mat[j][i],1);
                    }   
                    
                }
                map.clear();
                
              
            }
            
                     System.out.println("Case #"+test+++": "+sum+" "+r+" "+c);
		}
	}
}
