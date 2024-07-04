import java.util.*;
class Solution
{
       

	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int N=in.nextInt();
	        int[] startO=new int[N];
	        int[] endO=new int[N];
	        int[] index=new int[N];
	        char[] result=new char[N];
	        
            int C=1,J=0;
            ArrayList<Character> aL=new ArrayList<Character>();
            aL.add('C');
            
            for(int n=0;n<N;n++)
            {
                startO[n]=in.nextInt();
                endO[n]=in.nextInt();
                index[n]=n+1;
            }
            
            for(int i=0; i < N; i++)
            {  
                 for(int j=1; j < (N-i); j++)
                 {  
                          if(startO[j-1] > startO[j])
                          {  
                                 //swap elements  
                                int temp = startO[j-1];  
                                 startO[j-1] = startO[j];  
                                 startO[j] = temp; 
                                 
                                 temp = endO[j-1];  
                                 endO[j-1] = endO[j];  
                                 endO[j] = temp; 
                                 
                                 
                                 temp = index[j-1];  
                                 index[j-1] = index[j];  
                                 index[j] = temp; 
                                 
                         }  
                          
                 }  
            }  
            
           
            
            int f=1;
            for(int n=1;n<N;n++)
            {
                int a=startO[n];
                int b=endO[n];
                if(startO[C-1]<=a && a<endO[C-1])
                {
                    if(J==0 || a>=endO[J-1])
                    {
                        J=n+1;
                        aL.add('J');
                    }
                    else
                    {
                        f=0;break;
                    }
                }
                else
                {
                    C=n+1;
                    aL.add('C');
                }
            }
            System.out.print("Case #"+tc+": ");
            if(f==0)
            System.out.println("IMPOSSIBLE");
            else
            {
                for(int i=0;i<N;i++)
                {
                    result[index[i]-1]=aL.get(i);
                }
                for(int i=0;i<N;i++)
                    System.out.print(result[i]);
                System.out.println();    
            }
            
	    }
	    
	}
}
