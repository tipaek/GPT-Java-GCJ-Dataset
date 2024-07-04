import java.util.*;
class Solution
{
    public static boolean duplicates(final int[] zipcodelist)
    {
      Set<Integer> lump = new HashSet<Integer>();
      for (int i : zipcodelist)
      {
        if (lump.contains(i)) return true;
        lump.add(i);
      }
      return false;
    }   
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int N=in.nextInt();
	        int[][] arr=new int[N][N];
	        int[] temp=new int[N];
	        int trace=0,cols=0,rows=0;
	        
	        for(int i=0;i<N;i++)
	        {
	            for(int j=0;j<N;j++)
	            {
	                arr[i][j]=in.nextInt();
	                if(i==j)trace+=arr[i][j];
	                temp[j]=arr[i][j];
	                
	            }
	            
	            if(duplicates(temp))rows++;
	        }
	        
	        for(int i=0;i<N;i++)
	        {
	            for(int j=0;j<N;j++)
	            {
	                temp[j]=arr[j][i];
	                
	            }
	           
	            if(duplicates(temp))cols++;
	        }
	        System.out.println("Case #"+tc+": "+trace+" "+rows+" "+ cols);
	    }
	    
	}
}
