import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int i,k,j,d=0,r=0,c=0;
        int t=scan.nextInt();
        int arr[][]=new int[100][100];
        int row[]=new int[100];
        int col[]=new int[100];
        int daigonal[]=new int[100];
for(k=0;k<t;k++)
{       
     int n=scan.nextInt();
            for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                arr[i][j]=scan.nextInt();
            }
        }
        i=0;j=0;
        while(i!=n)
        d=d+arr[++i][++j];
        daigonal[k]=d;
        for ( i= 0; i<n; i++)
    {
        int x=0;
        for (j = 0;j<n;j++)
        {
            int num = arr[i][j];
            for (int otherCol = j+ 1; otherCol < j; otherCol++)
            {
                if (num == arr[i][otherCol])
                   x++;
              }
        }
          if(x!=0)
	r++;
    }
        row[k]=r;
    for ( j= 0; j<n; j++)
    {
        int x=0;
        for (i = 0;i<n;i++)
        {
            int num = arr[i][j];
            for (int otherrow = i+ 1; otherrow< i; otherrow++)
            {
                if (num == arr[otherrow][j])
                   x++;
              }
        }
          if(x!=0)
	c++;
    }
    col[k]=c;
        
}    
   for(k=0;k<t;k++)
   {
       int y=k+1;
       System.out.println("Case \t"+y+":\t"+daigonal[k]+"\t"+row[k]+"\t"+col[k] );
   }
    
    
    }
    
}