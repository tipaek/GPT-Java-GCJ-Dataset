import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
        List<int[]> list=new ArrayList<>();

        for (int i=0;i<tc;i++)
        {
            int[] arr=new int[2];
            arr[0]=s.nextInt();
            arr[1]=s.nextInt();

            list.add(arr);
        }

        int pc=1;
        for (int[] arr:list)
        {
            int n=arr[0];
            int k=arr[1];

            int temp=1;
            int start=temp;
           // System.out.println("val: "+n+" "+k);
            int myr[][]=new int[n][n];

            for (int i=0;i<n;i++)
            {
                temp=start;
                start++;
                for (int j=0;j<n;j++)
                {

                    if(temp<=n)
                    {
                        myr[i][j]=temp;
                        temp++;
                        continue;
                    }
                    else
                    {
                        temp=1;
                        myr[i][j]=temp;
                        temp++;
                    }

                }
            }

            int sum1=0,sum2=0;
            for (int p=0;p<n;p++)
            {
                sum1+=myr[p][p];
            }
            int q=n-1;
            for (int p=0;p<n;p++)
            {
                sum2+=myr[p][q];
                q--;
            }
            //System.out.println(sum1+" "+sum2);
           // printArr(myr,n);
            if (sum1==k || sum2==k)
            {
                System.out.println("Case #"+pc+": POSSIBLE");
                printArr(myr,n);
                pc++;
            }
            else
            {
                System.out.println("Case #"+pc+": IMPOSSIBLE");
                pc++;
            }
        }


    }

    private static void printArr(int[][] myr,int n) {

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                System.out.print(myr[i][j]+" ");


            }
            System.out.println();
        }
    }


}
