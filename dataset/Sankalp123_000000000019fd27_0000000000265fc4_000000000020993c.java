import java.util.*;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int res[][]=new int[t][3];
		for(int z=1;z<=t;z++)
		{
		    int n=sc.nextInt();
		    int mat[][]=new int[n][n];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            mat[i][j]=sc.nextInt();
		        }
		       // System.out.println();
		    }
		    int count1=0,count2=0,sum=0,ct1=0,ct2=0;
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            int ch=mat[i][j];
		            for(int k=(j+1);k<n;k++)
		            {
		                if(mat[i][k]==ch)
		                {
		                 ct1++;    
		                 break;
		                }
		            }
		            if(ct1!=0)
		            {
		                break;
		            }
		        }
		        if(ct1==0)
		        {
		            continue;
		            
		        }
		        else
		        {
		            ct1=0;
		            count1++;
		        }
		        //System.out.println();
		    }
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            int ch=mat[j][i];
		            for(int k=(j+1);k<n;k++)
		            {
		                if(mat[k][i]==ch)
		                {
		                 ct2++;    
		                 break;
		                }
		            }
		            if(ct2!=0)
		            {
		                break;
		            }
		        }
		        if(ct2==0)
		        {
		            continue;
		            
		        }
		        else
		        {
		            ct2=0;
		            count2++;
		        }
		        //System.out.println();
		    }
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
                 if(i==j)
                 {
                     sum+=mat[i][j];
                 }
		        }
		    }
		    res[z-1][0]=sum;
		    res[z-1][1]=count1;
		    res[z-1][2]=count2;
		}
		for(int i=0;i<t;i++)
		{
		    System.out.println("Case #"+(i+1)+": "+res[i][0]+" "+res[i][1]+" "+res[i][2]);
		}
	}
}
