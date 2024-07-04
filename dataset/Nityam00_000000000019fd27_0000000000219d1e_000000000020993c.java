
import java.util.*;

class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        try{
        for(int l=1;l<=t;l++)
        {
            int n = sc.nextInt();
            int set[] = new int[n];
            int arr[][] = new int[n][n];
            int sumrow=0,sumcol=0;

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]= sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    set[j]=1;
                }
                for(int j=0;j<n;j++)
                {
                    set[arr[i][j] -1]--;
                    if(set[arr[i][j]-1]<0)
                    {
                        sumrow++;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    set[j]=1;
                }
                for(int j=0;j<n;j++)
                {
                    set[arr[j][i] -1]--;
                    if(set[arr[j][i]-1]<0)
                    {
                        sumcol++;
                        break;
                    }
                }
            }
            int trace=0;
            for(int i =0;i<n;i++)
                trace+=arr[i][i];
            System.out.println("Case #"+l+": "+trace+" "+sumrow+" "+sumcol);

        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
}
