import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SOlution
{
    public static void main(String args[])
    {
        int t,a[][]=new int[100][100];
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            int trace=0,rows=0,cols=0;
            int b[]=new int[n];
            int c[]=new int[n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    b[j]=a[i][j];
                }
                Arrays.sort(b);
                for(int m=0;m<n;m++)
                {
                	if(b[m]!=m+1)
                	{
                		rows++;
                		break;
                	}
                }
                
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    c[j]=a[j][i];
                }
                Arrays.sort(c);
                for(int m=0;m<n;m++)
                {
                	if(c[m]!=m+1)
                	{
                		cols++;
                		break;
                	}
                }
            }
            for(int i=0;i<n;i++)
            {
                trace+=a[i][i];
            }
            System.out.println();
            System.out.print("Case #"+k+": "+trace+" "+rows+" "+cols);
        }
        
    }
}