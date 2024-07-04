import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
    	int tt=1;
    	Scanner sc=new Scanner(System.in);
    	int t=Integer.parseInt(sc.nextLine());
    	while(t-->0)
    	{
    		int n=Integer.parseInt(sc.nextLine());
    		int mat[][]=new int[n][n];
    		int k=0;
    		int g=0;
    		int ans=0;
    		for(int i=0;i<n;i++)
    		{
    			String h[]=sc.nextLine().split(" ");
    			ans+=Integer.parseInt(h[i]);
    			HashSet<Integer>set=new HashSet<>();
    			int flag=0;
    			for(int j=0;j<n;j++){
    				mat[i][j]=Integer.parseInt(h[j]);
    				if(!set.add(mat[i][j])){flag=1;}
    			}
    			if(flag==1){k+=1;}

    		}
    		for(int j=0;j<n;j++)
    		{
    			HashSet<Integer>set=new HashSet<>();
    			int flag=0;
    			for(int i=0;i<n;i++){
if(!set.add(mat[i][j])){flag=1;}
    			}
    			if(flag==1){g+=1;}
    		}
    		System.out.println("Case #"+tt+": "+ans+ " "+k+" "+g);
    		tt+=1;
    	}
    }
}