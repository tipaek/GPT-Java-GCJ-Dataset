import java.util.*; 
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        for(int r=0;r<q;r++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            a[i][j]=sc.nextInt();
            int sum = 0; 
    for (int i=0; i<n; i++) 
        sum += mat[i][i]; 
    System.out.println(sum); 
        }
    }
}