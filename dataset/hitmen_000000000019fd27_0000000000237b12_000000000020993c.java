/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		int t,n;
        int sum=0;
        int count = 0, rcommon=0, ccommon = 0, num =0, count1=0;
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        
        for(int w=0;w<t;w++)
        {
            n=sc.nextInt();
            int m[][]=new int[n][n];
            int q=w+1;
            sum = 0;
            rcommon = 0;
            count = 0;
            count1 = 0;
            ccommon=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m[i][j]=sc.nextInt();
                if(i==j){
                    sum+=m[i][j];
                }
            }
        }
        int c[]=new int[n+1];
        int t2=0,t3=0;
        for(int i=0;i<=n;i++)
         c[i]=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int z=m[i][j];
                c[z]++;
                if(c[z]>1)
                 t2++;
            }
            if(t2>0)
            {
                rcommon++;
                t2=0;
            }
            for(int j=0;j<=n;j++)
              c[j]=0;
             
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int z=m[j][i];
                c[z]++;
                if(c[z]>1)
                 t3++;
            }
             //System.out.println(t3);
            if(t3>0)
            {
                ccommon++;
                t3=0;
            }
            for(int j=0;j<=n;j++)
              c[j]=0;
        }
        System.out.println("Case "+"#"+q+": "+sum+" "+rcommon+" "+ccommon);
        }
        
        
     }
}
