import java.util.*;

class GFG
{
    public static int count=1;
    public static void main(String args[] )
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            check(n);
        }
    }
    public static void check(int n)
    {
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int k=0;
        int row=0;
        int col=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> forRow=new HashSet<>();
            Set<Integer> forCol=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(!forRow.add(arr[i][j]))
                {
                    row++;
                }
                if(!forCol.add(arr[j][i]))
                {
                    col++;
                }
                if(i==j)
                {
                    k+=arr[i][j];
                }
            }
        }
        System.out.println("Case #"+count+++":"+" "+k+" "+row+" "+col);

    }
}