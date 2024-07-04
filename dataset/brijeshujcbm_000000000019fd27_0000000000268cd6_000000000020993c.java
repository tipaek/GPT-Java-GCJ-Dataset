import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    for(int m=0;m<t;m++)
	    {
	        int n=sc.nextInt();
	        int i,j,cr=0,cc=0,p,tr=0,k;
	        int arr[][]=new int[100][100];
	        for(i=0;i<n;i++)
	        {
	            for(j=0;j<n;j++)
	            {
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        for(i=0;i<n;i++)
	        {
	            tr+=arr[i][i];
	        }
	        for(i=0;i<n;i++)
	        {
	        outer1:    for(j=0;j<n;j++)
	            {
	                p=arr[i][j];
	                for(k=0;k<n;k++)
	                {
	                    if(k==j)
	                    continue;
	                    if(p==arr[i][k])
	                    {
	                        cr++;
	                        break outer1;
	                    }
	                }
	            }
	        }
	        for(i=0;i<n;i++)
	        {
	        outer2:    for(j=0;j<n;j++)
	            {
	                p=arr[j][i];
	                for(k=0;k<n;k++)
	                {
	                    if(k==j)
	                    continue;
	                    if(p==arr[k][i])
	                    {
	                        cc++;
	                        break outer2;
	                    }
	                }
	            }
	        }
	        System.out.println("Case #"+(m+1)+":"+" "+tr+" "+cr+" "+cc);
	        
	    }
	    sc.close();
	}
}
