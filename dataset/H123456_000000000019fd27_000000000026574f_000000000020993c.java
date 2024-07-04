

public class Solution
{
   public static void main(String args[])
   {
	   // initialize here.
       int  n, i, j, t,num;
       int arr[][] = new int[10][10];
       Scanner scan = new Scanner(System.in);
	   
 
       t = scan.nextInt();
       for (num=0; num<t;num++)
	   {
		n = scan.nextInt();
	    
	    
	    int r = 0, c=0;
		for(i=0; i<n; i++)
		{
		    HashSet<Integer> r1 = new HashSet<Integer>();
			for(j=0; j<n; j++)
			{
               arr[i][j] = scan.nextInt();
    
			   r1.add(arr[i][j]);
			}
			if(r1.size()< n)
			r++;	
		}
		 int trace = 0; 
        for ( i = 0; i < n; i++) { 
            trace += arr[i][i]; 
           
        } 
	
		
		for(i=0; i<n; i++)
		{
		    HashSet<Integer> c1 = new HashSet<Integer>();
			for(j=0; j<n; j++)
			{
              c1.add(arr[j][i]);
			}
			if(c1.size() < n)
			++c;	
		}
      System.out.println(trace+" "+r+" "+c);
	   }
	   
	   
   }
   
}