import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) {
	main1();
	}
	public static int main1() {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		   int t = sc.nextInt(); 
		   for (int i = 1; i <= t; ++i)
		   {
			   int n= sc.nextInt();
			   int[] arr= new int[2*n];
			   StringBuilder ans= new StringBuilder(n);
			  
			   //taking time
			   for(int j=0;j<2*n;j++)
				   arr[j]=sc.nextInt();

		   	//impossible ans
			   int imp=0;
			   
			   for(int k=1;k<2*n-3;k++)
			   {   
				   if((arr[k]>arr[k+1]) && (arr[k]>arr[k+3]) && (arr[k+2]>arr[k+3]))
				   {
					   System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
					   imp=1;
					   break;
				   }
			   }
			   if (imp==1)
					   return 0;
			   
			   //constructing ans
			   ans.append("C");
				 
			   for(int j=0;j<n-1;j++)
			   { 
				   if (arr[2*j+1]>arr[2*j+2])
				   {
					   if(ans.charAt(j)=='C')
						   ans.append("J");
					   else
						   ans.append("C");
					}
				   else
					   ans.append(ans.charAt(j));
			   }
			   
			   System.out.println("Case #" + i + ": " + ans.toString());
			   
		   }
		   
		   return 0;


}
}