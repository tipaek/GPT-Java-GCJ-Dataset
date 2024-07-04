/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		for(int x=0;x<t;x++)
		{
		    int n=s.nextInt();
		    int a[][]= new int[n][n];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j]=s.nextInt();
		        }
		    }
		    int sum=0,row=0,column=0,flag_row=0,flag_column=0;
		    for(int i=0;i<n;i++)
		    {
		        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		        flag_row=0;
		        for(int j=0;j<n;j++)
		        {
		            if(i==j)
		                sum=sum+a[i][j];
		            if(hm.containsKey(a[i][j]) && flag_row==0){
		                row++;
		                flag_row=1;
		            }
		            hm.put(a[i][j],1);
		        }
		    }
		    for(int j=0;j<n;j++)
		    {
		        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		        flag_column=0;
		        for(int i=0;i<n;i++)
		        {
		            if(hm.containsKey(a[i][j]) && flag_column==0){
		                column++;
		                flag_column=1;
		            }
		            hm.put(a[i][j],1);
		        }
		    }
		    System.out.println("Case #"+(x+1)+": "+sum+" "+row+" "+column);
		}
	}
}
