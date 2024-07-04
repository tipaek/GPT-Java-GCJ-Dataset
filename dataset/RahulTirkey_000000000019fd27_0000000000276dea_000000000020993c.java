package work;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Game 
{
	
	    public static void main(String args[])
	    {
	        Scanner s=new Scanner(System.in);
	        int T=Integer.parseInt(s.nextLine());
	        int i,j,k,c=0,l=0;
	        int N;
	        for(i=1;i<=T;i++)
	        {
	        N=s.nextInt();
	        int M[][]=new int[N][N];
	        int d[]=new int[N];
	        int e[]=new int[N];
	        for(j=0;j<N;j++)
	        {
	            for(k=0;k<N;k++)
	            {
	                M[j][k]=s.nextInt();
	            }
	        }
	        System.out.print("Case #"+i+": ");
	        Set u=new HashSet();
	        Set v=new HashSet();
	        for(j=0;j<N;j++)
	        {
	            for(k=0;k<N;k++)
	            {
	                if(j==k)
	                l=l+M[j][k];
	               
	                u.add(M[j][k]);
	                
	                if(j==0)
	                { c=0;
	                    while(c<N)
	                    {
	                    v.add(M[c][k]);
	                    c++;
	                    }
	                }
	                if(j==0)
	                {
	                d[k]=N-(v.size()-1);
	                }
	            }
	            
	            e[j]=N-(u.size()-1);
	            
	        }
	        int rowmax = Arrays.stream(e).max().getAsInt();
	        if(rowmax==1)
	        	rowmax=0;
	        int colmax = Arrays.stream(d).max().getAsInt();
	        if(colmax==1)
	        	colmax=0;
	        System.out.print(rowmax+" "+colmax);
	        
	        }
	        s.close();
	    }
	}

