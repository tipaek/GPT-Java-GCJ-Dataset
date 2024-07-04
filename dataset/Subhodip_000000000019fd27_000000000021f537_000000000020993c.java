import java.util.*;
import java.io.*;
import java.lang.*;
class Solution
{
    static int N,matrix[][];
    public static void main(String args[])
    {
	try{
    	Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=sc.nextInt();
        for(int i=1;i<=T;i++)
        {
            input(sc);
            System.out.print("Case #"+i+": "+trace());
            maxDuplicates();
	}
	}catch(Exception e){}
        
    }
    static void input(Scanner sc)throws Exception
    {
        N=sc.nextInt();
        matrix=new int[N][N];
        int i,j;
        for(i=0;i<N;i++)
            for(j=0;j<N;j++)
                matrix[i][j]=sc.nextInt();
    }
    static int trace()throws Exception
    {
        int i,Sum=0;
        for(i=0;i<N;i++)
            Sum+=matrix[i][i];
        return Sum;
    }
    static void maxDuplicates()throws Exception
    {
        int i,j,maxR=0,maxC=0;
        int dupR[];
        int dupC[];
        for(i=0;i<N;i++)
        {
        	dupR=new int[100];
        	dupC=new int[100];
            for(j=0;j<N;j++)
            {
                dupR[matrix[i][j]]++;
                dupC[matrix[j][i]]++;
            }
	    	for(i=0;i<100;i++)
        	{
            	if(dupR[i]>maxR)
            	    maxR=dupR[i];
            	if(dupC[i]>maxC)
            	    maxC=dupC[i];
        	}
        }
        if(maxR==1)maxR-=1;
        if(maxC==1)maxC-=1;
        System.out.println(" "+maxR+" "+maxC);
    }
}
