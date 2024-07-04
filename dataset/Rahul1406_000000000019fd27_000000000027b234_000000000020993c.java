import java.util.Scanner;

public class Vestigium {

	public static void main(String args[])
	{ 
	 Scanner s=new Scanner(System.in);
	    int T=s.nextInt();
	    int N;
	    
	    for(int i=1;i<=T;i++)
	    { 
	      N=s.nextInt();
	        int arr[][]=new int[N][N];
	        int k = 0;
	        int r=0;
		    int c=0;
	        for(int i1=0;i1<arr.length;i1++)
	        {
	        	for(int j=0;j<arr.length;j++)
	        	{
	        		arr[i1][j]=s.nextInt();	        		
	        	}
	        }
	        
	        
	        for(int x=0;x<N;x++)
            {
                k+=arr[x][x];
            }

        
        for(int j=0;j<N;j++)
        {
            int count=0;
            for(int k1=0;k1<N;k1++)
            {
                if(count==1)
                    break;
                else
                {
                    int key=arr[j][k1];
                    for(int l=0;l<N;l++)
                    {
                        if(l==k1)
                        { }
                        else
                        {
                            if(arr[j][l]==key)
                            {   count++;
                                r++;
                                break;
                            }
                        }
                    }
                }
            }
        }



         
       for(int k2=0;k2<N;k2++)
       {
           int count=0;
           for(int j=0;j<N;j++)
           {
               if(count==1)
                   break;
               else
               {
                   int key=arr[j][k2];  
                   for(int l=0;l<N;l++)
                   {
                       if(j==l)
                       { }
                       else
                       {
                           if(arr[l][k2]==key)
                           {
                               count++;
                               c++;
                               break;
                           }
                       }
                   }
               }
           }
       }
        System.out.println("Case #" + (i+1) + ": " + k + " " + r+" "+c);
}
	    }
	    
	    
}
	
