import java.util.Arrays;
import java.util.Scanner;
public class Solution {

    public static int trace(int a[][])
    {    int s=0;
    for(int i=0;i<a.length;i++)
    {
        for(int j=0;j<a.length;j++)
        {
            if(i==j)
            {
                s=s+a[i][j];
            }
        }
    }
    return s;
    }
    public static int row(int a[][])
    {     int c=0;
        for(int i=0;i<a.length;i++)
        {int l=0;
            for(int j=0;j<a.length-1;j++)
            {    
                for(int k=j+1;k<a.length;k++)
                {
                    if(a[i][j]==a[i][k])
                    {
                        l=1;
                        
                        break;
                    }
                }
                
            }
            if(l==1)
                c++;
        }
        
        return c;
    }
    public static int column(int  a[][])
    {
          int u=0;
        for(int q=0;q<a.length;q++)
        {    int t=0;
            for(int w=0;w<a.length;w++)
            {  
                for(int e=w+1;e<a.length;e++)
                {
                    if(a[w][q]==a[e][q])
                    {
                        t=1;
                        break;
                    }
                   
                }
                
            }
            if(t==1)
                u++;
        }
        
        return u;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int p=1;p<=t;p++)
        {  int n=in.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<a.length;i++)
            {
                for(int j=0;j<a.length;j++)
                {
                    a[i][j]=in.nextInt();
                }
            }
            System.out.println("Case #"+p+": "+trace(a)+" "+row(a)+" "+column(a));
            Arrays.fill(a, null);
            
        }
    }
    
}
