import java.util.*;
class solution
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for (int q=1; q<=t; q++)
        {
            int n=scan.nextInt();
            int[][] arr=new int[n][n];
            int[] row=new int[n];
            int[] col=new int[n];
            for (int i=0; i<n; i++)
            {
                row[i]=-1;
                col[i]=-1;
            }
            int sum=0;
            int count1=0, count2=0;
            int c1=0, c2=0;
            boolean f=true;
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    arr[i][j]=scan.nextInt();
                    if (i==j) sum+=arr[i][j];
                    row[j]=arr[i][j];
                }
                Set<Integer> set = new HashSet<>();
                for (int number : row) {
                    if (set.add(number) == false) {
                        count1++;
                        break;
                    }
                }
            }
            for (int i=0; i<n; i++)
            {
                for (int j=0; j<n; j++)
                {
                    col[j]=arr[j][i];
                }
                Set<Integer> set = new HashSet<>();
                for (int number : col) {
                    if (set.add(number) == false) {
                        count2++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+q+": "+sum+" "+count1+" "+count2);
        }
    }
}