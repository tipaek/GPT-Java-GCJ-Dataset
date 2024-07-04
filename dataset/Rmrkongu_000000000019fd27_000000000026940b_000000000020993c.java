import java.io.*;
import java.util.*;
class new1
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int b=0;
        int i,j;
        for(int p=0;p<n;p++)
        {
            b++;
            int m=s.nextInt();
            int[][] a=new int[m][m];
            for(i=0;i<m;i++)
            {
                for(j=0;j<m;j++)
                {
                    a[i][j]=s.nextInt();
                }
                
            }
            int sum=0;
            for( i=0;i<m;i++)
            {
                for(j=0;j<m;j++)
                {
                    if(i==j)
                    {
                        sum=sum+a[i][j];
                    }
                    
                }
                
            }
            int row=0;
            for(i=0;i<m;i++)
            {
                for(j=i;j<m;j++)
                {
                    if(a[i][0]==a[i][j])
                    {
                        row++;
                        break;
                    }
                    
                }
                
            }
            int column=0;
            for(j=0;j<m;j++)
            {
                for(i=j;i<m;i++)
                {
                    if(a[0][j]==a[i][j])
                    {
                        column++;
                        break;
                    }
                    
                }
                
            }
            
            System.out.print("Case #"+b+":");
            System.out.print(sum);
            System.out.print(row);
            System.out.println(column);
        }
    }
}