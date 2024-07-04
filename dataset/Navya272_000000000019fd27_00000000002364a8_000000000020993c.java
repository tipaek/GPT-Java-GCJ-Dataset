import java.util.*;
class Main
{
    public static void main(String Args[])
    {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    for(int x=0;x<t;x++)
    {
        int tra=0;
        int n=in.nextInt();
        int a[][]=new int[n][n];
        int r=0,c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=in.nextInt();
                if(i==j)
                tra=tra+a[i][j];
            }
        }
         for(int i=0;i<n;i++)
        {int d=0,b=0;
            for(int j=0;j<n;j++)
            {    
                for(int k=j+1;k<n;k++)
                {
                    if(a[i][j]==a[i][k])
                
                            b++;//System.out.println(a[i][j]+" "+a[i][k]);}
                    if(a[j][i]==a[k][i])
                    d++;//System.out.println(a[i][j]+" "+a[k][j]);}
                    
                }
                
            }if(b>0)
                r++;
                if(d>0)
                c++;
        }
        
        System.out.println(tra+" "+r+" "+c);
    }
}
}