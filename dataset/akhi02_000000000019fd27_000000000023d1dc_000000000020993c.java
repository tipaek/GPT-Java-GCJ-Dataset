import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int N=sc.nextInt();
            int[][] a=new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            int tr=0,r=0,c=0;
            for(int i=0;i<N;i++)
            {
                HashSet<Integer> hs=new HashSet<Integer>();
		        boolean f=false;
                for(int j=0;j<N;j++)
                {
                    if(i==j)
                    {
                        tr+=a[i][j];
                    }
		            if(!f)
		            {		
                    	if(hs.contains(a[i][j]))
	            	    {	
                        	r+=1;
				            f=true;
		    	        }
                    	else
                        	hs.add(a[i][j]);
		            }
               	}
            }
	    for(int j=0;j<N;j++)
            {
                HashSet<Integer> hs1=new HashSet<Integer>();
                for(int i=0;i<N;i++)
                {
                    if(hs1.contains(a[i][j]))
	                {	
                        c+=1;
			            break;
		            }
                    else
                        hs1.add(a[i][j]);
                }
            }
	    System.out.println("Case "+"#"+t+":"+" "+tr+" "+r+" "+c);	
        }
    }
}