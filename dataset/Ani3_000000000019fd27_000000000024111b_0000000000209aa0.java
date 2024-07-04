import java.util.*;

class indi
{

  public static void main (String[]args)
  {
    Scanner in = new Scanner (System.in);
    String[]l1 = in.nextLine ();
    int t = Integer.parseInt (l1[0]);
    for (int i = 1; i <= t; i++)
    {
        int trace = 0;
	     String[] l0 = in.nextLine ().split ("\\s+");
	     int n = Integer.parseInt (l0[0]);
	     int k = Integer.parseInt (l0[1]);
	     int center = k / n;
	     int[][] arr = new int[n][n];
	     int j, m;
	     for (j = 0; j < n; j++)
	     {
	         for (m = 0; m < n; m++)
	        	{
	    	         int p = n - j;
		              int val = ((p + m) % n) + center;
	    	          if (val > n)
    	    	      {
	        	        val = val - n;
	    	          }
		              arr[j][m] = val;
        	       if (m == j)
		                trace = trace + val;
		        }
	    }
	  if (trace == k)
	    {
	      System.out.println ("Case #" + i + ": POSSIBLE");
	      for (j = 0; j < n; j++)
	      {
	    	  for (m = 0; m < n; m++)
		    {
		      System.out.print (arr[j][m] + " ");
		    }
		  System.out.println ();
		}
	    }
	  else
	    {
	      System.out.println ("Case #" + i + ": IMPOSSIBLE");
	    }

	}
    }
  }



