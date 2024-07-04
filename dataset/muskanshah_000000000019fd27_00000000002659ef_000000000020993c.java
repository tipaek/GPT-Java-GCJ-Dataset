import java.util.*;
import java.io.*;
public class Solution {
	static int[] sort(int[]a)
	{
		int[]s=new int[a.length];
		Arrays.sort(a);
		return a;
	}
	static int calculate(int[][]a)
	{
		int max=0;
		for (int i = 0; i < a.length; i++) {
		int[]s=sort(a[i]);
		int c=1;
			  for (int j = 1; j < s.length; j++) {
				if(s[j]==s[j-1])
				{
					c++;
					if(max<c)
					{
						max=c;
						
					}
					
				}
				else
				{
					c=1;
				}
				
			}
				
			}
		return max;
	}
	public static void main(String[] args) {
	
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();int kk=1;
	while(t-->0)
	{
		int n=sc.nextInt();
		int[][]a=new int[n][n];
		int[][]transpose=new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		int trace=0;
		for (int i = 0; i < n; i++) {
			trace+=a[i][i];
		}
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				transpose[i][j]=a[j][i];
			}
		}
		int row=calculate(a);		
		int col=calculate(transpose);
		System.out.print("Case #"+kk+": "+trace+" "+row+" "+col);
		kk++;
		System.out.println();
	}
	
	

	}
			
}

