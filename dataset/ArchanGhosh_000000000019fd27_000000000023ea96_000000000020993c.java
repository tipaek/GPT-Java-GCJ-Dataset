    import java.util.*;
class trace 
{

static void main(String[] args)
{
    int t=0, n=0;
    Scanner sc=new Scanner(System.in);
    do
    {
       System.out.println("Enter Test cases between 1 and 100");
       t=sc.nextInt();
       if((t>=1) && (t<=100))
        break;
    }while((t<1) && (t>100));
    for(int l=1;l<=t;l++)
    {
        do
        {
            System.out.println("Enter N between 2 and 100");
            n=sc.nextInt();
            if((n>=2) && (n<=100))
            {
                int a[][]=new int[n][n];
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.println("Enter value at "+i+" row and "+j+" Column between 1 and "+n);
                        a[i][j]=sc.nextInt();                      
                    }
                }
                int trace=0, r_same=0, c_same=0;
                //for trace
                for(int i=0;i<n;i++)
                {
                    trace=trace+a[i][i];
                }
                //for r_same
                for(int i=0;i<n;i++)
                {
                    second:
                    for(int j=0;j<n-1;j++)
                    {
                        int temp=a[i][j];
                        for(int k=j+1;k<n;k++)
                        {
                            if(temp==a[i][k])
                            {
                                r_same=r_same+1;
                                break second;
                            }
                        }
                    }
                    
                }
                //for c_same
                for(int i=0;i<n;i++)
                {
                    second:
                    for(int j=0;j<n-1;j++)
                    {
                        int temp=a[j][i];
                        for(int k=j+1;k<n;k++)
                        {
                            if(temp==a[k][i])
                            {
                                c_same=c_same+1;
                                break second;
                            }
                        }
                    }
                    
                }
                System.out.println(trace+" "+r_same+" "+c_same);
                break;
            }
        }while((n<2) && (n>100));
    }
}
}