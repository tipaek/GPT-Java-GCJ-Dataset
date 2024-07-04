import java.util.*;
 class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.next());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(sc.next());
            int[][] arr=new int[n][n];
            int trace=0;
            int rcount=0,ccount=0;
            boolean check;
            boolean[] col=new boolean[n];
            for(int j=0;j<n;j++)
            {
               
                 check=true;
                for(int k=0;k<n;k++)
                {
                    arr[j][k]=Integer.parseInt(sc.next());
                    if(j!=0  && !col[k])
                    {
                        for(int b=0;b<j;b++)
                        {
                            if(arr[b][k]==arr[j][k])
                            {
                                ccount++;
                                col[k]=true;
                            }
                        }
                    }
                    if( k!=0 && check)
                    {
                        for(int a=0;a<k;a++)
                        {
                            if(arr[j][a]==arr[j][k])
                            {
                                rcount++;
                                check=false;
                            }
                        }
                    }
                    if(j==k)trace+=arr[j][j];
                }
                
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+rcount+" "+ccount);
            
        }
    }
}