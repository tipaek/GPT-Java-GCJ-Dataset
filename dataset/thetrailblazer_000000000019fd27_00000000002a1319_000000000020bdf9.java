import java.util.*;
import java.io.*;
public class Solution{
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ii = 1; ii <= t; ++ii) {
      int num = in.nextInt();
      int a[][]=new int[num][3];
      for(int x=0;x<num;x++) {
  			for(int y=0;y<3;y++) {
  				if (y==2) a[x][2]=99;
  				else
  				a[x][y]=in.nextInt();
   			}
  		}
  		 a[0][2]=1;
	  for(int aa=1; aa<num; aa++)
	  {
		  int z=0;
		  int jj=0;
		  int kk=0;
		  for (jj=0;jj<aa;jj++)
		  {
			  if (z==2) 
				break;
				if ((a[aa][0]<a[jj][0]) && (a[aa][1]>a[jj][0])) {z=z+1; kk=jj; continue;}
				if ((a[aa][0]<a[jj][1]) && (a[aa][1]>a[jj][1])) {z=z+1; kk=jj; continue;}
				if ((a[aa][0]>a[jj][0]) && (a[aa][1]<a[jj][1])) {z=z+1; kk=jj; continue;}
			
		  }
			if (z==1)
			{
				
				if ( a[kk][2]==1)
					a[aa][2]=0;
				else {
					a[aa][2]=1;
				}
		  
			}
			if (z==0) {
				a[aa][2]=a[jj-1][2];
			}
		  
	  }
	  System.out.print("Case #" + (ii) + ": ");
	 int z=0;
	  for(int l=0;l<num;l++)
			{
			if(a[l][2]==99) 
				{
				System.out.print("IMPOSSIBLE");
				z=1;
				break;
				}
			}	
	  if (z==0)
	  {
		  for(int iii=0;iii<num; iii++)
		  {
     	  	if(a[iii][2]==0)
			System.out.print('C');
			else {
				System.out.print('J');
			}
		  }
	  }	
	  
		System.out.println();
		}
	}
}
