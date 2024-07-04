import java.util.*;
import java.io.*;
class Solution
{
  public static void main(String[] args)throws IOException
  {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		if(T>=1 && T<=100)
		{
            
            for (int l =1;l<=T;l++)
            {
                int c=0,d=0,trace = 0;
                int N=Integer.parseInt(in.readLine());
                if(N>=2 && N<=100)
                {
                    int arr[][]=new int[N][N];
                    for(int i= 0;i<N;i++)
                    {
                        String str[]=in.readLine().split(" ",N);
                        {
                            for (int j= 0; j < N; j++) 
                            { 
                                arr[i][j]=Integer.parseInt(str[j]);                            
                            }                        
                        }
                    }               
                    for (int i=0; i<N; i++)
                    {
                        trace+= arr[i][i]; 
                    }              
                    for (int ar[]: arr) 
                    {
                        Set<Integer> set = new HashSet<>();
                        for (int a : ar) 
                        {
                            set.add(a);
                        }                    
                        if(set.size()!=N)
                        {
                            c++;
                        }                    
                    }

                    for (int i = 0; i < N; i++) 
                    {
                        for (int j = i+1; j < N; j++) 
                        { 
                            int temp = arr[i][j]; 
                            arr[i][j] = arr[j][i]; 
                            arr[j][i] = temp; 
                        } 
                    }
                    
                    for (int ar[]: arr) 
                    {
                        Set<Integer> set = new HashSet<>();
                        for (int a : ar) 
                        {
                            set.add(a);
                        }                    
                        if(set.size()!=N)
                        {
                            d++;
                        }                                      
                    }         				
                }System.out.println("Case #"+l+": "+trace+" "+c+" "+d);
            }
            
        }
    }
}
