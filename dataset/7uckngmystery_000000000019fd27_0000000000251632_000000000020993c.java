
import java.util.HashSet;
import java.util.Scanner;

public class codeJamproblem1 {
    static boolean checkDuplicatesWithinK(int arr[], int k)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<arr.length; i++)
        {
            // If already present n hash, then we found
            // a duplicate within k distance
            if (set.contains(arr[i]))
                return true;

            // Add this item to hashset
            set.add(arr[i]);

            // Remove the k+1 distant item
            if (i >= k)
                set.remove(arr[i-k]);
        }
        return false;
    }
    static int columnSame(int[][] arr,int n)
    {
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(checkDuplicatesWithinK(arr[i],n))
            {
                c++;
            }
        }
        return c;
    }
    static int rowSame(int[][] arr,int n)
    {
        int r=0;
        for(int i=0;i<n;i++)
        {
            int[] abs= new int[n];
            for(int j=0;j<n;j++)
            {
                abs[j]=arr[i][j];
            }
            if(checkDuplicatesWithinK(abs,n))
            {
                r++;
            }
        }
        return r;

    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {
            int n=sc.nextInt();
            int[][] arr= new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            int sum=0;
            for(int i=0;i<n;i++)
            {
                sum=sum+arr[i][i];
            }
            int col=columnSame(arr,n);
            int row=rowSame(arr,n);
            System.out.println("Case #"+(q+1)+": "+sum+" "+col+" "+row);

        }
    }
}

