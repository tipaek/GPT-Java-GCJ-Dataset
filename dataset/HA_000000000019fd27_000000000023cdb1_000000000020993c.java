import java.util.*;
class Test
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t,n,i,j,c=0,r=0,x=1,tr=0;
        //System.out.print("Enter test case : ");
        t=sc.nextInt();
        
        while(t!=0)
        {
            tr=0;
            //System.out.print("Enter order : ");
            n=sc.nextInt();
            int a[][]=new int[n][n];
            //System.out.println("Enter array elements : ");
            for(i=0;i<n;i++)
            for(j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
                if(i==j)
                 tr+=a[i][j];
            }
            //System.out.println("\nDiagonal sum = "+tr);
            int a1[]=new int[n];
            int a2[]=new int[n];
            i=0;j=0;
            while(i<n)
            {
                for(j=0;j<n;j++)
                 a1[j]=a[i][j];
                
                Arrays.sort(a1);
                for(j=0;j<n-1;j++)
                if(a1[j]==a1[j+1])
                {
                    r++;
                    break;
                }
                i++;
            }
            i=0;j=0;
            while(i<n)
            {
                for(j=0;j<n;j++)
                 a2[j]=a[j][i];
                
                Arrays.sort(a2);
                for(j=0;j<n-1;j++)
                if(a2[j]==a2[j+1])
                {
                    c++;
                    break;
                }
                i++;
            }
            System.out.println("Case #"+(x++)+": "+tr+" "+r+" "+c);
            --t;
        }
    }
}
     