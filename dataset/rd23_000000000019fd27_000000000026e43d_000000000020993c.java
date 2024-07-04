import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int T=sc.nextInt();
        int count=0;
        while(T>=1)
        {
            count++;
            int N=sc.nextInt();
            int[][] M=new int[N][N];
            int k=0;
            int r=0;
            int c=0;
            
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    M[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(i==j)
                    k=k+M[i][j];
                }
            }
            
            for(int i=0;i<N;i++)
            {
                int g=0;
                int m=0;
                for(int j=g;j<N;j++)
                {
                    if(j==N-1)
                    {
                        g++;
                        m++;
                        j=g;
                        
                    }
                    if(g==N-1)
                    break;
                    if(M[i][m]==M[i][j+1])
                    {
                    r++;
                    break;
                    }
                    else 
                    continue;
                }
            }
            for(int i=0;i<N;i++)
            {
                int g=0;
                int m=0;
                for(int j=g;j<N;j++)
                {
                    if(j==N-1)
                    {
                        g++;
                        m++;
                        j=g;
                        
                    }
                    if(g==N-1)
                    break;
                    if(M[m][i]==M[j+1][i])
                    {
                    c++;
                    break;
                    }
                    else 
                    continue;
                }
            }
            
            System.out.println("Case #"+count+": "+k+" "+r+" "+c);
            T--;
            
        }
    }
}
        